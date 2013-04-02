package v_vues;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import m.Equipe;
import v_ecouteurs.AL_Edition;
import v_utilitaires.*;
import c.ControleurVueEdition;

/**
 * Vue contenant les éléments de l'onglet Edition.
 * @author Florian Garnier
 */
@SuppressWarnings("serial")
public class Vue_Edition extends JPanel
{
	private ControleurVueEdition c ;

	// Composants de la fenetre
	private SelectionTemps selecTps ; // permet de choisir le temps à gérer
	private SelectionEquipe selecEquipe ; // permet de sélectionner l'équipe à déplacer
	private SaisieDeplacementAvecOrientation deplacementJ[] ; // tableau contenant les panel de saisie des déplacements des joueurs
	private SaisieDeplacement deplacementB ; // contient le panel de saisie du déplacement du ballon
	private JButton enregistrer ; // bouton enregistrer

	/**
	 * Création du JFrame et de tous ses composants.
	 * @param _c Le controleur.
	 */
	public Vue_Edition (ControleurVueEdition _c)
	{
		super () ;
		this.c = _c ;

		// Déclaration du listener
		AL_Edition led = new AL_Edition(this) ;

		// Mise en place du GridBagLayout
		this.setLayout (new GridBagLayout()) ;
		GridBagConstraints gbc = new GridBagConstraints () ;

		// Sélection du temps
		this.selecTps = new SelectionTemps () ;
		gbc.gridx = 0 ; gbc.gridy = 0 ;
		gbc.gridwidth = 3 ; gbc.gridheight = 1 ; // 3 car SelectionTemps possède 3 composants
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 0, 5, 0) ;
		this.add (this.selecTps, gbc) ;

		// Sélection de l'équipe
		this.selecEquipe = new SelectionEquipe() ;
		this.selecEquipe.getButtonEquipe1().setEnabled(false) ;
		gbc.gridx = 3 ; gbc.gridy = 0 ;
		gbc.gridwidth = GridBagConstraints.REMAINDER ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 110, 15, 10) ;
		this.add (this.selecEquipe, gbc) ;

		// Saisie des déplacements des joueurs
		this.deplacementJ = new SaisieDeplacementAvecOrientation[this.c.getStrategie().getEq1().getNbJoueur()] ;
		for (int i = 0 ; i < this.deplacementJ.length ; i++)
		{	
			if (this.c.getStrategie().getEq1().getJoueur(i).isMeneur())
				this.deplacementJ[i] = new SaisieDeplacementAvecOrientation ("<html><u>" + this.c.getStrategie().getEq1().getJoueur(i).getNomJ() + "</u></html>") ;
			else
				this.deplacementJ[i] = new SaisieDeplacementAvecOrientation (this.c.getStrategie().getEq1().getJoueur(i).getNomJ()) ;
			gbc.gridx = 0 ; gbc.gridy = i + 2 ; // + 2 car les deux premières lignes sont déjà occupées
			gbc.gridwidth = GridBagConstraints.REMAINDER ; gbc.gridheight = 1 ;
			gbc.anchor = GridBagConstraints.CENTER ;
			gbc.insets = new Insets (3, 0, 3, 0) ;
			this.add (this.deplacementJ[i], gbc) ;
		}

		// Saisie des déplacements du ballon
		this.deplacementB = new SaisieDeplacement ("Ballon") ;
		gbc.gridx = 0 ; gbc.gridy = 9 ;
		gbc.gridwidth = GridBagConstraints.REMAINDER ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (3, 38, 3, 0) ;
		this.add (this.deplacementB, gbc) ;

		// Bouton enregistrer
		this.enregistrer = new JButton ("Enregistrer") ;
		gbc.gridx = 2 ; gbc.gridy = 10 ;
		gbc.gridwidth = GridBagConstraints.REMAINDER ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (10, 140, 10, 0) ;
		this.add (this.enregistrer, gbc) ;

		// Abonnement aux listeners
		this.selecTps.getButtonTpsPrecedent().addActionListener(led) ;
		this.selecTps.getButtonTpsSuivant().addActionListener(led) ;
		this.enregistrer.addActionListener(led) ;
		this.selecEquipe.getButtonEquipe1().addActionListener(led) ;
		this.selecEquipe.getButtonEquipe2().addActionListener(led) ;

		this.majVueEdition() ;
	}


	// Mise à jour de la fenêtre

	/**
	 * Met à jour l'affichage de la fenêtre Vue_Edition avec les données actualisées de la stratégie.
	 */
	public void majVueEdition ()
	{
		// On récupère la valeur du temps en cours
		int tpsEnCours = this.c.getStrategie().getTA() ;

		// On met à jour l'affichage du temps en cours (permet de gérer le changement d'onglet)
		this.selecTps.getTextFieldTpsEnCours().setText(Integer.toString(tpsEnCours)) ;

		// Si on est au temps 0, on désactive le bouton "Temps précédent"
		if (tpsEnCours == 0)
			this.selecTps.getButtonTpsPrecedent().setEnabled(false) ;
		else // Sinon, on le ré-active (si besoin)
			this.selecTps.getButtonTpsPrecedent().setEnabled(true) ;

		// Joueurs

		// On récupère l'équipe en cours de traitement
		Equipe eqSelec = this.getC().getStrategie().getEquipeNum(this.selecEquipe.getNumEquipeSelec()) ;

		for (int i = 0 ; i < this.deplacementJ.length ; i++)
		{	
			// On met à jour les noms de joueurs
			for (int j = 0 ; j < this.deplacementJ.length ; j++)
			{
				if (this.c.getStrategie().getEq1().getJoueur(i).isMeneur())
					this.deplacementJ[i].getNomJ().setText("<html><u>" + eqSelec.getJoueur(i).getNomJ() + "</u></html>") ;
				else
					this.deplacementJ[i].getNomJ().setText(eqSelec.getJoueur(i).getNomJ()) ;
			}

			// On met à jour les champs présentant les déplacements précédents
			if (tpsEnCours == 0) // Si le temps en cours est 0, on vide les champs affichant les déplacements précédents
				for (int j = 0 ; j < this.deplacementJ.length ; j++)
					this.deplacementJ[i].getDepPrec().setText("") ;
			else
				this.deplacementJ[i].getDepPrec().setText(eqSelec.getJoueur(i).getDeplacementAuTemps(tpsEnCours - 1).toFormatSaisie()) ;

			// On met à jour les champs présentant les déplacements saisis pour ce temps
			this.deplacementJ[i].getDepActuel().setText(eqSelec.getJoueur(i).getDeplacementAuTemps(tpsEnCours).toFormatSaisie()) ;

			// On met à jour l'orientation choisi pour chaque déplacement
			this.deplacementJ[i].getListeOrientation().setSelectedItem(eqSelec.getJoueur(i).getDeplacementAuTemps(tpsEnCours).getOrt()) ;
		}

		// Ballon

		// On met à jour le champ présentant le déplacement précédent
		if (tpsEnCours == 0) // Si le temps en cours est 0, on vide le champ affichant le déplacement précédent
			this.deplacementB.getDepPrec().setText("") ;
		else
			this.deplacementB.getDepPrec().setText(this.c.getStrategie().getBallon().getDeplacementAuTemps(tpsEnCours - 1).toFormatSaisie()) ;

		// On met à jour le champ présentant le déplacement saisi pour ce temps
		this.deplacementB.getDepActuel().setText(this.c.getStrategie().getBallon().getDeplacementAuTemps(tpsEnCours).toFormatSaisie()) ;
	}


	// Getters

	/**
	 * Getter du controleur.
	 * @return Le controleur.
	 */
	public ControleurVueEdition getC()
	{
		return this.c ;
	}

	/**
	 * Getter du sélectionneur de temps.
	 * @return Le sélectionneur de temps.
	 */
	public SelectionTemps getSelecTps ()
	{
		return selecTps ;
	}

	/**
	 * Getter de la liste des équipes.
	 * @return La liste des équipes.
	 */
	public SelectionEquipe getSelecEquipe ()
	{
		return selecEquipe ;
	}

	/**
	 * Getter du tableau des JPanel de saisie des déplacements des joueurs.
	 * @return Le tableau des JPanel de saisie des déplacements des joueurs.
	 */
	public SaisieDeplacementAvecOrientation[] getDeplacementJ ()
	{
		return deplacementJ ;
	}

	/**
	 * Getter du JPanel de saisie des déplacements du ballon.
	 * @return Le JPanel de saisie des déplacements du ballon.
	 */
	public SaisieDeplacement getDeplacementB()
	{
		return deplacementB ;
	}

	/**
	 * Getter du bouton enregistrer.
	 * @return Le bouton enregistrer.
	 */
	public JButton getButtonEnregistrer ()
	{
		return enregistrer ;
	}


	// Accesseurs

	public SaisieDeplacementAvecOrientation getSaisieDeplacementJ (int _i)
	{
		return deplacementJ[_i] ;
	}


	// Utilitaires

	private String[] autoCompletionNomJ (Equipe _eq)
	{
		String[] tabNom = new String[_eq.getNbJoueur()] ;
		int tailleNomMax = 0 ;

		// On récupère la taille du nom du joueur le plus long
		for (int i = 0 ; i < _eq.getNbJoueur() ; i++)
			if (tailleNomMax < _eq.getJoueur(i).getNomJ().length())
				tailleNomMax = _eq.getJoueur(i).getNomJ().length() ;

		// On complète les noms des joueurs avec des espaces pour qu'ils aient tous la même taille
		// (et ne créent pas de décalage à l'affichage)
		for (int i = 0 ; i < _eq.getNbJoueur() ; i++)
		{
			tabNom[i] = _eq.getJoueur(i).getNomJ() ;
			for (int j = tabNom[i].length() ; j < tailleNomMax ; j++)
				tabNom[i] = tabNom[i] + " " ;
		}

		return tabNom ;
	}
}
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

	// Constante
	private static final int NOMBRE_JOUEURS = 6 ;

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
		this.deplacementJ = new SaisieDeplacementAvecOrientation[NOMBRE_JOUEURS] ;
		for (int i = 0 ; i < NOMBRE_JOUEURS ; i++)
		{	
			this.deplacementJ[i] = new SaisieDeplacementAvecOrientation ("Joueur " + (i + 1), i + 1) ;
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
		gbc.insets = new Insets (3, 78, 3, 0) ;
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
		
		this.majVueEdition() ;
	}
	
	
	// Mise à jour de la fenêtre
	
	/**
	 * Met à jour l'affichage de la fenêtre Vue_Edition avec les données actualisées de la stratégie.
	 */
	public void majVueEdition ()
	{
		// On récupère l'équipe en cours de traitement
		Equipe eqSelec = this.getC().getStrategie().getEquipeNum(this.selecEquipe.getNumEquipeSelec()) ;
		
		for (int i = 0 ; i < this.deplacementJ.length ; i++)
		{
			int tpsEnCours = this.selecTps.getTempsSelectionne() ; // temps en cours
			
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
	 * Getter du tableau des structures de saisie des déplacements des joueurs.
	 * @return Le tableau des structures de saisie des déplacements des joueurs.
	 */
	public SaisieDeplacementAvecOrientation[] getDeplacementJ ()
	{
		return deplacementJ ;
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
}
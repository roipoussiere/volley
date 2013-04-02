package v_ecouteurs;

import java.awt.event.*;

import javax.swing.JOptionPane;

import m.Equipe;
import v_vues.Vue_Edition;

/**
 * ActionListener des boutons de l'onglet Edition
 * @author Florian Garnier
 */
public class AL_Edition implements ActionListener
{
	private Vue_Edition ve;

	/**
	 * Constructeur de l'ActionListener.
	 * @param _ve Vue d'Edition d'une stratégie.
	 */
	public AL_Edition(Vue_Edition _ve)
	{
		this.ve = _ve;
	}

	/**
	 * Ecoute les actions effectués sur les composants de la fenêtre.
	 * @param _ae Evenement.
	 */
	@Override
	public void actionPerformed (ActionEvent _ae)
	{
		// Clic sur le bouton "Temps précédent"
		if (_ae.getSource().equals(this.ve.getSelecTps().getButtonTpsPrecedent()))
		{
			// On appelle le listener intégré dans SelectionTemps
			this.ve.getSelecTps().actionPerformed(_ae) ;
			System.out.println("<test_flo> Temps en cours (précédent) : " + this.ve.getSelecTps().getTempsSelectionne()) ;
			// On met à jour le temps actuel dans Strategie
			this.ve.getC().getStrategie().setTA(this.ve.getSelecTps().getTempsSelectionne()) ;
			// On met à jour les deux onglets
			this.ve.majVueEdition() ;
			this.ve.getC().getCP().getCVL().majVue() ;
		}

		// Clic sur le bouton "Temps suivant"
		if (_ae.getSource().equals(this.ve.getSelecTps().getButtonTpsSuivant()))
		{
			// On appelle le listener intégré dans SelectionTemps
			this.ve.getSelecTps().actionPerformed(_ae) ;
			System.out.println("<test_flo> Temps en cours (suivant) : " + this.ve.getSelecTps().getTempsSelectionne()) ;
			// On met à jour le temps actuel dans Strategie
			this.ve.getC().getStrategie().setTA(this.ve.getSelecTps().getTempsSelectionne()) ;
			// Si le temps affiché n'existe pas encotre dans la stratégie, on le crée
			if (this.ve.getSelecTps().getTempsSelectionne() >= this.ve.getC().getStrategie().getNbTemps())
				this.ve.getC().creerNouveauTemps() ;
			// On met à jour les deux onglets
			this.ve.majVueEdition() ;
			this.ve.getC().getCP().getCVL().getVueLecture().majVue() ;
		}

		// Clic sur le bouton E1 ou E2
		if (_ae.getSource().equals(this.ve.getSelecEquipe().getButtonEquipe1()) || _ae.getSource().equals(this.ve.getSelecEquipe().getButtonEquipe2()))
		{
			this.ve.getSelecEquipe().actionPerformed(_ae) ;
			System.out.println("<test_flo> Equipe sélectionnée : " + this.ve.getSelecEquipe().getNumEquipeSelec());
			this.ve.majVueEdition() ;
		}

		// Clic sur le bouton "Enregistrer"
		if (_ae.getSource().equals(this.ve.getButtonEnregistrer()))
		{
			this.ve.getC().enregistrerDeplacements(this.ve.getC().getStrategie().getEquipeNum(this.ve.getSelecEquipe().getNumEquipeSelec()), this.ve.getSelecTps().getTempsSelectionne()) ;
		}
	}


	// Méthodes annexes

	/**
	 * Permet de savoir si tous les changements ont été sauvegardés.
	 * @return TRUE si oui, FALSE sinon.
	 */
	private boolean isSaved (Equipe _eq)
	{
		boolean sauvegarde = true ;
		int tpsEnCours = this.ve.getSelecTps().getTempsSelectionne() ;

		// Contrôle des joueurs
		for (int i = 0 ; i < this.ve.getDeplacementJ().length ; i++)
		{
			// Si le déplacement actuellement saisi est différent du déplacement contenu en mémoire...
			if (!this.ve.getSaisieDeplacementJ(i).getDepActuel().getText().equals(_eq.getJoueur(i).getDeplacementAuTemps(tpsEnCours).toFormatSaisie()))
				sauvegarde = false ;

			// Si l'orientation actuellement sélectionnée est différente de celle contenue en mémoire...
			if (!this.ve.getSaisieDeplacementJ(i).getListeOrientation().getSelectedItem().equals(_eq.getJoueur(i).getDeplacementAuTemps(tpsEnCours).getOrt()))
				sauvegarde = false ;
		}

		// Contrôle du ballon
		if (!this.ve.getDeplacementB().getDepActuel().getText().equals(this.ve.getC().getStrategie().getBallon().getDeplacementAuTemps(tpsEnCours).toFormatSaisie()))
			sauvegarde = false ;

		if (!sauvegarde)
		{
			String[] options = {"Enregistrer", "Ignorer", "Annuler"} ;
			int od = JOptionPane.showOptionDialog (this.ve, "Le temps a été modifié.\n" +
					"Souhaitez-vous enregistrer les modifications apportées ?", null, JOptionPane.DEFAULT_OPTION,
					JOptionPane.WARNING_MESSAGE, null, options, options[0]) ;
			switch (od)
			{
			case 0 : // Enregistrer
				this.ve.getC().enregistrerDeplacements(_eq, tpsEnCours) ;
				sauvegarde = true ;
				break ;

			case 1 : // Ignorer
				sauvegarde = true ;
				break ;

			case 2 : // Annuler
				sauvegarde = false ;
				break ;
			}
		}

		return sauvegarde ;
	}
}
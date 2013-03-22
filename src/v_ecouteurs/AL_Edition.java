package v_ecouteurs;

import java.awt.event.*;
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
			// ENREGISTRER ICI (sinon on perd le temps précédent)
			// On appelle le listener intégré dans SelectionTemps
			this.ve.getSelecTps().actionPerformed(_ae) ;
			System.out.println("<test_flo> Temps en cours (précédent) : " + this.ve.getSelecTps().getTempsSelectionne()) ;
			// On met à jour le temps actuel dans Strategie
			this.ve.getC().getStrategie().setTA(this.ve.getSelecTps().getTempsSelectionne()) ;
			// On met à jour l'affichage de la fenêtre
			this.ve.majVueEdition() ;
		}

		// Clic sur le bouton "Temps suivant"
		if (_ae.getSource().equals(this.ve.getSelecTps().getButtonTpsSuivant()))
		{
			// ENREGISTRER ICI (sinon on perd le temps précédent)
			// On appelle le listener intégré dans SelectionTemps
			this.ve.getSelecTps().actionPerformed(_ae) ;
			System.out.println("<test_flo> Temps en cours (suivant) : " + this.ve.getSelecTps().getTempsSelectionne()) ;
			// On met à jour le temps actuel dans Strategie
			this.ve.getC().getStrategie().setTA(this.ve.getSelecTps().getTempsSelectionne()) ;
			// Si le temps affiché n'existe pas encotre dans la stratégie, on le crée
			if (this.ve.getSelecTps().getTempsSelectionne() >= this.ve.getC().getStrategie().getNbTemps())
				this.ve.getC().creerNouveauTemps() ;
			// On met à jour l'affichage de la fenêtre
			this.ve.majVueEdition() ;
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
}
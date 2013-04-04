package v_ecouteurs;

import java.awt.event.*;

import v_vues.Vue_Lecture;

/**
 * ActionListener des boutons de l'onglet Lecture
 * @author Nathanaël Jourdane
 */
public class AL_Lecture implements ActionListener, FocusListener
{
	private Vue_Lecture vl;

	/**
	 * Constructeur de l'ActionListener.
	 * @param _vl Vue de lecture d'une stratégie.
	 */
	public AL_Lecture(Vue_Lecture _vl)
	{
		this.vl = _vl;
	}

	/**
	 * Ecoute l'action du clic sur un bouton.
	 * @param _ae Evenement de clic sur un bouton.
	 */
	@Override
	public void actionPerformed(ActionEvent _ae)
	{
		// Clic sur le bouton "Temps précédent" ou "Temps suivant"
		if (_ae.getSource().equals(this.vl.getSelectTps().getButtonTpsPrecedent()) || _ae.getSource().equals(this.vl.getSelectTps().getButtonTpsSuivant()))
		{
			// On appelle le listener intégré dans SelectionTemps
			this.vl.getSelectTps().actionPerformed(_ae) ;
			// On met à jour le temps actuel dans Strategie
			this.vl.getC().getCP().getS().setTA(this.vl.getSelectTps().getTempsSelectionne()) ;
			// On met à jour les deux onglets
			this.vl.majVue() ;
			this.vl.getC().getCP().getCVE().majVue() ;
			
			// On met à jour la fenêtre de dessin.
			this.vl.getC().getCP().getCVD().majDessin();
		}
	}

	@Override
	public void focusGained (FocusEvent e)
	{
		
	}

	@Override
	public void focusLost (FocusEvent e)
	{
		this.vl.getC().majNomStrategie(this.vl.getSaisieNomFichier().getText()) ;
	}
}
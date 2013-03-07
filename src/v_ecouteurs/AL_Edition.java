package v_ecouteurs;

import java.awt.event.*;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import v_vues.Vue_Edition;

/**
 * ActionListener des boutons de l'onglet Edition
 * @author Florian Garnier
 */
public class AL_Edition implements ActionListener, DocumentListener
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
		if (_ae.getSource().equals(this.ve.getSelecTps().getTpsPrecedent()))
		{
			// On appelle le listener intégré dans SelectionTemps
			this.ve.getSelecTps().actionPerformed(_ae) ;
		}

		// Clic sur le bouton "Temps suivant"
		if (_ae.getSource().equals(this.ve.getSelecTps().getTpsSuivant()))
		{
			// On appelle le listener intégré dans SelectionTemps
			this.ve.getSelecTps().actionPerformed(_ae) ;
			// On désactive le bouton "Temps suivant" jusqu'au remplissage d'au moins 1 champ de déplacement
			this.ve.getSelecTps().getTpsSuivant().setEnabled(false) ;
		}
	}

	@Override
	public void changedUpdate (DocumentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertUpdate (DocumentEvent e)
	{
		int tpsEnCours = Integer.parseInt(this.ve.getSelecTps().getTpsEnCours().getText()) ;
		// On appelle la méthode de MAJ du contrôleur en passant en paramètre le temps concerné
		this.ve.getC().majStrategieE1(tpsEnCours) ;
	}

	@Override
	public void removeUpdate (DocumentEvent e) {
		// TODO Auto-generated method stub

	}
}
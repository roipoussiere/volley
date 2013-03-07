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
			// On récupère la valeur du temps en cours
			int tps = Integer.parseInt(this.ve.getSelecTps().getTpsEnCours().getText()) ;
			// On décrémente de 1
			tps-- ;
			// On inscrit la nouvelle valeur dans le champs
			this.ve.getSelecTps().getTpsEnCours().setText(Integer.toString(tps)) ;
			// On désactive le bouton "Temps précédent" si on est revenu au temps 0
			if (tps == 0) {
				this.ve.getSelecTps().getTpsPrecedent().setEnabled(false) ;
			}
			// On active le bouton "Temps suivant" (si besoin)
			this.ve.getSelecTps().getTpsSuivant().setEnabled(true) ;
		}

		// Clic sur le bouton "Temps suivant"
		if (_ae.getSource().equals(this.ve.getSelecTps().getTpsSuivant()))
		{
			// On récupère la valeur du temps en cours
			int tps = Integer.parseInt(this.ve.getSelecTps().getTpsEnCours().getText()) ;
			// On incrémente de 1
			tps++ ;
			// On inscrit la nouvelle valeur dans le champs
			this.ve.getSelecTps().getTpsEnCours().setText(Integer.toString(tps)) ;
			// On active le bouton "Temps précédent" (si besoin)
			this.ve.getSelecTps().getTpsPrecedent().setEnabled(true) ;
			// On désactive le bouton "Temps suivant" jusqu'au remplissage d'au moins 1 champs de déplacement
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
		// On appelle la méthode de MAJ du contrôleur en passant en paramètre le temps concerné
		this.ve.getC().majStrategieE1(Integer.parseInt(this.ve.getSelecTps().getTpsEnCours().getText())) ;
	}

	@Override
	public void removeUpdate (DocumentEvent e) {
		// TODO Auto-generated method stub

	}
}
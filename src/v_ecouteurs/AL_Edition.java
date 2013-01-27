package v_ecouteurs;

import java.awt.event.*;

import v_vues.Vue_Edition;

/**
 * ActionListener des boutons de l'onglet Edition
 * @author Nathanaël Jourdane
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
	 * Ecoute l'action du clic sur un bouton.
	 * @param _ae Evenement de clic sur un bouton.
	 */
	public void actionPerformed(ActionEvent _ae)
	{
		//_ae.getSource() ...
	}
}
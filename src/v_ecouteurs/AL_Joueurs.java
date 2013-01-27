package v_ecouteurs;

import java.awt.event.*;

import v_vues.Vue_Joueurs;

/**
 * ActionListener des boutons de la fenêtre Joueurs
 * @author Nathanaël Jourdane
 */
public class AL_Joueurs implements ActionListener
{
	private Vue_Joueurs vj;

	/**
	 * Constructeur de l'ActionListener.
	 * @param _vj Vue de la fenêtre Joueurs.
	 */
	public AL_Joueurs(Vue_Joueurs _vj)
	{
		this.vj = _vj;
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
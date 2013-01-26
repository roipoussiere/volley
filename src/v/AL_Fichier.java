package v;

import java.awt.event.*;

/**
 * Ecouteur du bouton Parcourir.
 * @see c.Controleur
 * @author Nathanaël Jourdane
 */
public class AL_Fichier implements ActionListener
{
	private Vue_Fichier vfi;

	/**
	 * Constructeur de l'ActionListener.
	 * @param _vl Vue de lecture d'une stratégie.
	 * @author Nathanaël Jourdane
	 */
	public AL_Fichier(Vue_Fichier _vfi)
	{
		this.vfi = _vfi;
	}

	/**
	 * Ouvre une fenêtre invitant l'utilisateur à choisir un fichier de stratégie.
	 * @param _ae Evenement de clic sur le bouton Parcourir.
	 * @author Nathanaël Jourdane
	 */
	public void actionPerformed(ActionEvent _ae)
	{
		this.vfi.getC().vf_parcourir();
		this.vfi.majLibelle();
	}
}
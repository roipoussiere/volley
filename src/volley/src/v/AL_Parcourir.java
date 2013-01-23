package v;

import java.awt.event.*;

/**
 * Ecouteur du bouton Parcourir.
 * @see c.Controleur#vl_parcourir()
 * @author Nathanaël Jourdane
 */
public class AL_Parcourir implements ActionListener
{
	private Vue_Fichier vf;

	/**
	 * Constructeur de l'ActionListener.
	 * @param _vl Vue de lecture d'une stratégie.
	 * @author Nathanaël Jourdane
	 */
	public AL_Parcourir(Vue_Fichier _vf)
	{
		this.vf = _vf;
	}

	/**
	 * Ouvre une fenêtre invitant l'utilisateur à choisir un fichier de stratégie.
	 * @param _ae Evenement de clic sur le bouton Parcourir.
	 * @author Nathanaël Jourdane
	 */
	public void actionPerformed(ActionEvent _ae)
	{
		this.vf.getC().setNomFichier(this.vf.getC().vf_parcourir());
	}
}
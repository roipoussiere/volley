package v;

import java.awt.event.*;

/**
 * Ecouteur du bouton Parcourir.
 * @see c.Controleur#vl_parcourir()
 * @author Nathanaël Jourdane
 */
public class AL_Parcourir implements ActionListener
{
	private Vue_Lecture vl;

	/**
	 * Constructeur de l'ActionListener
	 * @param _vl Vue de lecture d'une stratégie.
	 * @author Nathanaël Jourdane
	 */
	public AL_Parcourir(Vue_Lecture _vl)
	{
		this.vl = _vl;
	}

	/**
	 * Annuler la lecture d'une vue.
	 * @param _ae Evenement de clic sur le bouton Parcourir.
	 * @author Nathanaël Jourdane
	 */
	public void actionPerformed(ActionEvent _ae)
	{
		this.vl.getC().vl_parcourir();
	}
}
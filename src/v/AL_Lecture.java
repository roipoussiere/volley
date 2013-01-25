package v;

import java.awt.event.*;

/**
 * Ecouteur du bouton Lecture.
 * @see c.Controleur#vl_lireStrategie()
 * @author Nathanaël Jourdane
 */
public class AL_Lecture implements ActionListener
{
	private Vue_Lecture vl;

	/**
	 * Constructeur de l'ActionListener.
	 * @param _vl Vue de lecture d'une stratégie.
	 * @author Nathanaël Jourdane
	 */
	public AL_Lecture(Vue_Lecture _vl)
	{
		this.vl = _vl;
	}

	/**
	 * Lis la stratégie sélectionnée.
	 * @param _ae Evenement de clic sur le bouton Lecture.
	 * @author Nathanaël Jourdane
	 */
	public void actionPerformed(ActionEvent _ae)
	{
		this.vl.getC().vl_lireStrategie();
	}
}
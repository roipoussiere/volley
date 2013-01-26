package v;

import java.awt.event.*;

/**
 * ActionListener des boutons de l'onglet Lecture
 * @author Nathanaël Jourdane
 */
public class AL_Lecture implements ActionListener
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
	public void actionPerformed(ActionEvent _ae)
	{
		//_ae.getSource() ...
	}
}
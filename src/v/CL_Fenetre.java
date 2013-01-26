package v;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Écouteur des onglets.
 * @see c.Controleur#clicOnglet(int)
 * @author Nathanaël Jourdane
 */
public class CL_Fenetre implements ChangeListener
{
	private Vue_Fenetre vf;
	
	/**
	 * Constructeur du ChangeListener.
	 * @param _vf Vue de la fenêtre.
	 */
	public CL_Fenetre(Vue_Fenetre _vf)
	{
		this.vf = _vf;
	}

	/**
	 * Ecoute l'action du clic sur un onglet.
	 * @param _ce Évenement de clic sur le bouton Lecture.
	 */
	public void stateChanged(ChangeEvent _ce)
	{
		this.vf.getC().clicOnglet(this.vf.getOngletOuvert());
	}
}

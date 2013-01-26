package v;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Écouteur des onglets.
 * @see c.Controleur#clicOnglet()
 * @author Nathanaël Jourdane
 */
public class CL_Fenetre implements ChangeListener
{
	private Vue_Fenetre vf;
	
	/**
	 * Constructeur du ChangeListener.
	 * @param _vf Vue de la fenêtre.
	 * @author Nathanaël Jourdane
	 */
	public CL_Fenetre(Vue_Fenetre _vf)
	{
		this.vf = _vf;
	}

	/**
	 * Ecoute l'action du clic sur un onglet.
	 * @param _ae Évenement de clic sur le bouton Lecture.
	 * @author Nathanaël Jourdane
	 */
	public void stateChanged(ChangeEvent _ce)
	{
		this.vf.getC().clicOnglet(this.vf.getOngletOuvert());
	}
}

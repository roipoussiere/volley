package v;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Ecouteur des onglets
 * @see c.Controleur#
 * @author Nathanaël Jourdane
 */
public class CL_Fenetre implements ChangeListener
{
	private Vue_Fenetre vf;
	
	/**
	 * Constructeur du ChangeListener.
	 * @param _vf Vue de la fenetre
	 * @author Nathanaël Jourdane
	 */
	public CL_Fenetre(Vue_Fenetre _vf)
	{
		this.vf = _vf;
	}

	/**
	 * Ouvre éventuellement la fenetre de terrain.
	 * @param _ae Evenement de clic sur le bouton Lecture.
	 * @author Nathanaël Jourdane
	 */
	public void stateChanged(ChangeEvent _ce) {
		this.vf.getC().afficherTerrain(this.vf.getOngletOuvert());
	}
}

package v_ecouteurs;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import v_vues.Vue_Fenetre;

/**
 * Écouteur des onglets.
 * @see c.ControleurVueFenetre#clicOnglet()
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
	@Override
	public void stateChanged(ChangeEvent _ce)
	{
		this.vf.getC().clicOnglet();
	}
}

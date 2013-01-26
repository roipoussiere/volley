package v;

import javax.swing.*;

import c.Controleur;

/**
 * Vue contenant les élements de l'onglet Lecture.
 */
public class Vue_Lecture extends JPanel
{
	private static final long serialVersionUID = 1L;
	private Controleur c;
	
	// Composants de la fenêtre
	

	/**
	 * Création du JFrame et de tous ses composants.
	 * @param _c Constrôleur.
	 * @author Nathanaël Jourdane
	 */
	public Vue_Lecture (Controleur _c)
	{
		super ();
		this.c = _c;
}
	
	/**
	 * Getter du contrôleur.
	 * @return Le contrôleur.
	 * @author Nathanaël Jourdane
	 */
	public Controleur getC()
	{
		return this.c;
	}

}
package v_vues;

import javax.swing.*;
import c.Controleur;

/**
 * Vue contenant les élements de l'onglet Edition.
 */
@SuppressWarnings("serial")
public class Vue_Edition extends JPanel
{
	private Controleur c;
	
	// Composants de la fenêtre

	
	/**
	 * Création du JFrame et de tous ses composants.
	 * @param _c Le contrôleur.
	 */
	public Vue_Edition (Controleur _c)
	{
		super ();
		this.c = _c;
	}
	
	/**
	 * Getter du contrôleur.
	 * @return Le contrôleur.
	 */
	public Controleur getC()
	{
		return this.c;
	}
}
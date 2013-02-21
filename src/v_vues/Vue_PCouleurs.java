package v_vues;

import c.Controleur;
import javax.swing.*;

/**
 * Vue contenant les élements de l'onglet Couleurs.
 * @author Nathanaël Jourdane
 */
@SuppressWarnings("serial")
public class Vue_PCouleurs extends JPanel
{
	private Controleur c;
	
	// Composants de la fenêtre
	

	/**
	 * Création du JFrame et de tous ses composants.
	 * @param _c Contrôleur.
	 */
	public Vue_PCouleurs (Controleur _c)
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
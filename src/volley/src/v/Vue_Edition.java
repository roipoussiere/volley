package v;

import javax.swing.*;
import c.Controleur;

/**
 * Vue contenant les élements de l'onglet Edition.
 */
public class Vue_Edition extends JPanel
{
	private static final long serialVersionUID = 1L;
	private Controleur c;
	
	// Composants de la fenêtre

	
	/**
	 * Création du JFrame et de tous ses composants.
	 * @param _c Le contrôleur.
	 * @author Nathanaël Jourdane
	 */
	public Vue_Edition (Controleur _c)
	{
		super ();
		this.c = _c;

		this.add(new JLabel ("Sélectionner une stratégie :"));
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
package v_vues;

import javax.swing.*;

import c.Controleur;

/**
 * Vue contenant les élements de l'onglet Grille.
 * @author Nathanaël Jourdane
 */
@SuppressWarnings("serial")
public class Vue_PGrille extends JPanel
{
	private Controleur c;
	
	// Composants de la fenêtre
	

	/**
	 * Création du JFrame et de tous ses composants.
	 * @param _c Contrôleur.
	 */
	public Vue_PGrille (Controleur _c)
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
package v;

import javax.swing.JFileChooser;
import c.Controleur;

/**
 * Fenetre de sélection du fichier.
 * @author Nathanaël Jourdane
 */
public class Vue_Parcourir extends JFileChooser
{
	private static final long serialVersionUID = 1L;
	private Controleur c;
	
	/**
	 * Crée le JFileChooser.
	 * @param _c Le contrôleur.
	 * @author Nathanaël Jourdane
	 */
	public Vue_Parcourir(Controleur _c)
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

package v;

import javax.swing.JFileChooser;
import c.Controleur;

/**
 * Fenetre de sélection du fichier.
 * @author Nathanaël Jourdane
 */
public class Vue_Parcourir extends JFileChooser
{
	private Controleur c;
	
	/**
	 * 
	 * @param _c Le constructeur.
	 * @author Nathanaël Jourdane
	 */
	public Vue_Parcourir(Controleur _c)
	{
		this.c = _c;
	}
	
}

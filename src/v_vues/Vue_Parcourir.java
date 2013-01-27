package v_vues;

import javax.swing.JFileChooser;
import c.Controleur;

/**
 * Fenetre de sélection du fichier.
 * @author Nathanaël Jourdane
 */
@SuppressWarnings("serial")
public class Vue_Parcourir extends JFileChooser
{
	private Controleur c;
	
	/**
	 * Crée le JFileChooser.
	 * @param _c Le contrôleur.
	 */
	public Vue_Parcourir(Controleur _c)
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

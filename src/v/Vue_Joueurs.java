package v;

import javax.swing.*;

import c.Controleur;

/**
 * Vue contenant les élements de l'onglet Joueur.
 */
public class Vue_Joueurs extends JPanel
{
	private static final long serialVersionUID = 1L;
	private Controleur c;
	
	// Composants de la fenêtre
	private JRadioButton jrbTC; // terrain complet
	private JRadioButton jrbDT; // demi-terrain
	private ButtonGroup bgTerrain;
	
	/**
	 * Création du JFrame et de tous ses composants.
	 * @param _c Constrôleur.
	 * @author Nathanaël Jourdane
	 */
	public Vue_Joueurs (Controleur _c)
	{
		super ();
		this.c = _c;
		
		this.bgTerrain = new ButtonGroup();
		
		this.jrbDT = new JRadioButton("Demi terrain", true);
		this.bgTerrain.add(this.jrbDT);
		this.add(this.jrbDT);
		
		this.jrbTC = new JRadioButton("Terrain complet", false);
		this.bgTerrain.add(this.jrbTC);
		this.add(this.jrbTC);
		
	}
	
	/**
	 * Getter du mode d'affichage : demi terrain ou terrain compet.
	 * @return True si l'utilisateur a sélectionné le mode demi-terrain, false s'il a séletionné le mode terrain complet.
	 * @author Nathanaël Jourdane
	 */
	public boolean getModeDemiT()
	{
		return this.jrbDT.isSelected();
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
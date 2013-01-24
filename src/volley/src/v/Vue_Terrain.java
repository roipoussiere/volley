package v;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import c.Controleur;

/**
 * 
 */
@SuppressWarnings("serial")
public class Vue_Terrain extends JFrame implements WindowListener
{
	private Controleur c;
	private Vue_Dessin vd;
	
	private boolean demiT;
	
	/**
	 * Création de la fenêtre représentant le terrain de volley.
	 * @param _c Le contrôleur.
	 * @author Nathanaël Jourdane
	 */
	public Vue_Terrain(Controleur _c, boolean _demiT)
	{
		super ("Terrain");
		this.c = _c;
		this.demiT = _demiT;
		
		this.addWindowListener(this); // On abonne la fenêtre à elle-même.
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		
				
		if (this.demiT) // Si demi-terrain : zone de 11*10 cases de 50px chacune = 550*500	
			this.setSize(557, 528);
		else // Si terrain complet : zone de 11*20 cases de 36px*36px chacune = 396*720
			this.setSize(403, 729);

		Color vert = new Color(0, 100, 0);
		this.setBackground(vert);
	}

	/**
	 * Dessine le quadrillage sur terrain, qui varie en fonction du mode demi-terrain/terrain complet et lecture/edition.
	 * @author Nathanaël Jourdane
	 */
	public void dessiner(int _styleQ)
	{
		vd = new Vue_Dessin(this, _styleQ);
		this.add(vd);
	}
	
	/**
	 * Getter du mode de la taille du terrain.
	 * @return True si c'est une demi-terrain, false sinon.
	 * @author Nathanaël Jourdane
	 */
	public boolean getDemi()
	{
		return this.demiT;
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

	/**
	 * Action qui suit la fermeture de la fenêtre.
	 * @param arg0 L'évenement de clic sur le bouton de fermeture de la fenêtre.
	 * @author Nathanaël Jourdane
	 */
	public void windowClosing(WindowEvent arg0)
	{
		this.getC().vt_fermer();
	}
	
	// Ces méthodes sont les autres évenements possibles sur la fenêtre, que nous utilisons pas.
	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent arg0) {}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}
}
package v;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import c.Controleur;

/**
 * 
 */
public class Vue_Terrain extends JFrame implements WindowListener
{
	private static final long serialVersionUID = 1L;
	private Controleur c;
	private Vue_Dessin vd;
	
	private boolean quadri;
	private boolean demiT;
	private int tCase;
	
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
		
		// Si demi-terrain : zone de 11*11 cases de 50px chacune = 550*550			
		if (this.demiT)
		{
			this.setSize(550, 550);
			this.tCase = 50;
		}
		// Si terrain complet : zone de 11*20 cases de 36px*36px chacune = 396*720
		else
		{
			this.tCase = 36;
			this.setSize(396, 720);
		}

		this.setResizable(false);

		Color vert = new Color(0, 100, 0);
		this.setBackground(vert);
	}

	/**
	 * Dessine le quadrillage sur terrain, qui varie en fonction du mode demi-terrain/terrain complet et lecture/edition.
	 * @author Nathanaël Jourdane
	 */
	public void quadriller()
	{
		vd = new Vue_Dessin(this);
		this.add(vd);
	}
		
	/**
	 * Getter de la taille des cases.
	 * @return La taille des cases du quadrillage
	 * @author Nathanaël Jourdane
	 */
	public int getTCase()
	{
		return this.tCase;
	}
	
	/**
	 * Getter du mode de quadrillage.
	 * @return True si on doit afficher le quadillage, false sinon.
	 * @author Nathanaël Jourdane
	 */
	public boolean getQuadri()
	{
		return this.quadri;
	}
	
	/**
	 * Setter du mode de quadrillage.
	 * @param True si on doit afficher le quadillage, false sinon.
	 * @author Nathanaël Jourdane
	 */
	public void setQuadri(boolean _quadri)
	{
		this.quadri = _quadri;
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
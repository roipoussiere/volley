package v;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import c.Controleur;

/**
 * 
 */
public class Vue_Terrain extends JFrame implements WindowListener
{
	private static final long serialVersionUID = 1L;
	private Controleur c;

	/**
	 * Création de la fenêtre représentant le terrain de volley.
	 * @param _c Le contrôleur.
	 * @author Nathanaël Jourdane
	 */
	public Vue_Terrain(Controleur _c, boolean _demiT)
	{
		super ("Terrain");
		this.c = _c;

		this.addWindowListener(this); // On abonne la fenêtre à elle-même.
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		if (_demiT)
			this.setSize(550, 550);			
			// demi-terrain : zone 11*11 cases de 50px chacune = 550*550
		else
			this.setSize(396, 720);
			// terrain complet : zone de 11*20 cases de 36px*36px chacune = 396*720

		this.setResizable(false);

		Color vert = new Color(0, 100, 0);
		this.getContentPane().setBackground(vert);
	}

	public void quadrillage(boolean _lecture)
	{
		System.out.println("lecture : " + _lecture);
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
	
	// Ces méthodes sont les autres évenements possibles sur la fenêtre que nous utilisons pas.
	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent arg0) {}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}
}
package v;

import java.awt.event.*;
import javax.swing.*;
import c.Controleur;

/**
 * Vue de la fenêtre représentant le terrain de volley.
 * @author Nathanaël Jourdane
 */
@SuppressWarnings("serial")
public class Vue_Terrain extends JFrame implements WindowListener
{
	private Controleur c;
	private Vue_Dessin vd;
	
	/**
	 * Création de la fenêtre représentant le terrain de volley.
	 * @param _c Le contrôleur.
	 */
	public Vue_Terrain(Controleur _c)
	{
		super ("Terrain");
		this.c = _c;
		
		this.addWindowListener(this); // On abonne la fenêtre à elle-même.
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		
		this.setTaille();
		
		vd = new Vue_Dessin(this);
	    this.setContentPane(vd);
	}
	
	/**
	 * Dessine le quadrillage sur le terrain, qui varie en fonction du mode Lecture ou Edition.
	 * @param _styleQ Le style de quadrillage du terrain
	 */
	public void dessiner(int _styleQ)
	{
		vd.setStyleQ(_styleQ);
		vd.repaint();
	}
	
	public void setTaille()
	{
		boolean demiT = this.getC().getP().isDemiT();
		System.out.println("Redimentionnement du terrain. demi-terrin : " + demiT);
		// Si demi-terrain : zone de 11*10 cases de 50px chacune = 550*500 + bordures de la fenêtre
		if (demiT)	
			this.setSize(557, 528);
		else // Si terrain complet : zone de 11*20 cases de 36px*36px chacune = 396*720
			this.setSize(403, 743);
	}
	
	/**
	 * Getter du contrôleur.
	 * @return Le contrôleur.
	 */
	public Controleur getC()
	{
		return this.c;
	}
	
	/**
	 * Action qui suit la fermeture de la fenêtre.
	 * @param arg0 L'évenement de clic sur le bouton de fermeture de la fenêtre.
	 */
	public void windowClosing(WindowEvent arg0)
	{
		this.getC().quitter();
	}
	
	// Ces méthodes sont les autres évenements possibles sur la fenêtre, que nous utilisons pas.
	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent arg0) {}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}
}
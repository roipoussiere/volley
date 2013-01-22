package v;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import c.Controleur;

/**
 * Fenêtre de lecture d'une stratégie.<br/>
 * Contient tous les élements de la fenêtre.
 */
public class Vue_Edition extends JFrame implements WindowListener
{
	private static final long serialVersionUID = 1L;
	private Controleur c;
	
	// Composants de la fenêtre

	
	/**
	 * Création de la fenêtre et de tous ses composants.
	 * @param _c Constructeur.
	 * @author Nathanaël Jourdane
	 */
	public Vue_Edition (Controleur _c)
	{
		super ("Lecture d'une stratégie");
		
		this.addWindowListener(this); // On abonne la fenêtre à elle-même.

		this.c = _c;

		this.setSize(800, 600);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE );

		this.add(new JLabel ("Sélectionner une stratégie :"));
	}
			
	/**
	 * Getter du contrôleur.
	 * @return Le constructeur de l'éditeur de sondage.
	 * @author Nathanaël Jourdane
	 */
	public Controleur getC()
	{
		return this.c;
	}

	/**
	 * Ferme la fenêtre au clic sur la croix rouge.
	 * @param arg0 L'évenement du clic sur le bouton rouge de la fenêtre.
	 * @author Nathanaël Jourdane
	 */
	public void windowClosing(WindowEvent arg0)
	{
		this.getC().arreter();
	}
	
	// Ces méthodes sont les autres évenements possibles sur la fenêtre que nous utilisons pas.
	public void windowClosed(WindowEvent arg0) {}
	public void windowActivated(WindowEvent arg0) {}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}
}
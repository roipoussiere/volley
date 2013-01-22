package v;

import java.awt.event.*;
import javax.swing.*;

import c.Controleur;

/**
 * Vue de la fenetre principale du programme.
 */
public class Vue_Fenetre extends JFrame implements WindowListener
{
	private static final long serialVersionUID = 1L;
	private Controleur c;
	private JTabbedPane jtp;
	private JPanel jpOnglets; // Les onglets à gauche
	
	// Les vues lecture et édition sont des JPanels
	private Vue_Lecture vl;
	private Vue_Edition ve;

	/**
	 * Création de la fenêtre et de tous ses composants.
	 * @param _c Le contrôleur.
	 * @author Nathanaël Jourdane
	 */
	public Vue_Fenetre(Controleur _c)
	{
		super ("Logiciel pour strategie de volley");
		this.c = _c;

		this.addWindowListener(this); // On abonne la fenêtre à elle-même.
		this.setSize(400, 300);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		
		
		this.jpOnglets = new JPanel(); // Création des JPanels
		this.jtp = new JTabbedPane(SwingConstants.TOP);
		 
		this.vl = new Vue_Lecture(this.c);
		this.jtp.addTab("Lecture", this.vl);
		 
		this.ve = new Vue_Edition(this.c);
		this.jtp.addTab("Edition", this.ve);
		
		this.jpOnglets.add(this.jtp); // Ajout des onglets dans le JPanel
		this.add(this.jpOnglets); // Ajout du Jpanel Onglets dans la fenetre
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
		this.getC().arreter();
	}
	
	// Ces méthodes sont les autres évenements possibles sur la fenêtre que nous utilisons pas.
	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent arg0) {}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}
}
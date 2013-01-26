package v;

import java.awt.event.*;
import javax.swing.*;

import c.Controleur;

/**
 * Vue de la fenetre principale du programme.
 * @author Nathanaël Jourdane
 */
public class Vue_Fenetre extends JFrame implements WindowListener
{
	private static final long serialVersionUID = 1L;
	private Controleur c;
	private JTabbedPane jtp;
	
	// Les onglets
	private Vue_Fichier vf;
	private Vue_Joueurs vj;
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
		
		this.jtp = new JTabbedPane();
		this.jtp.addChangeListener(new CL_Fenetre(this));
		 
		this.vf = new Vue_Fichier(this.c); // Onglet Fichier
		this.jtp.addTab("Fichier", this.vf);

		this.vj = new Vue_Joueurs(this.c); // Onglet Joueurs
		this.jtp.addTab("Joueurs", this.vj);
		 
		this.ve = new Vue_Edition(this.c); // Onglet Édition
		this.jtp.addTab("Edition", this.ve);
		
		this.vl = new Vue_Lecture(this.c); // Onglet Lecture
		this.jtp.addTab("Lecture", this.vl);
		
		this.add(this.jtp); // Ajout des onglets dans la fenetre
	}

	// /!\ Cette méthode ne marche pas encore.
	/**
	 * Active ou désactive un onglet dont l'utilisateur n'a pas accès.
	 * _onglet L'index de l'onglet à masquer.
	 * _aff True pour activer l'onglet, false pour le désactiver.
	 * @author Nathanaël Jourdane
	 */
	public void activerOnglets(int _onglet, boolean _aff)
	{
		this.jtp.getComponentAt(_onglet).setVisible(_aff);
	}
	
	/**
	 * Getter de Vue_Fichier
	 * @return La vue de l'onglet Fichier.
	 * @author Nathanaël Jourdane
	 */
	public Vue_Fichier getVF()
	{
		return this.vf;
	}
	
	/**
	 * Getter de Vue_Joueurs.
	 * @return La vue de l'onglet Joueur.
	 * @author Nathanaël Jourdane
	 */
	public Vue_Joueurs getVJ()
	{
		return this.vj;
	}
	
	/**
	 * Getter de Vue_Edition.
	 * @return La vue de l'onglet Edition.
	 * @author Nathanaël Jourdane
	 */
	public Vue_Edition getVE()
	{
		return this.ve;
	}
	
	/**
	 * Getter de Vue_Lecture.
	 * @return La vue de l'onglet Lecture.
	 * @author Nathanaël Jourdane
	 */
	public Vue_Lecture getVL()
	{
		return this.vl;
	}
	/**
	 * Getter de l'onglet ouvert.
	 * @return L'id de l'onglet actuellement ouvert, de 0 à 4.
	 */
	public int getOngletOuvert()
	{
		return this.jtp.getSelectedIndex();
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
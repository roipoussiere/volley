package v;

import java.awt.event.*;
import javax.swing.*;

import c.Controleur;

/**
 * Vue de la fenetre principale du programme.
 * @author Nathanaël Jourdane
 */
@SuppressWarnings("serial")
public class Vue_Fenetre extends JFrame implements WindowListener
{
	private Controleur c;
	private JTabbedPane tp;
	private Vue_Fichier vf;
	private Vue_Joueurs vj;
	
	// La barre de menus
	private JMenuBar mb = new JMenuBar();

	// Menu Fichier
	private JMenu mf = new JMenu("Fichier");
	private JMenuItem mfo = new JMenuItem("Ouvrir");
	private JMenuItem mfn = new JMenuItem("Nouveau");
	private JMenuItem mfe = new JMenuItem("Enregistrer");
	private JMenuItem mfes = new JMenuItem("Enregistrer sous...");
	private JMenuItem mfq = new JMenuItem("Quitter");

	// Menu Stratégie
	private JMenu ms = new JMenu("Stratégie");
	private JMenuItem msj = new JMenuItem("Joueurs");
	private JMenuItem mst = new JMenuItem("Terrain");

	// Menu Paramètres
	private JMenu mp = new JMenu("Paramètres");
	private JMenuItem mpg = new JMenuItem("Grille");
	private JMenuItem mpc = new JMenuItem("Couleurs");

	// Menu Aide
	private JMenu ma = new JMenu("Aide");
	private JMenuItem mab = new JMenuItem("Besoin d'aide ?");
	private JMenuItem map = new JMenuItem("À propos de ce programme");
	
	// Les onglets
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
		
		this.tp = new JTabbedPane();
		this.tp.addChangeListener(new CL_Fenetre(this));
		
		// Ajout des Items dans le menu Fichier
		this.mf.add(mfo);
		this.mf.add(mfn);
		this.mf.add(mfe);
		this.mf.add(mfes);
		this.mf.add(mfq);

		// Ajout des Items dans le menu Stratégie
		this.ms.add(msj);
		this.ms.add(mst);
		
		// Ajout des Items dans le menu Paramètres
		this.mp.add(mpg);
		this.mp.add(mpc);
		
		// Ajout des Items dans le menu Aide
		this.ma.add(mab);
		this.ma.add(map);
		
		// Ajout des menus dans la barre de menus
	    this.mb.add(mf);
	    this.mb.add(ms);
	    this.mb.add(mp);
	    this.mb.add(ma);
		
		// Ajout de l'onglet Lecture dans la barre des onglets
		this.vl = new Vue_Lecture(this.c);
		this.tp.addTab("Lecture", this.vl);
		
		// Ajout de l'onglet Édition dans la barre des onglets
		this.ve = new Vue_Edition(this.c);
		this.tp.addTab("Edition", this.ve);
		
		this.add(this.tp); // Ajout de la barre d'onglets dans la fenêtre
	    this.setJMenuBar(mb); // Ajout de la barre de menus dans la fenêtre
	}

	/**
	 * Active ou désactive un sous menu
	 * _onglet L'index de l'onglet à masquer.
	 * _aff True pour activer l'onglet, false pour le désactiver.
	 * @author Nathanaël Jourdane
	 */
	public void activerMenu(int _menu, int _sousMenu, boolean _aff)
	{
		JMenu m = (JMenu)this.mb.getComponent(_menu);
		m.getMenuComponent(_sousMenu).setEnabled(_aff);
	}
	
	// /!\ Cette méthode ne marche pas encore.
	/**
	 * Active ou désactive un onglet dont l'utilisateur n'a pas accès.
	 * _onglet L'index de l'onglet à masquer.
	 * _aff True pour activer l'onglet, false pour le désactiver.
	 * @author Nathanaël Jourdane
	 */
	public void activerOnglet(int _onglet, boolean _aff)
	{
		this.tp.getComponent(_onglet).setVisible(_aff);
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
	 * @return L'id de l'onglet actuellement ouvert : 0 ou 1.
	 */
	public int getOngletOuvert()
	{
		return this.tp.getSelectedIndex();
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
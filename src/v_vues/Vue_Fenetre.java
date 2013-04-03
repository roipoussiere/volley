package v_vues;

import c.ControleurVueFenetre;
import java.awt.event.*;
import javax.swing.*;
import v_ecouteurs.AL_Fenetre;
import v_ecouteurs.CL_Fenetre;

/**
 * Vue de la fenêtre principale du programme.
 * @author Nathanaël Jourdane
 */
@SuppressWarnings("serial")
public class Vue_Fenetre extends JFrame implements WindowListener
{
	// Controleurs
	private ControleurVueFenetre cvf;

	// Vues
	private Vue_Params vp;

	// La barre de menus
	private JMenuBar mb = new JMenuBar();
	private JMenu mf;
	private JMenu ms;
	private JMenu ma;

	private JTabbedPane tp;

	/**
	 * Création de la fenêtre et de tous ses composants.
	 * @param _c Le contrôleur.
	 */
	public Vue_Fenetre(ControleurVueFenetre _cvf)
	{
		super ("Logiciel pour strategie de volley");
		this.cvf = _cvf;

		//this.cvf.getCP(). = new Vue_Edition(cve);
		//this.vl = new Vue_Lecture(this.cvf);

		this.addWindowListener(this); // On abonne la fenêtre à elle-même.
		this.setSize(420, 385);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);

		this.tp = new JTabbedPane();
		this.tp.addChangeListener(new CL_Fenetre(this));

		// Ajout de l'onglet Lecture dans la barre des onglets
		this.tp.addTab("Lecture", this.cvf.getVueLecture());
		
		// Ajout de l'onglet Édition dans la barre des onglets
		this.tp.addTab("Edition", this.cvf.getVueEdition());

		this.add(this.tp); // Ajout de la barre d'onglets dans la fenêtre

		initMenu();
		this.setJMenuBar(mb); // Ajout de la barre de menus dans la fenêtre
	}

	/**
	 * Ititialisation de la barre de menu.<br/>
	 * Cette méthode vise à alléger le constructeur.
	 */
	private void initMenu()
	{
		// Création des menus
		this.mf = new JMenu("Fichier");
		this.ms = new JMenu("Stratégie");
		this.ma = new JMenu("Aide");

		// Création des items de Fichier
		JMenuItem mfo = new JMenuItem("Ouvrir");
		JMenuItem mfn = new JMenuItem("Nouveau");
		JMenuItem mfes = new JMenuItem("Enregistrer sous");
		JMenuItem mfq = new JMenuItem("Quitter");

		// Création des items de Stratégie
		JMenuItem msj = new JMenuItem("Joueurs");
		JMenu mst = new JMenu("Terrain");
		JMenuItem msp = new JMenuItem("Paramètres...");

		// Création des items de Aide
		JMenuItem mab = new JMenuItem("Besoin d'aide ?");
		JMenuItem map = new JMenuItem("À propos de ce programme");

		// Création des boutons radio pour sélectionner le mode de terrain,
		// Avec leur action par défaut récupérée dans les paramètres.
		ButtonGroup bg = new ButtonGroup();
		JRadioButtonMenuItem modeDT = new JRadioButtonMenuItem("Demi terrain", this.cvf.isDT());
		JRadioButtonMenuItem modeTC = new JRadioButtonMenuItem("Terrain complet", !this.cvf.isDT());

		modeDT.addActionListener(new AL_Fenetre(this));
		modeTC.addActionListener(new AL_Fenetre(this));

		bg.add(modeDT);
		bg.add(modeTC);

		mst.add(modeDT);
		mst.add(modeTC);

		// Ajout des items dans le menu Fichier
		this.mf.add(mfo);
		this.mf.add(mfn);
		this.mf.add(mfes);
		this.mf.addSeparator();
		this.mf.add(mfq);

		// Ajout des items dans le menu Stratégie
		this.ms.add(msj);
		this.ms.add(mst);
		this.ms.add(msp);

		// Ajout des Items dans le menu Aide
		this.ma.add(mab);
		this.ma.add(map);

		// Ajout des menus dans la barre de menus
		this.mb.add(mf);
		this.mb.add(ms);
		this.mb.add(ma);

		// Ajout des écouteurs du menu Fichier
		mfo.addActionListener(new AL_Fenetre(this));
		mfn.addActionListener(new AL_Fenetre(this));
		mfes.addActionListener(new AL_Fenetre(this));
		mfq.addActionListener(new AL_Fenetre(this));

		// Ajout des écouteurs du menu Stratégie
		msj.addActionListener(new AL_Fenetre(this));
		msp.addActionListener(new AL_Fenetre(this));

		// Ajout des écouteurs du menu Aide
		mab.addActionListener(new AL_Fenetre(this));
		map.addActionListener(new AL_Fenetre(this));	    
	}

	/**
	 * Active ou désactive un item dans la barre de menu.
	 * _menu Le menu contenant l'item à masquer.
	 * _item L'item à masquer.
	 * _aff État de l'item : true pour l'activer, false pour le désactiver.
	 */
	public void activerMenu(int _menu, int _item, boolean _aff)
	{
		JMenu m = (JMenu)this.mb.getComponent(_menu);
		m.getMenuComponent(_item).setEnabled(_aff);
	}

	// /!\ Cette méthode ne marche pas encore.
	/**
	 * Active ou désactive un onglet dont l'utilisateur n'a pas accès.
	 * _onglet L'index de l'onglet à masquer.
	 * _aff True pour activer l'onglet, false pour le désactiver.
	 */
	public void activerOnglet(int _onglet, boolean _aff)
	{
		this.tp.getComponent(_onglet).setVisible(_aff);
	}

	/**
	 * Crée la vue Paramères.
	 */
	public void vueParams()
	{
		this.vp = new Vue_Params(this);
	}

	// *** Getters & Setters

	/**
	 * Getter de Vue_Joueurs.
	 * @return La vue de l'onglet Joueur.
	 */
	public Vue_Params getVP()
	{
		return this.vp;
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
	 */
	public ControleurVueFenetre getCVF()
	{
		return this.cvf;
	}

	/**
	 * Action qui suit la fermeture de la fenêtre.
	 * @param arg0 L'évenement de clic sur le bouton de fermeture de la fenêtre.
	 */
	public void windowClosing(WindowEvent arg0)
	{
		this.cvf.quitter();
	}

	// Ces méthodes sont les autres évenements possibles sur la fenêtre que nous utilisons pas.
	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent arg0) {}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}
}
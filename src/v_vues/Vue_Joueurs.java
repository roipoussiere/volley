
package v_vues;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import m.Equipe;

import c.ControleurVueEdition;
import c.ControleurVueJoueurs;
import v_ecouteurs.AL_Joueurs;
import v_utilitaires.SaisieJoueur;


/**
 * Listener de vue_joueur.
 * @author Xavier Chalut v1.1
 */
@SuppressWarnings("serial")
public class Vue_Joueurs extends JDialog implements WindowListener
{
	private ControleurVueJoueurs cvj;
	
	// Composants de la fenetre
	private SaisieJoueur joueur1[],joueur2[] ;
	private JLabel jlNom,jlAfficher,jlMeneur; // label des titres de liste et du checkBox general
	private JCheckBox jcbTout1,jcbTout2, meneurPresentEqu1, meneurPresentEqu2;
	private JTabbedPane jtpj;
	private JPanel jp1,jp2;
	private JButton jbouton1,jbouton2;
	private ButtonGroup bgMeneurEqu1,bgMeneurEqu2;
	
	// Constante
	private static final int NOMBRE_JOUEURS = 6 ;
	
	public Vue_Joueurs (Vue_Fenetre vf, ControleurVueJoueurs _cvj)
	{
		// Définition de la fenêtre
		super (vf, "Joueurs", true) ;
		this.cvj = _cvj;
		this.setSize(370, 350) ;
		this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE) ;
		this.setResizable(false) ;
		this.setLocationRelativeTo(null) ;
		int i;
		
		// Mise en place du GridBagLayout
		this.setLayout (new GridBagLayout()) ;
		GridBagConstraints gbc = new GridBagConstraints () ;
		
		// Attribution du constructeur

		this.jtpj = new JTabbedPane();

		this.jp1 = new JPanel();
		jp1.setLayout (new GridBagLayout()) ;
		this.jp2 = new JPanel();
		jp2.setLayout (new GridBagLayout()) ;
		this.bgMeneurEqu1 = new ButtonGroup();
		this.bgMeneurEqu2 = new ButtonGroup();
		
		this.jlNom = new JLabel("Nom") ;
		gbc.gridx = 1 ; gbc.gridy = 0 ; // 
		gbc.gridwidth = 2 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.CENTER ;
		gbc.insets = new Insets (5,125, 10, 40) ;
		jp1.add(this.jlNom,gbc);
		
		this.jlAfficher = new JLabel("Afficher") ;
		gbc.gridx = 3 ; gbc.gridy = 0 ; // 
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.CENTER ;
		gbc.insets = new Insets (5, 40, 10, 0) ;
		jp1.add(this.jlAfficher,gbc);
		
		this.jlMeneur = new JLabel("Libero ") ;
		gbc.gridx = 4 ; gbc.gridy = 0 ; // 
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.CENTER ;
		gbc.insets = new Insets (5, 12, 10, 0) ;
		jp1.add (this.jlMeneur,gbc) ;
		
		// Paramétrage des joueurs
		this.joueur1 = new SaisieJoueur[NOMBRE_JOUEURS] ;
		for (i = 0 ; i < NOMBRE_JOUEURS ; i++)
		{
			this.joueur1[i] = new SaisieJoueur("Joueur " + (i + 1)) ;
			if(i==0)
				joueur1[i].getMeneur().setSelected(true);
			gbc.gridx = 0 ; gbc.gridy = i + 1 ; // + 1 car la première ligne est déjà occupée
			gbc.gridwidth = GridBagConstraints.REMAINDER ; gbc.gridheight = 1 ;
			gbc.anchor = GridBagConstraints.CENTER ;
			gbc.insets = new Insets (5, 10, 5, 10) ;
			jp1.add (this.joueur1[i],gbc) ;
			this.bgMeneurEqu1.add(joueur1[i].getMeneur());
		}
		
		this.meneurPresentEqu1 = new JCheckBox("Désactiver le libero") ;
		gbc.gridx = 1 ; gbc.gridy = i+1 ; // 
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets (5, 12, 5, 0) ;
		jp1.add (this.meneurPresentEqu1,gbc) ;
		
		this.jcbTout1 = new JCheckBox("Afficher toute l'équipe") ;
		gbc.gridx = 1 ; gbc.gridy = i+2 ; // 
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.CENTER ;
		gbc.insets = new Insets (5, 12, 5, 0) ;
		jp1.add (this.jcbTout1,gbc) ;
		
		this.jbouton1 = new JButton("Enregistrer") ;
		gbc.gridx = 2 ; gbc.gridy = i+2 ; // 
		gbc.gridwidth = GridBagConstraints.REMAINDER ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.CENTER ;
		gbc.insets = new Insets (-30, 12, 5, 0) ;
		jp1.add (this.jbouton1,gbc) ;
		
		
		// Deuxieme onglet
		
		
		this.jlNom = new JLabel("Nom") ;
		gbc.gridx = 1 ; gbc.gridy = 0 ; // 
		gbc.gridwidth = 2 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.CENTER ;
		gbc.insets = new Insets (5,125, 10, 40) ;
		jp2.add(this.jlNom,gbc);
		
		this.jlAfficher = new JLabel("Afficher") ;
		gbc.gridx = 3 ; gbc.gridy = 0 ; // 
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.CENTER ;
		gbc.insets = new Insets (5, 40, 10, 0) ;
		jp2.add(this.jlAfficher,gbc);
		
		this.jlMeneur = new JLabel("Libero") ;
		gbc.gridx = 4 ; gbc.gridy = 0 ; // 
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.CENTER ;
		gbc.insets = new Insets (5, 12, 10, 0) ;
		jp2.add (this.jlMeneur,gbc) ;
		
		// Paramétrage des joueurs
		this.joueur2 = new SaisieJoueur[NOMBRE_JOUEURS] ;
		for (i = 0 ; i < NOMBRE_JOUEURS ; i++)
		{
			this.joueur2[i] = new SaisieJoueur("Joueur " + (i + 1)) ;
			if(i==0)
				joueur2[i].getMeneur().setSelected(true);
			gbc.gridx = 0 ; gbc.gridy = i + 1 ; // + 1 car la première ligne est déjà occupée
			gbc.gridwidth = GridBagConstraints.REMAINDER ; gbc.gridheight = 1 ;
			gbc.anchor = GridBagConstraints.CENTER ;
			gbc.insets = new Insets (5, 10, 5, 10) ;
			jp2.add (this.joueur2[i],gbc) ;
			this.bgMeneurEqu2.add(joueur2[i].getMeneur());
		}
		
		this.meneurPresentEqu2 = new JCheckBox("Désactiver le libero") ;
		gbc.gridx = 1 ; gbc.gridy = i+1 ; // 
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets (5, 12, 5, 0) ;
		jp2.add (this.meneurPresentEqu2,gbc) ;
		
		this.jcbTout2 = new JCheckBox("Afficher toute l'équipe") ;
		gbc.gridx = 1 ; gbc.gridy = i+2 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.CENTER ;
		gbc.insets = new Insets (5, 12, 5, 0) ;
		jp2.add (this.jcbTout2,gbc) ;
		
		this.jbouton2 = new JButton("Enregistrer") ;
		gbc.gridx = 2 ; gbc.gridy = i+2 ; 
		gbc.gridwidth = GridBagConstraints.REMAINDER ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.CENTER ;
		gbc.insets = new Insets (-30, 12, 5, 0) ;
		jp2.add (this.jbouton2,gbc) ;
		
		jtpj.addTab("Equipe 1",jp1);
		jtpj.addTab("Equipe 2",jp2);
		this.add(this.jtpj);
		
		
		//Abonnement a l'ecouteur
		AL_Joueurs evj = new AL_Joueurs(this);
		
		this.meneurPresentEqu1.addActionListener (evj) ;
		this.meneurPresentEqu2.addActionListener (evj) ;
		this.jcbTout1.addActionListener (evj) ;
		this.jcbTout2.addActionListener (evj) ;
		this.jbouton1.addActionListener (evj) ;
		this.jbouton2.addActionListener (evj) ;
		
		for(i=0 ; i < this.joueur1.length ; i++)
			this.joueur1[i].getAfficher().addActionListener (evj) ;
		for(i=0 ; i < this.joueur2.length ; i++)
			this.joueur2[i].getAfficher().addActionListener (evj) ;
		
		for(i=0 ; i < this.joueur1.length ; i++)
		{	this.joueur1[i].getNomJoueur().addActionListener(evj) ;
			System.out.println("joueur " +i+" "+ this.joueur1[i].getNomJoueur().getText());
		}
		
		for(i=0 ; i < this.joueur1.length ; i++)
			this.joueur1[i].getNomJoueur().addActionListener(evj) ;
		
		this.addWindowListener(this);
		

		majVueJoueurs();
	}
	
	public void majVueJoueurs ()
	{
		Equipe eqSelec1,eqSelec2 ;
		eqSelec1 = this.cvj.getStrategie().getEq1() ; // équipe 1
		eqSelec2 = this.cvj.getStrategie().getEq2() ; // équipe 2
		// On récupère l'équipe en cours de traitement
		for(int i=0; i < 6;i++)
		{
			//Equipe 1
			this.getJoueur1()[i].getNomJoueur().setText(eqSelec1.getJoueur(i).getNomJ());//Remplissage des noms
			this.getJoueur1()[i].getAfficher().setSelected(eqSelec1.getJoueur(i).isAffiche());//Remplissage de l'option afficher
			if(eqSelec1.getJoueur(i).isMeneur ())	// Si au moins un joueur est meneur
			{
					for(int j=0; j < this.getJoueur1().length;j++)
						this.getJoueur1()[j].getMeneur().setEnabled(true);
					this.getJoueur1()[i].getMeneur().setSelected(eqSelec1.getJoueur(i).isMeneur ());//Remplissage de l'option meneur
			}
			//Equipe 2
			this.getJoueur2()[i].getNomJoueur().setText(eqSelec2.getJoueur(i).getNomJ());//Remplissage des noms
			this.getJoueur2()[i].getAfficher().setSelected(eqSelec2.getJoueur(i).isAffiche());//Remplissage de l'option afficher
			if(eqSelec2.getJoueur(i).isMeneur ())	// Si au moins un joueur est meneur
			{
					for(int j=0; j < this.getJoueur2().length;j++)
						this.getJoueur2()[j].getMeneur().setEnabled(true);
					this.getJoueur2()[i].getMeneur().setEnabled(eqSelec2.getJoueur(i).isMeneur ());//Remplissage de l'option meneur
			}
		}
	}
	
	/**
	 * Getter du controleur.
	 * @return Le controleur.
	 */
	public ControleurVueJoueurs getCVJ()
	{
		return this.cvj ;
	}
	
	/**
	 * Getter des bounton enregistrer.
	 * @return Bouton enregistre.
	 */
	public JButton getJbouton1() {
		return jbouton1;
	}

	public JButton getJbouton2() {
		return jbouton2;
	}

	/**
	 * Getter du champs de saisie du nom du joueur.
	 * @return Le champs de saisie du nom du joueur.
	 */
	public JCheckBox getJcbTout1()
	{
		return jcbTout1;
	}
	public JCheckBox getJcbTout2()
	{
		return jcbTout2;
	}
	
	public JCheckBox getMeneurPresentEqu1()
	{
		return meneurPresentEqu1;
	}
	public JCheckBox getMeneurPresentEqu2()
	{
		return meneurPresentEqu2;
	}
	
	public SaisieJoueur[] getJoueur1()
	{
		return joueur1;
	}
	
	public void setJoueur1(SaisieJoueur[] joueur)
	{
		this.joueur1 = joueur;
	}
	
	public SaisieJoueur[] getJoueur2()
	{
		return joueur2;
	}
	
	public void setJoueur2(SaisieJoueur[] joueur)
	{
		this.joueur2 = joueur;
	}
	
	//Methode de windowsListener

	public void windowOpened     (WindowEvent arg0)		{}
	public void windowClosed     (WindowEvent arg0)		{}
	public void windowIconified  (WindowEvent arg0)		{}
	public void windowDeiconified(WindowEvent arg0)		{}
	public void windowActivated  (WindowEvent arg0)		{}
	public void windowDeactivated(WindowEvent arg0)		{}
	public void windowClosing    (WindowEvent arg0)		
	{
		int i = 0 ;
		if(cvj.estEnregistre()==1)
		{
			i = JOptionPane.showConfirmDialog(this, "Les modifications de l'equipe 1 ne sont pas enregistre\nEtes-vous sur de vouloir quitter ?","Fermer", JOptionPane.YES_NO_OPTION);
		}
		else if (cvj.estEnregistre()==2)
		{
			i = JOptionPane.showConfirmDialog(this, "Les modifications de l'equipe 2 ne sont pas enregistre\nEtes-vous sur de vouloir quitter ?","Fermer", JOptionPane.YES_NO_OPTION);
		}
		System.out.println(i);
		switch(i)
		{
			case 0 : {this.setVisible(false);}
			case 1 : {}
			case 2 : {}
			case -1 : {}
		}
	}

	
}
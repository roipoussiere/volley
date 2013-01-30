package v_vues;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

import v_ecouteurs.AL_Edition;
import v_utilitaires.SaisieDeplacement;
import v_utilitaires.SelectionTemps;

import c.Controleur;

/**
 * Vue contenant les éléments de l'onglet Edition.
 * @author Florian Garnier
 */
@SuppressWarnings("serial")
public class Vue_Edition extends JPanel
{
	private Controleur c ;
	
	// Composants de la fenetre
	private SelectionTemps selecTps ; // permet de choisir le temps à gérer
	private JComboBox typeStrategie ; // permet de sélectionner le type de la stratégie
	private SaisieDeplacement deplacementJ[] ; // tableau contenant les saisies des déplacements de chaque joueur
	
	// Constante
	private static final int NOMBRE_JOUEURS = 6 ; // A MODIFIER ! doit recevoir le nombre de joueurs sélectionnés dans le menu "Joueur"
	
	/**
	 * Création du JFrame et de tous ses composants.
	 * @param _c Le controleur.
	 */
	public Vue_Edition (Controleur _c)
	{
		super () ;
		this.c = _c ;

		// Mise en place du GridBagLayout
		this.setLayout (new GridBagLayout()) ;
		GridBagConstraints gbc = new GridBagConstraints () ;
		
		// Sélection du temps
		this.selecTps = new SelectionTemps () ;
		gbc.gridx = 0 ; gbc.gridy = 0 ;
		gbc.gridwidth = 3 ; gbc.gridheight = 1 ; // 3 car SelectionTemps possède 3 composants
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 0, 0, 0) ;
		this.add (this.selecTps, gbc) ;
		
		// Type de la strategie
		this.typeStrategie = new JComboBox () ;
		this.typeStrategie.setEditable (false) ;
		this.typeStrategie.addItem ("Attaque") ;
		this.typeStrategie.addItem ("Défense") ;
		gbc.gridx = 3 ; gbc.gridy = 0 ;
		gbc.gridwidth = GridBagConstraints.REMAINDER ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 135, 10, 10) ;
		this.add (this.typeStrategie, gbc) ;
		
		// Saisie des déplacements des joueurs
		this.deplacementJ = new SaisieDeplacement[NOMBRE_JOUEURS] ;
		for (int i = 0 ; i < NOMBRE_JOUEURS ; i++)
		{		
			this.deplacementJ[i] = new SaisieDeplacement("Joueur " + (i + 1), i + 1, "A6") ;
			gbc.gridx = 0 ; gbc.gridy = i + 2 ; // + 1 car les deux premières lignes sont déjà occupées
			gbc.gridwidth = GridBagConstraints.REMAINDER ; gbc.gridheight = 1 ;
			gbc.anchor = GridBagConstraints.CENTER ;
			gbc.insets = new Insets (10, 0, 10, 0) ;
			this.add (this.deplacementJ[i], gbc) ;
		}
		
		// Abonnement aux listeners
		this.selecTps.getTpsPrecedent().addActionListener (new AL_Edition(this)) ;
		this.selecTps.getTpsSuivant().addActionListener (new AL_Edition(this)) ;
	}
	
	/**
	 * Getter du controleur.
	 * @return Le controleur.
	 */
	public Controleur getC()
	{
		return this.c ;
	}

	/**
	 * Getter du sélectionneur de temps.
	 * @return Le sélectionneur de temps.
	 */
	public SelectionTemps getSelecTps () 
	{
		return selecTps ;
	}

	/**
	 * Getter de la liste de type de stratégie.
	 * @return La liste de type de stratégie.
	 */
	public JComboBox getTypeStrategie () 
	{
		return typeStrategie ;
	}

	/**
	 * Getter du tableau des déplacements des joueurs.
	 * @return Le tableau des déplacements des joueurs.
	 */
	public SaisieDeplacement[] getDeplacementJ () 
	{
		return deplacementJ ;
	}
}
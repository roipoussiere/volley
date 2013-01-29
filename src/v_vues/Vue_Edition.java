package v_vues;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

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
	private JLabel numJ[] ; // tableau de JLabel contenant les numéros de chaque joueur
	private JTextField deplacementJ[] ; // tableau de JTextField contenant les déplacements saisis de chaque joueur
	
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
		this.numJ = new JLabel[NOMBRE_JOUEURS] ; 
		this.deplacementJ = new JTextField[NOMBRE_JOUEURS] ;
		for (int i = 0 ; i < NOMBRE_JOUEURS ; i++)
		{
			// Ajout du label
			this.numJ[i] = new JLabel ("Joueur " + (i + 1) + " : ") ;
			gbc.gridx = 0 ; gbc.gridy = i + 1 ; // + 1 car la première ligne est déjà occupée
			gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
			gbc.anchor = GridBagConstraints.LINE_START ;
			gbc.insets = new Insets (0, 10, 0, 10) ;
			this.add (this.numJ[i], gbc) ;
			
			// Ajout du champs de saisie
			this.deplacementJ[i] = new JTextField (25) ;
			gbc.gridx = 1 ; gbc.gridy = i + 1 ; // + 1 car la première ligne est déjà occupée
			gbc.gridwidth = GridBagConstraints.REMAINDER ; gbc.gridheight = 1 ;
			gbc.anchor = GridBagConstraints.LINE_START ;
			gbc.insets = new Insets (10, 0, 10, 10) ;
			this.add (this.deplacementJ[i], gbc) ;
		}
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
	public JTextField[] getDeplacementJ () 
	{
		return deplacementJ ;
	}
}
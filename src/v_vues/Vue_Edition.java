package v_vues;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

import c.Controleur;

/**
 * Vue contenant les elements de l'onglet Edition.
 * @author Florian Garnier
 */
@SuppressWarnings("serial")
public class Vue_Edition extends JPanel
{
	private Controleur c ;
	
	// Composants de la fenetre
	private JButton tpsPrecedent ; // permet de retourner au temps precedent
	private JButton tpsSuivant ; // permet de passer au temps suivant
	private JTextField tpsEnCours ; // affiche le temps en cours + permet de saisir le temps que l'on souhaite traiter
	private JComboBox typeStrategie ; // permet de selectionner le type de la strategie
	private JLabel numJ[] ; // tableau de JLabel contenant les numéros de chaque joueur
	private JTextField deplacementJ[] ; // tableau de JTextField contenant les déplacements saisis de chaque joueur
	
	// Constante
	private static final int NOMBRE_JOUEURS = 6 ; // A MODIFIER ! doit recevoir le nombre de joueurs sélectionnés dans le menu "Joueur"
	
	/**
	 * Creation du JFrame et de tous ses composants.
	 * @param _c Le controleur.
	 */
	public Vue_Edition (Controleur _c)
	{
		super () ;
		this.c = _c ;

		// Mise en place du GridBagLayout
		this.setLayout (new GridBagLayout()) ;
		GridBagConstraints gbc = new GridBagConstraints () ;
		
		// Bouton "Precedent"
		this.tpsPrecedent = new JButton ("<") ;
		gbc.gridx = 0 ; gbc.gridy = 0 ; // On positionne le composant dans la cellule de coordonnées (0 ; 0)
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ; // Le composant occupe 1 colonne et 1 ligne
		gbc.anchor = GridBagConstraints.LINE_START ; // On positionne le composant au milieu à gauche de la cellule
		gbc.insets = new Insets (0, 10, 10, 0) ; // On définit les marges entourant le composant
		this.add (this.tpsPrecedent, gbc) ;
		
		// Affichage et saisie du temps
		this.tpsEnCours = new JTextField (3) ;
		gbc.gridx = 1 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 0, 10, 25) ;
		this.add (this.tpsEnCours, gbc) ;
		
		// Bouton "Suivant"
		this.tpsSuivant = new JButton (">") ;
		gbc.gridx = 2 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 0, 10, 10) ;
		this.add (this.tpsSuivant, gbc) ;
		
		// Type de la strategie
		this.typeStrategie = new JComboBox() ;
		this.typeStrategie.setEditable (false) ;
		this.typeStrategie.addItem ("Attaque") ;
		this.typeStrategie.addItem ("Défense") ;
		gbc.gridx = 3 ; gbc.gridy = 0 ;
		gbc.gridwidth = GridBagConstraints.REMAINDER ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 100, 10, 10) ;
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
		return this.c;
	}
}
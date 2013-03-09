package v_vues;

import c.ControleurVueEdition;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import v_ecouteurs.AL_Edition;
import v_utilitaires.SaisieDeplacement;
import v_utilitaires.SelectionTemps;

/**
 * Vue contenant les éléments de l'onglet Edition.
 * @author Florian Garnier
 */
@SuppressWarnings("serial")
public class Vue_Edition extends JPanel
{
	private ControleurVueEdition c ;

	// Composants de la fenetre
	private SelectionTemps selecTps ; // permet de choisir le temps à gérer
	private JComboBox selecEquipe ; // permet de sélectionner l'équipe à déplacer
	private SaisieDeplacement deplacementJ[] ; // tableau contenant les saisies des déplacements de chaque joueur

	// Constante
	private static final int NOMBRE_JOUEURS = 6 ;

	/**
	 * Création du JFrame et de tous ses composants.
	 * @param _c Le controleur.
	 */
	public Vue_Edition (ControleurVueEdition _c)
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

		// Sélection de l'équipe
		this.selecEquipe = new JComboBox () ;
		this.selecEquipe.setEditable (false) ;
		this.selecEquipe.addItem ("Équipe 1") ;
		this.selecEquipe.addItem ("Équipe 2") ;
		gbc.gridx = 3 ; gbc.gridy = 0 ;
		gbc.gridwidth = GridBagConstraints.REMAINDER ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 135, 10, 10) ;
		this.add (this.selecEquipe, gbc) ;

		// Saisie des déplacements des joueurs
		this.deplacementJ = new SaisieDeplacement[NOMBRE_JOUEURS] ;
		for (int i = 0 ; i < NOMBRE_JOUEURS ; i++)
		{	
			this.deplacementJ[i] = new SaisieDeplacement("Joueur " + (i + 1), i + 1, "A6") ;
			gbc.gridx = 0 ; gbc.gridy = i + 2 ; // + 2 car les deux premières lignes sont déjà occupées
			gbc.gridwidth = GridBagConstraints.REMAINDER ; gbc.gridheight = 1 ;
			gbc.anchor = GridBagConstraints.CENTER ;
			gbc.insets = new Insets (10, 0, 10, 0) ;
			this.add (this.deplacementJ[i], gbc) ;
			this.deplacementJ[i].getDepActuel().getDocument().addDocumentListener(new AL_Edition(this)) ;
		}

		// Abonnement aux listeners
		this.selecTps.getButtonTpsPrecedent().addActionListener (new AL_Edition(this)) ;
		this.selecTps.getButtonTpsSuivant().addActionListener (new AL_Edition(this)) ;
	}
	
	
	// Getters

	/**
	 * Getter du controleur.
	 * @return Le controleur.
	 */
	public ControleurVueEdition getC()
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
	 * Getter de la liste des équipes.
	 * @return La liste des équipes.
	 */
	public JComboBox getListEquipe ()
	{
		return selecEquipe ;
	}

	/**
	 * Getter du tableau des structures de saisie des déplacements des joueurs.
	 * @return Le tableau des structures de saisie des déplacements des joueurs.
	 */
	public SaisieDeplacement[] getDeplacementJ ()
	{
		return deplacementJ ;
	}
	
	
	// Accesseurs
	
	public SaisieDeplacement getSaisieDeplacementJ (int _i)
	{
		return deplacementJ[_i] ;
	}
}
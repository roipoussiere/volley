package v_utilitaires;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

/**
 * Utilitaire de saisie de joueur.
 * @author Florian Garnier
 */
@SuppressWarnings("serial")
public class SaisieJoueur extends JPanel
{
	private JLabel numJoueur ;
	private JTextField nomJoueur ;
	private JCheckBox afficher ;
	private JRadioButton meneur ;
	
	/**
	 * Constructeur de l'utilitaire et de tous ses composants
	 */
	public SaisieJoueur (String _numJoueur)
	{
		// Mise en place du GridBagLayout
		this.setLayout(new GridBagLayout()) ;
		GridBagConstraints gbc = new GridBagConstraints() ;
		
		// Label numéro joueur
		this.numJoueur = new JLabel (_numJoueur) ;
		gbc.gridx = 0 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 10, 0, 10) ;
		this.add (this.numJoueur, gbc) ;
		
		// Champs de saisie du nom du joueur
		this.nomJoueur = new JTextField(10) ;
		gbc.gridx = 1 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 10, 0, 10) ;
		this.add (this.nomJoueur, gbc) ;
		
		// Case à cocher pour afficher le joueur
		this.afficher = new JCheckBox() ;
		gbc.gridx = 3 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 30, 0, 10) ;
		this.add (this.afficher, gbc) ;
		
		// Bouton radio pour déterminer si le joueur est meneur ou non
		this.meneur = new JRadioButton() ;
		gbc.gridx = 4 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 30, 0, 10) ;
		this.add (this.meneur, gbc) ;
	}
	
	// Getters
	
	/**
	 * Getter du champs de saisie du nom du joueur.
	 * @return Le champs de saisie du nom du joueur.
	 */
	public JTextField getNomJoueur ()
	{
		return this.nomJoueur ;
	}
	
	/***
	 * Getter de la checkbox déterminant l'affichage du joueur.
	 * @return La checkbox déterminant l'affichage du joueur.
	 */
	public JCheckBox getAfficher ()
	{
		return this.afficher ;
	}
	
	/**
	 * Getter du bouton radio déterminant si le joueur est meneur.
	 * @return Le bouton radio déterminant si le joueur est meneur.
	 */
	public JRadioButton getMeneur ()
	{
		return this.meneur ;
	}
}

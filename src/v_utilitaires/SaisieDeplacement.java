package v_utilitaires;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Utilitaire de saisie des déplacements des joueurs.
 * @author Florian Garnier
 */
@SuppressWarnings("serial")
public class SaisieDeplacement extends JPanel
{
	protected JLabel infoJ ; // nom + numéro du joueur 
	protected JTextField depPrec ; // déplacement saisi au temps précédent
	protected JTextField depActuel ; // saisie du déplacement du temps en cours
	
	/**
	 * Constructeur de l'utilitaire et de tous ses composants.
	 */
	public SaisieDeplacement (String _nomJ)
	{
		// Mise en place du GridBagLayout
		this.setLayout (new GridBagLayout ()) ;
		GridBagConstraints gbc = new GridBagConstraints () ;
		
		// Label info joueur
		this.infoJ = new JLabel (_nomJ) ;
		this.infoJ.setPreferredSize(new Dimension(60, 20)) ;
		gbc.gridx = 0 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 10, 0, 10) ;
		gbc.fill = GridBagConstraints.HORIZONTAL ;
		this.add (this.infoJ, gbc) ;
		
		// Label déplacement précédent
		this.depPrec = new JTextField (3) ;
		this.depPrec.setEditable (false) ;
		gbc.gridx = 1 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 10, 0, 10) ;
		this.add (this.depPrec, gbc) ;
		
		// Champs de saisie du déplacement
		this.depActuel = new JTextField (3) ;
		gbc.gridx = 2 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 10, 0, 10) ;
		this.add (this.depActuel, gbc) ;		
	}
	
	public SaisieDeplacement (String _nomJ, String _idJ)
	{
		this (_nomJ) ;
		this.infoJ.setText(_nomJ + " (" + _idJ + ")") ;
	}
	
	
	// Getters
	
	/**
	 * Getter du label d'affichage du nom du joueur.
	 * @return Le label d'affichage du nom du joueur.
	 */
	public JLabel getNomJ ()
	{
		return this.infoJ ;
	}
	
	/**
	 * Getter du champ d'affichage du déplacement précédent.
	 * @return Le champ d'affichage du déplacement précédent.
	 */
	public JTextField getDepPrec ()
	{
		return this.depPrec ;
	}

	/**
	 * Getter du champ de saisie du déplacement du temps en cours.
	 * @return Le champ de saisie du déplacement du temps en cours.
	 */
	public JTextField getDepActuel ()
	{
		return depActuel ;
	}
}


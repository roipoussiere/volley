package v_utilitaires;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Utilitaire de saisie des déplacements des joueurs.
 * @author Florian
 */
@SuppressWarnings("serial")
public class SaisieDeplacement extends JPanel
{
	private JLabel infoJ ; // nom + numéro du joueur 
	private JTextField depPrec ; // déplacement saisi au temps précédent
	private JTextField depActuel ; // saisie du déplacement du temps en cours
	
	/**
	 * Constructeur de l'utilitaire et de tous ses composants.
	 */
	public SaisieDeplacement (String _nomJ, int _numJ, String _depPrec)
	{
		// Mise en place du GridBagLayout
		this.setLayout (new GridBagLayout ()) ;
		GridBagConstraints gbc = new GridBagConstraints () ;
		
		// Label info joueur
		this.infoJ = new JLabel (_nomJ + " (" + _numJ + ")") ;
		gbc.gridx = 0 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 10, 0, 10) ;
		this.add (this.infoJ, gbc) ;
		
		// Label déplacement précédent
		this.depPrec = new JTextField (5) ;
		this.depPrec.setText (_depPrec) ;
		this.depPrec.setEditable (false) ;
		gbc.gridx = 1 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 10, 0, 10) ;
		this.add (this.depPrec, gbc) ;
		
		// Champs de saisie du déplacement
		this.depActuel = new JTextField (5) ;
		gbc.gridx = 2 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 10, 0, 10) ;
		this.add (this.depActuel, gbc) ;
	}

	/**
	 * Getter du champs de saisie du déplacement.
	 * @return Le champ de saisie du déplacement.
	 */
	public JTextField getDepActuel ()
	{
		return depActuel ;
	}
}

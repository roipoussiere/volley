package v_utilitaires;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Utilitaire permettant de creer le "menu" de selection du temps de jeu
 * @author Florian Garnier
 */
@SuppressWarnings("serial")
public class SelectionTemps extends JPanel
{
	// Composants
	private JButton tpsPrecedent ; // permet de retourner au temps precedent
	private JButton tpsSuivant ; // permet de passer au temps suivant
	private JTextField tpsEnCours ; // affiche le temps en cours + permet de saisir le temps que l'on souhaite traiter

	/**
	 * Constructeur de l'utilitaire et de tous ses composants.
	 */
	public SelectionTemps ()
	{
		// Mise en place du GridBagLayout
		this.setLayout (new GridBagLayout ()) ;
		GridBagConstraints gbc = new GridBagConstraints () ;

		// Bouton "Temps précédent"
		this.tpsPrecedent = new JButton ("<") ;
		this.tpsPrecedent.setEnabled (false) ;
		gbc.gridx = 0 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 10, 10, 0) ;
		this.add (this.tpsPrecedent, gbc) ;

		// Affichage et saisie du temps
		this.tpsEnCours = new JTextField (3) ;
		this.tpsEnCours.setText ("0") ;
		this.tpsEnCours.setHorizontalAlignment (JTextField.CENTER) ;
		gbc.gridx = 1 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 10, 10, 10) ;
		this.add (this.tpsEnCours, gbc) ;

		// Bouton "Temps suivant"
		this.tpsSuivant = new JButton (">") ;
		// this.tpsSuivant.setEnabled (false) ;
		gbc.gridx = 2 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 0, 10, 0) ;
		this.add (this.tpsSuivant, gbc) ;
	}

	/**
	 * Getter du bouton "Temps précédent".
	 * @return Le bouton "Temps précédent".
	 */
	public JButton getTpsPrecedent ()
	{
		return tpsPrecedent ;
	}

	/**
	 * Getter du bouton "Temps suivant".
	 * @return Le bouton "Temps suivant".
	 */
	public JButton getTpsSuivant ()
	{
		return tpsSuivant ;
	}

	/**
	 * Getter du champs de saisie du temps.
	 * @return Le champs de saisie du temps.
	 */
	public JTextField getTpsEnCours ()
	{
		return tpsEnCours ;
	}
}


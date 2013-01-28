package v_vues;

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

	public SelectionTemps ()
	{
		// Mise en place du GridBagLayout
		this.setLayout (new GridBagLayout ()) ;
		GridBagConstraints gbc = new GridBagConstraints () ;

		// Bouton "Précédent"
		this.tpsPrecedent = new JButton ("<") ;
		gbc.gridx = 0 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 10, 10, 0) ;
		this.add (this.tpsPrecedent, gbc) ;

		// Affichage et saisie du temps
		this.tpsEnCours = new JTextField (3) ;
		gbc.gridx = 1 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 10, 10, 10) ;
		this.add (this.tpsEnCours, gbc) ;

		// Bouton "Suivant"
		this.tpsSuivant = new JButton (">") ;
		gbc.gridx = 2 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 0, 10, 0) ;
		this.add (this.tpsSuivant, gbc) ;
	}
}

package v_utilitaires;

import java.awt.*;
import javax.swing.*;
import m.Strategie;

/**
 * Utilitaire permettant de creer le "menu" de selection du temps de jeu
 * @author Florian Garnier
 */
@SuppressWarnings("serial")
public class SelectionTemps extends JPanel
{
	// Composants
	private JButton BPPrecedent ; // permet de retourner au temps precedent
	private JButton BPSuivant ; // permet de passer au temps suivant
	private JTextField temps ; // affiche le temps en cours + permet de saisir le temps que l'on souhaite traiter

  private Strategie s;
	/**
	 * Constructeur de l'utilitaire et de tous ses composants.
	 */
	public SelectionTemps (Strategie _s)
	{
    this.s = _s;
		// Mise en place du GridBagLayout
		this.setLayout (new GridBagLayout ()) ;
		GridBagConstraints gbc = new GridBagConstraints () ;

		// Bouton "Temps précédent"
		this.BPPrecedent = new JButton ("<");
		this.BPPrecedent.setEnabled (false);
		gbc.gridx = 0 ; gbc.gridy = 0;
		gbc.gridwidth = 1 ; gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets (0, 10, 10, 0);
		this.add (this.BPPrecedent, gbc);

		// Affichage et saisie du temps
		this.temps = new JTextField (3) ;
		this.temps.setText ("0") ;
		this.temps.setHorizontalAlignment (JTextField.CENTER) ;
		gbc.gridx = 1 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 10, 10, 10) ;
		this.add (this.temps, gbc) ;

		// Bouton "Temps suivant"
		this.BPSuivant = new JButton (">") ;
    // this.tpsSuivant.setEnabled (false) ;
		gbc.gridx = 2 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 0, 10, 0) ;
		this.add (this.BPSuivant, gbc) ;
    
    this.BPPrecedent.addActionListener (new AL_SelectionTemps(this));
    this.BPSuivant.addActionListener (new AL_SelectionTemps(this));
	}

	/**
	 * Getter du bouton "Temps précédent".
	 * @return Le bouton "Temps précédent".
	 */
	public JButton getBPPrecedent ()
	{
		return BPPrecedent ;
	}

	/**
	 * Getter du bouton "Temps suivant".
	 * @return Le bouton "Temps suivant".
	 */
	public JButton getBPSuivant ()
	{
		return BPSuivant ;
	}

	/**
	 * Getter du champs de saisie du temps.
	 * @return Le champs de saisie du temps.
	 */
	public JTextField getTemps ()
	{
		return temps ;
	}
  
  public Strategie getStrategie ()
  {
    return this.s;
  }
}
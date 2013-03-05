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

		// Bouton "Temps précédent"
		this.BPPrecedent = new JButton ("<");
		this.BPPrecedent.setEnabled (false);
		this.add (this.BPPrecedent, BorderLayout.WEST);

		// Affichage et saisie du temps
		this.temps = new JTextField (3) ;
		this.temps.setText ("0") ;
		this.temps.setHorizontalAlignment (JTextField.CENTER) ;
		this.add (this.temps, BorderLayout.CENTER) ;

		// Bouton "Temps suivant"
		this.BPSuivant = new JButton (">") ;

		this.add (this.BPSuivant, BorderLayout.EAST) ;
    
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
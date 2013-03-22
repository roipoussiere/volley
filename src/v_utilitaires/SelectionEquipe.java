package v_utilitaires;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SelectionEquipe extends JPanel
{
	private JButton equipe1, equipe2 ;

	public SelectionEquipe ()
	{
		// Mise en place du GridBagLayout
		this.setLayout (new GridBagLayout ()) ;
		GridBagConstraints gbc = new GridBagConstraints () ;

		// Bouton équipe 1
		this.equipe1 = new JButton ("E1") ;
		gbc.gridx = 0 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 5, 0, 5) ;
		this.add (this.equipe1, gbc) ;

		// Bouton équipe 2
		this.equipe2 = new JButton ("E2") ;
		gbc.gridx = 1 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 5, 0, 5) ;
		this.add (this.equipe2, gbc) ;
	}
	
	
	// Getters
	
	public JButton getButtonEquipe1 ()
	{
		return this.equipe1 ;
	}
	
	public JButton getButtonEquipe2 ()
	{
		return this.equipe2 ;
	}
	
	
	// Accesseurs
	
	public int getNumEquipeSelec ()
	{
		if (this.equipe1.isEnabled())
			return 1 ;
		else
			return 2 ;
	}
}

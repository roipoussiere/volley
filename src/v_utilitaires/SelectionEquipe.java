package v_utilitaires;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SelectionEquipe extends JPanel implements ActionListener
{
	private JButton equipe1, equipe2 ;

	public SelectionEquipe ()
	{
		// Mise en place du GridBagLayout
		this.setLayout (new GridBagLayout ()) ;
		GridBagConstraints gbc = new GridBagConstraints () ;

		// Bouton équipe 1
		this.equipe1 = new JButton ("E1") ;
		this.equipe1.setEnabled(false) ;
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
		
		// Abonnement au listener
		this.equipe1.addActionListener(this) ;
		this.equipe2.addActionListener(this) ;
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
		if (!this.equipe1.isEnabled())
			return 1 ; // Si le bouton "E1" est enfoncé, c'est que l'on traite l'équipe 1...
		else
			return 2 ; // sinon, on traite l'équipe 2
	}


	// Listeners
	
	@Override
	public void actionPerformed (ActionEvent _ae)
	{
		if (_ae.getSource().equals(this.equipe1))
		{
			this.equipe1.setEnabled(false) ;
			this.equipe2.setEnabled(true) ;
		}
		
		if (_ae.getSource().equals(this.equipe2))
		{
			this.equipe2.setEnabled(false) ;
			this.equipe1.setEnabled(true) ;
		}
	}
}

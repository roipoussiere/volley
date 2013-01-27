package v;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class AL_Joueurs implements ActionListener
{
	private Vue_Joueurs vj;
	
	public AL_Joueurs(Vue_Joueurs _vj)
	{
		this.vj = _vj;
	}

	
	public void actionPerformed(ActionEvent _ae)
	{
		if(_ae.getSource().equals(this.vj.getJcbTse1())) // checkbox selection de tous les joueurs de l'équipe 1
		{
			
			if(this.vj.getJcbTse1().isSelected()==true)
			{
				// Selectionne tous les cases
				this.vj.getJcbJ1e1().setSelected(true);
				this.vj.getJcbJ2e1().setSelected(true);
				this.vj.getJcbJ3e1().setSelected(true);
				this.vj.getJcbJ4e1().setSelected(true);
				this.vj.getJcbJ5e1().setSelected(true);
				this.vj.getJcbJ6e1().setSelected(true);	
				// Desactive tous les cases
				this.vj.getJcbJ1e1().setEnabled(false);
				this.vj.getJcbJ2e1().setEnabled(false);
				this.vj.getJcbJ3e1().setEnabled(false);
				this.vj.getJcbJ4e1().setEnabled(false);
				this.vj.getJcbJ5e1().setEnabled(false);
				this.vj.getJcbJ6e1().setEnabled(false);
			}
			if(this.vj.getJcbTse1().isSelected()==false)
			{
				this.vj.getJcbJ1e1().setSelected(false);
				this.vj.getJcbJ2e1().setSelected(false);
				this.vj.getJcbJ3e1().setSelected(false);
				this.vj.getJcbJ4e1().setSelected(false);
				this.vj.getJcbJ5e1().setSelected(false);
				this.vj.getJcbJ6e1().setSelected(false);	
				// Reactive tous les cases
				this.vj.getJcbJ1e1().setEnabled(true);
				this.vj.getJcbJ2e1().setEnabled(true);
				this.vj.getJcbJ3e1().setEnabled(true);
				this.vj.getJcbJ4e1().setEnabled(true);
				this.vj.getJcbJ5e1().setEnabled(true);
				this.vj.getJcbJ6e1().setEnabled(true);
			}
		}
		if(_ae.getSource().equals(this.vj.getJcbTse2())) // checkbox selection de tous les joueurs de l'équipe 2
		{
			if(this.vj.getJcbTse2().isSelected()==true)
			{
				// Selectionne tous les cases
				this.vj.getJcbJ1e2().setSelected(true);
				this.vj.getJcbJ2e2().setSelected(true);
				this.vj.getJcbJ3e2().setSelected(true);
				this.vj.getJcbJ4e2().setSelected(true);
				this.vj.getJcbJ5e2().setSelected(true);
				this.vj.getJcbJ6e2().setSelected(true);
				// Desactive tous les cases
				this.vj.getJcbJ1e2().setEnabled(false);
				this.vj.getJcbJ2e2().setEnabled(false);
				this.vj.getJcbJ3e2().setEnabled(false);
				this.vj.getJcbJ4e2().setEnabled(false);
				this.vj.getJcbJ5e2().setEnabled(false);
				this.vj.getJcbJ6e2().setEnabled(false);
			}
			if(this.vj.getJcbTse2().isSelected()==false)
			{
				this.vj.getJcbJ1e2().setSelected(false);
				this.vj.getJcbJ2e2().setSelected(false);
				this.vj.getJcbJ3e2().setSelected(false);
				this.vj.getJcbJ4e2().setSelected(false);
				this.vj.getJcbJ5e2().setSelected(false);
				this.vj.getJcbJ6e2().setSelected(false);
				// Reactive tous les cases
				this.vj.getJcbJ1e2().setEnabled(true);
				this.vj.getJcbJ2e2().setEnabled(true);
				this.vj.getJcbJ3e2().setEnabled(true);
				this.vj.getJcbJ4e2().setEnabled(true);
				this.vj.getJcbJ5e2().setEnabled(true);
				this.vj.getJcbJ6e2().setEnabled(true);
			}
		}
	}

}
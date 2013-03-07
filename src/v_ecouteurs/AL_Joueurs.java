
package v_ecouteurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import v_vues.Vue_Joueurs;



public class AL_Joueurs implements ActionListener
{
	private Vue_Joueurs vj;
	
	public AL_Joueurs(Vue_Joueurs _vj)
	{
		this.vj = _vj;
	}

	@Override
	public void actionPerformed(ActionEvent _ae)
	{
		if(_ae.getSource().equals(this.vj.getJcbTout1())) // checkbox selection de tous les joueurs de l'équipe 1
		{

			if(this.vj.getJcbTout1().isSelected()==true)
			{

				// Selectionne toutes les cases
				for(int j=0; j < this.vj.getJoueur1().length;j++)
					this.vj.getJoueur1()[j].getAfficher().setSelected(true);

				// Desactive toutes les cases
				for(int j=0; j < this.vj.getJoueur1().length;j++)
					this.vj.getJoueur1()[j].getAfficher().setEnabled(false);
			}
			
			if(this.vj.getJcbTout1().isSelected()==false)
			{
				for(int j=0; j < this.vj.getJoueur1().length;j++)
					this.vj.getJoueur1()[j].getAfficher().setSelected(false);
	
				// Reactive toutes les cases
				for(int j=0; j < this.vj.getJoueur1().length;j++)
					this.vj.getJoueur1()[j].getAfficher().setEnabled(true);

			}
		}
		if(_ae.getSource().equals(this.vj.getJcbTout2())) // checkbox selection de tous les joueurs de l'équipe 2
		{

			if(this.vj.getJcbTout2().isSelected()==true)
			{

				// Selectionne toutes les cases
				for(int j=0; j < this.vj.getJoueur2().length;j++)
					this.vj.getJoueur2()[j].getAfficher().setSelected(true);

				// Desactive toutes les cases
				for(int j=0; j < this.vj.getJoueur2().length;j++)
					this.vj.getJoueur2()[j].getAfficher().setEnabled(false);
			}
			
			if(this.vj.getJcbTout2().isSelected()==false)
			{
				for(int j=0; j < this.vj.getJoueur2().length;j++)
					this.vj.getJoueur2()[j].getAfficher().setSelected(false);
	
				// Reactive toutes les cases
				for(int j=0; j < this.vj.getJoueur2().length;j++)
					this.vj.getJoueur2()[j].getAfficher().setEnabled(true);

			}
		}
		
		if(_ae.getSource().equals(this.vj.getMeneurPresentEqu1())) // checkbox selection de l'activation du meneur
		{
			if(this.vj.getMeneurPresentEqu1().isSelected()==false)
			{
				// Active toutes les cases
				for(int j=0; j < this.vj.getJoueur1().length;j++)
					this.vj.getJoueur1()[j].getMeneur().setEnabled(true);
			}
			
			if(this.vj.getMeneurPresentEqu1().isSelected()==true)
			{
				for(int j=0; j < this.vj.getJoueur1().length;j++)
					this.vj.getJoueur1()[j].getMeneur().setSelected(false);
	
				// Deactive toutes les cases
				for(int j=0; j < this.vj.getJoueur1().length;j++)
					this.vj.getJoueur1()[j].getMeneur().setEnabled(false);

			}
		}
		
		if(_ae.getSource().equals(this.vj.getMeneurPresentEqu2())) // checkbox selection de l'activation du meneur
		{
			if(this.vj.getMeneurPresentEqu2().isSelected()==false)
			{
				// Desactive toutes les cases
				for(int j=0; j < this.vj.getJoueur2().length;j++)
					this.vj.getJoueur2()[j].getMeneur().setEnabled(true);
			}
			
			if(this.vj.getMeneurPresentEqu2().isSelected()==true)
			{
				for(int j=0; j < this.vj.getJoueur2().length;j++)
					this.vj.getJoueur2()[j].getMeneur().setSelected(false);
	
				// Reactive toutes les cases
				for(int j=0; j < this.vj.getJoueur2().length;j++)
					this.vj.getJoueur2()[j].getMeneur().setEnabled(false);
			}
		}
		
		// Si on enregistre
		if(_ae.getSource().equals(this.vj.getJbouton1()))
		{
			for(int i=0; i < this.vj.getJoueur1().length;i++)
			this.vj.getC().getP().setNomE(this.vj.getJoueur1()[i].getNomJoueur().getText(), i+1);
		}
		
		if(_ae.getSource().equals(this.vj.getJbouton2()))
		{
			for(int i=0; i < this.vj.getJoueur2().length;i++)
			this.vj.getC().getP().setNomE(this.vj.getJoueur2()[i].getNomJoueur().getText(), i+7);
		}
	}

}
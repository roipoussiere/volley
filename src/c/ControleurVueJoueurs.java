package c;

import javax.swing.JOptionPane;

import m.Strategie;
import v_vues.Vue_Fenetre;
import v_vues.Vue_Joueurs;

/**
 * Contrôleur de la vue Édition.
 * @author Xavier
 */

public class ControleurVueJoueurs {

	private Vue_Joueurs vj ;
	private Vue_Fenetre vf ;
	private ControleurPrincipal cp;
	
	public ControleurVueJoueurs (ControleurPrincipal _cp)
	{
		this.cp = _cp;
		vj = new Vue_Joueurs(this.vf,this);
		vj.setVisible(true) ;
	}
	
	public void EnregistreEqu1()
	{
		for(int i=0; i < this.vj.getJoueur1().length;i++)
		{
			this.cp.getS().getEq1().getJoueur(i).setNomJ(this.vj.getJoueur1()[i].getNomJoueur().getText());
			this.cp.getS().getEq1().getJoueur(i).setAffiche(this.vj.getJoueur1()[i].getAfficher().isSelected());
			this.cp.getS().getEq1().getJoueur(i).setMeneur(this.vj.getJoueur1()[i].getMeneur().isSelected());
		}
		
		//Affichage de message de confirmation
		JOptionPane.showMessageDialog(vj,"Configuration de l'equipe 1 enregistrée");
	}
	
	public void EnregistreEqu2()
	{
		for(int i=0; i < this.vj.getJoueur2().length;i++)
		{
			this.cp.getS().getEq2().getJoueur(i).setNomJ(this.vj.getJoueur2()[i].getNomJoueur().getText());
			this.cp.getS().getEq2().getJoueur(i).setAffiche(this.vj.getJoueur2()[i].getAfficher().isSelected());
			this.cp.getS().getEq2().getJoueur(i).setMeneur(this.vj.getJoueur2()[i].getMeneur().isSelected());
		}
		//Affichage de message de confirmation
				JOptionPane.showMessageDialog(vj,"Configuration de l'equipe 2 enregistrée");
	}
	
	public Strategie getStrategie()
	{
		return this.cp.getS();
	}
}

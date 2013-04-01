package c;

import javax.swing.JOptionPane;

import m.Strategie;
import v_vues.Vue_Fenetre;
import v_vues.Vue_Joueurs;

/**
 * Contrôleur de la vue joueur.
 * @author Xavier v1.1
 */

public class ControleurVueJoueurs {

	private Vue_Joueurs vj ;
	private Vue_Fenetre vf ;
	private ControleurPrincipal cp;
	private boolean estSauvegardeEqu1 = true;
	private boolean estSauvegardeEqu2 = true;
	
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
		this.cp.getCVE().majVue();
		
		//Affichage de message de confirmation
		JOptionPane.showMessageDialog(vj,"Configuration de l'équipe 1 enregistrée");
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
		JOptionPane.showMessageDialog(vj,"Configuration de l'équipe 2 enregistrée");
		this.cp.getCVE().majVue();
	}
	
	public void getequipesSauvegarde1(boolean _save)
	{
		estSauvegardeEqu1 =  _save;
		System.out.println("Le getequipesSauvegarde1 est :"+_save);
	}
	
	public void getequipesSauvegarde2(boolean _save)
	{
		estSauvegardeEqu2 = _save;
	}
	
	public int estEnregistre()
	{
		if(!estSauvegardeEqu1)
			return 1;
		else if(!estSauvegardeEqu2)
			return 2;
		else
			return 0;
	}
	
	public Strategie getStrategie()
	{
		return this.cp.getS();
	}
}

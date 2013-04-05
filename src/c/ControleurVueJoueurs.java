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
	private boolean deselectionEq1 = false ,deselectionEq2 = false ;
	


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
		if(deselectionEq1)
		{
			for(int i=0; i < this.vj.getJoueur1().length;i++)
			{
				this.cp.getS().getEq1().getJoueur(i).setMeneur(false);
			}
		}
		this.cp.getCVE().majVue();
		this.cp.getCVD().majDessin();
		
		//Affichage de message de confirmation
		JOptionPane.showMessageDialog(vj,"Configuration de l'équipe 1 enregistrée");
		this.cp.getCVF().setSauvegarder(false);
	}
	
	public void EnregistreEqu2()
	{
		for(int i=0; i < this.vj.getJoueur2().length;i++)
		{
			this.cp.getS().getEq2().getJoueur(i).setNomJ(this.vj.getJoueur2()[i].getNomJoueur().getText());
			this.cp.getS().getEq2().getJoueur(i).setAffiche(this.vj.getJoueur2()[i].getAfficher().isSelected());
			this.cp.getS().getEq2().getJoueur(i).setMeneur(this.vj.getJoueur2()[i].getMeneur().isSelected());
		}
		if(deselectionEq2)
		{
			for(int i=0; i < this.vj.getJoueur1().length;i++)
			{
				this.cp.getS().getEq2().getJoueur(i).setMeneur(false);
			}
		}
		//Affichage de message de confirmation
		JOptionPane.showMessageDialog(vj,"Configuration de l'équipe 2 enregistrée");
		this.cp.getCVE().majVue();
		this.cp.getCVD().majDessin();
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
	
	public void setDeselectionEq1(boolean deselectionEq1) {
		this.deselectionEq1 = deselectionEq1;
	}

	public void setDeselectionEq2(boolean deselectionEq2) {
		this.deselectionEq2 = deselectionEq2;
	}
}

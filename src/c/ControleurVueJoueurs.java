package c;

import m.Equipe;
import m.Strategie;
import v_vues.Vue_Joueurs;

/**
 * Contrôleur de la vue Édition.
 * @author Xavier
 */

public class ControleurVueJoueurs {

	private Vue_Joueurs vj ;
	private Strategie str ;
	
	public ControleurVueJoueurs (Vue_Joueurs _vj, Strategie _str)
	{
		this.vj = _vj;
		this.str = _str;
		
		//vj.majVueJoueurs ();
		
		
		/* La suite du code nécessite  la creation d'une strategie dans le controleur et remplacera l'ancien code
		
		
		 * 
		 * Liaison avec les noms des joueurs des equipes
		 * 
		 * Pre-parametrage des donnnées de la fenetre par boucle sur :
		 * 
		 * 		- Est afficher
		 * 		- Est meneur
		 * 
		 * 
		 * 
		 */
	}
	
	
	public void majVueJoueurs ()
	{
		// On récupère l'équipe en cours de traitement
		Equipe eqSelec1,eqSelec2 ;
			eqSelec1 = this.getStrategie().getEq1() ; // équipe 1
			eqSelec2 = this.getStrategie().getEq2() ; // équipe 2
		
			
			for(int i=0; i < 6;i++)
			{
				//Equipe 1
				this.vj.getJoueur1()[i].getNomJoueur().setText(eqSelec1.getJoueur(i).getNomJ());//Remplissage des noms
				this.vj.getJoueur1()[i].getAfficher().setEnabled(eqSelec1.getJoueur(i).isAffiche());//Remplissage de l'option afficher
				this.vj.getJoueur1()[i].getMeneur().setEnabled(eqSelec1.getJoueur(i).isMeneur ());//Remplissage de l'option meneur
				//Equipe 2
				this.vj.getJoueur2()[i].getNomJoueur().setText(eqSelec2.getJoueur(i).getNomJ());//Remplissage des noms
				this.vj.getJoueur2()[i].getAfficher().setEnabled(eqSelec2.getJoueur(i).isAffiche());//Remplissage de l'option afficher
				this.vj.getJoueur2()[i].getMeneur().setEnabled(eqSelec2.getJoueur(i).isMeneur ());//Remplissage de l'option meneur
			}
			
	}
	
	public void EnregistreEqu1()
	{
		for(int i=0; i < this.vj.getJoueur1().length;i++)
			this.str.getEq1().getJoueur(i).setNomJ(this.vj.getJoueur1()[i].getNomJoueur().getText());
	}
	
	public void EnregistreEqu2()
	{
		for(int i=0; i < this.vj.getJoueur2().length-1;i++)
			this.str.getEq2().getJoueur(i).setNomJ(this.vj.getJoueur1()[i].getNomJoueur().getText());
	}
	
	public Strategie getStrategie ()
	{
		return this.str ;
	}
}

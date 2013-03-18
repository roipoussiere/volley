package c;

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
		
		// La suite du code nécessite  la creation d'une strategie dans le controleur et remplacera l'ancien code
		
		/*
		 * 
		 * Liaison avec les noms des joueurs des equipes
		 * 
		 * Pre-parametrage des donnnées de la fenetre par boucle sur :
		 * 
		 * 		- Est afficher
		 * 		- Est meneur
		 * 
		 * 
		 */
		
	}
	
	public void EnregistreEqu1()
	{
		for(int i=0; i < this.vj.getJoueur1().length;i++)
			this.cp.getS().getEq1().getJoueur(i).setNomJ(this.vj.getJoueur1()[i].getNomJoueur().getText());
	}
	
	public void EnregistreEqu2()
	{
		for(int i=0; i < this.vj.getJoueur2().length;i++)
			this.cp.getS().getEq2().getJoueur(i).setNomJ(this.vj.getJoueur1()[i].getNomJoueur().getText());
	}
	
	public Strategie getStrategie()
	{
		return this.cp.getS();
	}
}

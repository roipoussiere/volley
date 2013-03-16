package c;

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
	/*	this.vj = new Vue_Joueurs(this.cp.getCVF().getVueFenetre());
		
		for(int i=0; i < 6;i++)
		this.vj.getJoueur1()[i].getNomJoueur().setText(this.cp.getP().getNomE(i+1));
		for(int i=6; i < 12;i++)
			this.vj.getJoueur2()[i-6].getNomJoueur().setText(this.cp.getP().getNomE(i+1));
		
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
  

}

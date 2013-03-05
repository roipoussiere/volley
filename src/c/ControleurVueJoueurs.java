package c;

import v_vues.Vue_Fenetre;
import v_vues.Vue_Joueurs;

public class ControleurVueJoueurs {

	private Controleur c;
	private Vue_Joueurs vj;
	
	
	public ControleurVueJoueurs (Controleur _c,Vue_Joueurs _vj)
	{
		this.c = _c;
		this.vj = _vj;
		for(int i=0; i < 6;i++)
		this.vj.getJoueur1()[i].getNomJoueur().setText(this.c.getP().getNomE(i+1));
		for(int i=6; i < 12;i++)
			this.vj.getJoueur2()[i-6].getNomJoueur().setText(this.c.getP().getNomE(i+1));
	}
}

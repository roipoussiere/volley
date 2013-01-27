package v_ecouteurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

import v_vues.Vue_Fenetre;

public class AL_Fenetre implements ActionListener
{
	private Vue_Fenetre vf;
	
	public AL_Fenetre(Vue_Fenetre _vf)
	{
		this.vf = _vf;
	}
	
	public void actionPerformed(ActionEvent _ae)
	{
		String t = ((JMenuItem)_ae.getSource()).getText();
		
		if (t == "Ouvrir")
			this.vf.getC().mf_ouvrir();
		
		else if (t == "Nouveau")
			this.vf.getC().mf_nouveau();
		
		else if (t == "Enregistrer")
			this.vf.getC().mf_enregistrer();
		
		else if (t == "Enregistrer sous")
			this.vf.getC().mf_enregistrerSous();
		
		else if (t == "Quitter")
			this.vf.getC().quitter();
		
		else if (t == "Joueurs")
			this.vf.getC().ms_joueurs();

		else if (t == "Demi terrain")
			this.vf.getC().ms_terrain(true);

		else if (t == "Terrain complet")
			this.vf.getC().ms_terrain(false);

		else if (t == "Paramètres...")
			this.vf.getC().mp_param();

		else if (t == "Besoin d'aide ?")
			this.vf.getC().ma_aide();

		else if (t == "À propos de ce programme")
			this.vf.getC().ma_apropos();

		else
			System.out.println("Erreur : écouteur inconnu.");
	}

}

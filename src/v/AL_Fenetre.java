package v;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

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
			vf.getC().mf_ouvrir();
		
		else if (t == "Nouveau")
			vf.getC().mf_nouveau();
		
		else if (t == "Enregistrer")
			vf.getC().mf_enregistrer();
		
		else if (t == "Enregistrer sous")
			vf.getC().mf_enregistrerSous();
		
		else if (t == "Quitter")
			vf.getC().quitter();
		
		else if (t == "Joueurs")
			vf.getC().ms_joueurs();

		else if (t == "Terrain")
			vf.getC().ms_terrain();

		else if (t == "Grille")
			vf.getC().mp_grille();

		else if (t == "Couleurs")
			vf.getC().mp_couleurs();

		else if (t == "Besoin d'aide ?")
			vf.getC().ma_aide();

		else if (t == "À propos de ce programme")
			vf.getC().ma_apropos();

		else
			System.out.println("Erreur : écouteur inconnu.");
	}

}

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
	
	@Override
	public void actionPerformed(ActionEvent _ae)
	{
		String t = ((JMenuItem)_ae.getSource()).getText();
		
		if ("Ouvrir".equals(t)) {
			this.vf.getC().mf_ouvrir();
		}
		
		else if ("Nouveau".equals(t)) {
			this.vf.getC().mf_nouveau();
		}
		
		else if ("Enregistrer".equals(t)) {
			this.vf.getC().mf_enregistrer();
		}
		
		else if ("Enregistrer sous".equals(t)) {
			this.vf.getC().mf_enregistrerSous();
		}
		
		else if ("Quitter".equals(t)) {
			this.vf.getC().quitter();
		}
		
		else if ("Joueurs".equals(t)) {
			this.vf.getC().ms_joueurs();
		}

		else if ("Demi terrain".equals(t)) {
			this.vf.getC().ms_terrain(true);
		}

		else if ("Terrain complet".equals(t)) {
			this.vf.getC().ms_terrain(false);
		}

		else if ("Paramètres...".equals(t)) {
			this.vf.getC().mp_param();
		}

		else if ("Besoin d'aide ?".equals(t)) {
			this.vf.getC().ma_aide();
		}

		else if ("À propos de ce programme".equals(t)) {
			this.vf.getC().ma_apropos();
		}

		else {
			System.out.println("Erreur : écouteur inconnu.");
		}
	}

}

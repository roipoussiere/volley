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
			this.vf.getCVF().mf_ouvrir();
		}
		
		else if ("Nouveau".equals(t)) {
			this.vf.getCVF().mf_nouveau();
		}
		
		else if ("Enregistrer".equals(t)) {
			this.vf.getCVF().mf_enregistrer();
		}
		
		else if ("Quitter".equals(t)) {
			this.vf.getCVF().quitter();
		}
		
		else if ("Joueurs".equals(t)) {
			this.vf.getCVF().ms_joueurs();
		}

		else if ("Demi terrain".equals(t)) {
			this.vf.getCVF().ms_terrain(true);
		}

		else if ("Terrain complet".equals(t)) {
			this.vf.getCVF().ms_terrain(false);
		}

		else if ("Paramètres...".equals(t)) {
			this.vf.getCVF().mp_param();
		}

		else if ("Besoin d'aide ?".equals(t)) {
			this.vf.getCVF().ma_aide();
		}

		else if ("À propos de ce programme".equals(t)) {
			this.vf.getCVF().ma_apropos();
		}

		else {
			System.out.println("Erreur : écouteur inconnu.");
		}
	}

}

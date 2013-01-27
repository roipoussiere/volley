package v;

import javax.swing.*;

/**
 * Vue de la fenêtre Joueurs.
 */
@SuppressWarnings("serial")
public class Vue_Params extends JDialog
{
	private Vue_Fenetre vf;
	
	// Composants de la fenêtre
	
	/**
	 * Création du JFrame et de tous ses composants.
	 * @param _c Constrôleur.
	 */
	public Vue_Params (Vue_Fenetre _vf)
	{
		super (_vf, "Paramètres", true);
		this.vf = _vf;
		this.setSize(400, 300);
		this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	/**
	 * Getter de la vue Fenêtre.
	 * @return La vue Fenêtre.
	 */
	public Vue_Fenetre getC()
	{
		return this.vf;
	}

}
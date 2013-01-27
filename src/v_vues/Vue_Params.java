package v_vues;

import javax.swing.*;

/**
 * Vue de la fenêtre des Paramètres.
 */
@SuppressWarnings("serial")
public class Vue_Params extends JDialog
{
	private Vue_Fenetre vf;
	
	// Composants de la fenêtre
	private JTabbedPane tp;
	private Vue_PGrille vpg;
	private Vue_PCouleurs vpc;
	
	/**
	 * Création de la JDialog et de tous ses composants.
	 * @param _vf Vue de la fenêtre principale.
	 */
	public Vue_Params (Vue_Fenetre _vf)
	{
		super (_vf, "Paramètres", true);
		this.vf = _vf;
		this.setSize(400, 300);
		this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.tp = new JTabbedPane();
		
		// Ajout de l'onglet Grille dans la barre des onglets
		this.vpg = new Vue_PGrille(this.vf.getC());
		this.tp.addTab("Grille", this.vpg);
		
		// Ajout de l'onglet Couleurs dans la barre des onglets
		this.vpc = new Vue_PCouleurs(this.vf.getC());
		this.tp.addTab("Couleurs", this.vpc);
		
		this.add(this.tp); // Ajout de la barre d'onglets dans la fenêtre

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
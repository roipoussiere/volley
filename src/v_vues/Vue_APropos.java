package v_vues;

import javax.swing.*;

/**
 * Vue de la fenêtre des Paramètres.
 * @author Nathanaël Jourdane
 */
@SuppressWarnings("serial")
public class Vue_APropos extends JDialog
{
	private Vue_Fenetre vf;
	
	// Composants de la fenêtre
	private JLabel txt;
	
	/**
	 * Création de la JDialog et de tous ses composants.
	 * @param _vf Vue de la fenêtre principale.
	 */
	public Vue_APropos (Vue_Fenetre _vf)
	{
		super (_vf, "À propos de ce programme...", true);
		this.vf = _vf;
		this.setSize(400, 200);
		this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		String texte = "<html>Ce programme a été réalisé par des étuditans de l'IUT informatique de Blagnac, " +
				"dans le cadre du projet tuteuré de 2ème année.<br/><br/>" +
				"Il a été développé par :<br/><br/>" +
				"- Nathanaël Jourdane<br/>" +
				"- Florian Garnier<br/>" +
				"- Xavier Chalut<br/>" +
				"- Julien-Marc Ampouta</html>";
		
		this.txt = new JLabel(texte);
		this.add(txt);
		
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
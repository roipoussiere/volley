package v_vues;

import javax.swing.*;

/**
 * Vue de la fenêtre des Paramètres.
 * @author Nathanaël Jourdane
 */
@SuppressWarnings("serial")
public class Vue_Aide extends JDialog
{
	private Vue_Fenetre vf;
	
	// Composants de la fenêtre
	private JLabel txt;
	
	/**
	 * Création de la JDialog et de tous ses composants.
	 * @param _vf Vue de la fenêtre principale.
	 */
	public Vue_Aide (Vue_Fenetre _vf)
	{
		super (_vf, "Coment utiliser ce programme...", true);
		this.vf = _vf;
		this.setSize(400, 200);
		this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		String texte = "<html>Veuillez consulter le manuel d'utilisation. Merci</html>";
		
		this.txt = new JLabel(texte);
		this.txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); // Ne marche pas.
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

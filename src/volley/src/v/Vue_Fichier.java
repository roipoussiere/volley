package v;

import javax.swing.*;

import c.Controleur;

/**
 * Vue contenant les élements de l'onglet Joueur.
 */
public class Vue_Fichier extends JPanel
{
	private static final long serialVersionUID = 1L;
	private Controleur c;
	
	// Composants de la fenêtre
	private JButton jbParcourir;
	private JLabel jbNomFichier;
	
	/**
	 * Création du JFrame et de tous ses composants.
	 * @param _c Contrôleur.
	 * @author Nathanaël Jourdane
	 */
	public Vue_Fichier (Controleur _c)
	{
		super ();
		this.c = _c;
		
		this.jbNomFichier = new JLabel("Sélectionnez un fichier");
		this.add (this.jbNomFichier);
		
		this.jbParcourir = new JButton ("Parcourir");
		this.jbParcourir.addActionListener(new AL_Parcourir(this));
		this.add (this.jbParcourir);
	}
	
	public void majLibelle()
	{
		this.jbNomFichier.setText(this.c.getNomFichier());
	}
	/**
	 * Getter du contrôleur.
	 * @return Le contrôleur.
	 * @author Nathanaël Jourdane
	 */
	public Controleur getC()
	{
		return this.c;
	}
}
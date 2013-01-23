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
	 * @param _c Constrôleur.
	 * @author Nathanaël Jourdane
	 */
	public Vue_Fichier (Controleur _c)
	{
		super ();
		this.c = _c;
		
		this.jbNomFichier = new JLabel(this.c.libelleNomFichier());
		this.add (this.jbNomFichier);
		
		this.jbParcourir = new JButton ("Parcourir");
		this.jbParcourir.addActionListener(new AL_Parcourir(this));
		this.add (this.jbParcourir);
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
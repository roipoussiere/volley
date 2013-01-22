package v;

import java.awt.*;
import javax.swing.*;

import c.Controleur;

/**
 * Vue contenant les élements de l'onglet Lecture.
 */
public class Vue_Lecture extends JPanel
{
	private static final long serialVersionUID = 1L;
	private Controleur c;
	
	// Composants de la fenêtre
	private JTextField jtfNomFichier;
	private JButton jbParcourir;
	private JRadioButton jrbAvecPause;
	private JRadioButton jrbSansPause;
	private JButton jbLecture;
	
	/**
	 * Création du JFrame et de tous ses composants.
	 * @param _c Constrôleur.
	 * @author Nathanaël Jourdane
	 */
	public Vue_Lecture (Controleur _c)
	{
		super ();
		this.c = _c;

		this.setPreferredSize(new Dimension(385, 240)); // Affectation de la taille du contenu de l'onglet
		this.add(new JLabel ("Fichier de stratégie :"));		

		this.jtfNomFichier = new JTextField("strategie.fsv");
		this.add (this.jtfNomFichier);
		
		this.jbParcourir = new JButton ("Parcourir...");
		this.jbParcourir.addActionListener(new AL_Parcourir(this));
		this.add (this.jbParcourir);
		
		this.add(new JLabel ("Mode de lecture :"));		

		this.jrbSansPause = new JRadioButton();
		this.add (this.jrbSansPause);

		this.jrbAvecPause = new JRadioButton();
		this.add (this.jrbAvecPause);

		this.jbLecture = new JButton ("Lecture");
		this.jbLecture.addActionListener(new AL_Lecture(this));
		this.add (this.jbLecture);
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
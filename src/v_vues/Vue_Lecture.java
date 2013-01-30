package v_vues;

import c.Controleur;
import java.awt.*;
import javax.swing.*;
import v_utilitaires.SelectionTemps;

/**
 * Vue contenant les élements de l'onglet Lecture.
 * @author Julien Ampouta
 */
@SuppressWarnings("serial")
public class Vue_Lecture extends JPanel
{
	private Controleur c;

	// Composants de la fenêtre
	private SelectionTemps selecTps ;
	private JLabel libelleFichier ;
	private JButton  lecture, stop, pleinEcran;

	/**
	 * Création du JFrame et de tous ses composants.
	 * @param _c Constrôleur.
	 */
	public Vue_Lecture (Controleur _c)
	{
		super ();
		this.c = _c;
		

		// Mise en place du GridBagLayout
		this.setLayout (new GridBagLayout()) ;
		GridBagConstraints gbc = new GridBagConstraints () ;
		gbc.weightx = 1;
		gbc.weighty = 1;

		// Sélection du temps
		this.selecTps = new SelectionTemps () ;
		gbc.gridx = 0 ; gbc.gridy = 1 ;
		gbc.gridwidth = 3 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.PAGE_START ;
		gbc.insets = new Insets (0, 0, 0, 0) ;
		this.add (this.selecTps, gbc) ;
		
		// Nom fichier
		this.libelleFichier = new JLabel ("Nom du fichier... ") ;
		gbc.anchor = GridBagConstraints.CENTER ;
		gbc.insets = new Insets (0, 0, 0, 0) ;
		this.add (this.libelleFichier, gbc) ;
		
		// Bouton Play/Pause
		this.lecture = new JButton("l>");
		gbc.gridx = 0 ; gbc.gridy = 20 ;
		gbc.anchor = GridBagConstraints.PAGE_END ;
		gbc.insets = new Insets (0, 0, 0, 0) ;
		this.add (this.lecture, gbc) ;

		// Bouton Stop
		this.stop = new JButton("[]");
		gbc.gridwidth = 3 ;
		gbc.anchor = GridBagConstraints.LAST_LINE_START ;
		gbc.insets = new Insets (0, 120, 0, 0) ;
		this.add (this.stop, gbc) ;

		// Bouton Plein écran
		this.pleinEcran = new JButton("X");
		gbc.gridwidth = 3 ;
		gbc.anchor = GridBagConstraints.LAST_LINE_END ;
		gbc.insets = new Insets (0, 0, 0, 120) ;
		this.add (this.pleinEcran, gbc) ;
	}

	/**
	 * Getter du contrôleur.
	 * @return Le contrôleur.
	 */
	public Controleur getC()
	{
		return this.c;
	}

	public SelectionTemps getSelecTps() {
		return selecTps;
	}

	public void setSelecTps(SelectionTemps selecTps) {
		this.selecTps = selecTps;
	}

	public JLabel getLibelleFichier() {
		return libelleFichier;
	}

	public void setLibelleFichier(JLabel libelleFichier) {
		this.libelleFichier = libelleFichier;
	}

	public JButton getLecture() {
		return lecture;
	}

	public void setLecture(JButton lecture) {
		this.lecture = lecture;
	}

	public JButton getStop() {
		return stop;
	}

	public void setStop(JButton stop) {
		this.stop = stop;
	}

	public JButton getPleinEcran() {
		return pleinEcran;
	}

	public void setPleinEcran(JButton pleinEcran) {
		this.pleinEcran = pleinEcran;
	}
}

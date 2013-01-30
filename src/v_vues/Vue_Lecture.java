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
	private JButton  lecture, debut, pleinEcran;

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
		
		JPanel boutons = new JPanel (new FlowLayout ()) ;

		// Bouton Début
		this.debut = new JButton("Début");
//		gbc.gridwidth = 3 ;
//		gbc.anchor = GridBagConstraints.LAST_LINE_START ;
//		gbc.insets = new Insets (0, 120, 0, 0) ;
//		this.add (this.stop, gbc) ;
		boutons.add (this.debut) ;
		
		// Bouton Play/Pause
		this.lecture = new JButton("Play/Pause");
//		gbc.gridx = 0 ; gbc.gridy = 20 ;
//		gbc.anchor = GridBagConstraints.PAGE_END ;
//		gbc.insets = new Insets (0, 0, 0, 0) ;
//		this.add (this.lecture, gbc) ;
		boutons.add (this.lecture) ;
		
		// Bouton Plein écran
		this.pleinEcran = new JButton("Plein écran");
//		gbc.gridwidth = 3 ;
//		gbc.anchor = GridBagConstraints.LAST_LINE_END ;
//		gbc.insets = new Insets (0, 0, 0, 120) ;
//		this.add (this.pleinEcran, gbc) ;
		boutons.add (this.pleinEcran) ;
		
		gbc.gridx = 0 ; gbc.gridy = 2 ;
		gbc.gridwidth = GridBagConstraints.REMAINDER ; gbc.gridheight = 3 ;
		gbc.anchor = GridBagConstraints.CENTER ;
		gbc.insets = new Insets (0, 0, 0, 0) ;
		this.add (boutons, gbc) ;
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
		return debut;
	}

	public void setStop(JButton stop) {
		this.debut = stop;
	}

	public JButton getPleinEcran() {
		return pleinEcran;
	}

	public void setPleinEcran(JButton pleinEcran) {
		this.pleinEcran = pleinEcran;
	}
}

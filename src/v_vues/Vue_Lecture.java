package v_vues;

import c.Controleur;
import java.awt.*;
import javax.swing.*;
import v_utilitaires.SelectionTemps;

/**
 * Vue contenant les éléments de l'onglet Lecture.
 * @author Julien Ampouta
 */
@SuppressWarnings("serial")
public class Vue_Lecture extends JPanel
{
	private Controleur c;

	// Composants de la fenÃªtre
	private JTextField chrono, libelleFichier ;
	// private ButtonGroup modeLecture;
	private JRadioButton automatique, manuel;
	private SelectionTemps selecTps ;
	private JTextArea commentaire ;
	private JButton lecture, debut, pleinEcran;

	/**
	 * Création du JFrame et de tous ses composants.
	 * @param _c ConstrÃ´leur.
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

		// Nom fichier
		this.libelleFichier = new JTextField ("..............Nom du fichier..............") ;
		this.libelleFichier.setEnabled(false);
		gbc.anchor = GridBagConstraints.PAGE_START ;
		gbc.gridx = 0 ; gbc.gridy = 1 ;
		gbc.gridwidth = 0 ; gbc.gridheight = 0 ;
		gbc.insets = new Insets (0, 0, 0, 0) ;
		this.add (this.libelleFichier, gbc) ;

		// Chronomètre
		this.chrono = new JTextField (3) ;
		this.chrono.setText ("00") ;
		this.chrono.setHorizontalAlignment (JTextField.CENTER) ;
		gbc.gridx = 0 ; gbc.gridy = 1 ;
		gbc.gridwidth = 0 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END ;
		gbc.insets = new Insets (0, 10, 10, 10) ;
		this.add (this.chrono, gbc) ;

		// Sélection du temps
		this.selecTps = new SelectionTemps (this.getC().getS());
		gbc.gridx = 0 ;
		gbc.gridy = 1 ;
		gbc.gridwidth = 3 ;
		gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 0, 0, 0) ;
		this.add (this.selecTps, gbc) ;

		// Choix du mode de lecture
		// this.modeLecture = new ButtonGroup() ;
		// this.automatique = new JRadioButton("Automatique", false);
		// this.modeLecture.add(this.automatique);
		// this.manuel = new JRadioButton("Manuel", false);
		// this.modeLecture.add(this.manuel);
		// gbc.gridx = 0 ; gbc.gridy = 1 ;
		// gbc.gridwidth = 2 ; gbc.gridheight = 1 ;
		// gbc.anchor = GridBagConstraints.LINE_END ;
		// gbc.insets = new Insets (0, 10, 10, 10) ;
		// this.add(this.modeLecture, gbc) ;

		// Automatique
		this.automatique = new JRadioButton("Automatique", false);
		gbc.gridx = 3 ; gbc.gridy = 1 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 10, 10, 10) ;
		this.add(this.automatique, gbc) ;

		// Manuel
		this.manuel = new JRadioButton("Manuel", false);
		gbc.gridx = 6 ; gbc.gridy = 1 ;
		gbc.gridwidth = 0 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 10, 10, 10) ;
		this.add(this.manuel, gbc) ;

		// Commentaires sur stratégies
		this.commentaire = new JTextArea (" Commentaires sur la stratégie",5,30);
		this.commentaire.setEnabled(false);
		gbc.gridx = 0 ; gbc.gridy = 1 ;
		gbc.gridwidth = 0 ; gbc.gridheight = 0 ;
		gbc.anchor = GridBagConstraints.CENTER ;
		gbc.insets = new Insets (0, 0, 0, 0) ;
		this.add (this.commentaire, gbc) ;


		JPanel boutons = new JPanel (new FlowLayout ()) ;

		// Bouton Début
		this.debut = new JButton("Début");
		gbc.anchor = GridBagConstraints.LAST_LINE_START ;
		gbc.insets = new Insets (0, 120, 0, 0) ;
		this.add (this.debut, gbc) ;
		boutons.add (this.debut) ;

		// Bouton Play/Pause
		this.lecture = new JButton("Play/Pause");
		gbc.anchor = GridBagConstraints.CENTER ;
		gbc.insets = new Insets (0, 0, 0, 0) ;
		this.add (this.lecture, gbc) ;
		boutons.add (this.lecture) ;

		// Bouton Plein écran
		this.pleinEcran = new JButton("Plein écran");
		gbc.anchor = GridBagConstraints.CENTER ;
		gbc.insets = new Insets (0, 0, 0, 120) ;
		this.add (this.pleinEcran, gbc) ;
		boutons.add (this.pleinEcran) ;

		gbc.gridx = 0 ; gbc.gridy = 2 ;
		gbc.gridwidth = GridBagConstraints.REMAINDER ; gbc.gridheight = 3 ;
		gbc.anchor = GridBagConstraints.PAGE_END ;
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

	public SelectionTemps getSelectTps() {
		return selecTps;
	}

	public void setSelectTps(SelectionTemps selecTps) {
		this.selecTps = selecTps;
	}

	public JTextField getLibelleFichier() {
		return libelleFichier;
	}

	public void setLibelleFichier(JTextField libelleFichier) {
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

	public void majVue() {
		this.selecTps.majSelectionTemps();
	}
}
package v_vues;

import c.ControleurVueLecture;
import java.awt.*;
import javax.swing.*;

import v_ecouteurs.AL_Lecture;
import v_utilitaires.SelectionTemps;

/**
 * Vue contenant les éléments de l'onglet Lecture.
 * @author Julien Ampouta
 */
@SuppressWarnings("serial")
public class Vue_Lecture extends JPanel
{
	private ControleurVueLecture cvl;

	// Composants de la fenêtre
	private JTextField libelleFichier ;
	private SelectionTemps selecTps ;

	/**
	 * Création du JFrame et de tous ses composants.
	 * @param _cvl Constrôleur de la vue Lecture.
	 */
	public Vue_Lecture (ControleurVueLecture _cvl)
	{
		super ();
		this.cvl = _cvl;

		// Nom fichier
		this.libelleFichier = new JTextField ("..............Nom du fichier..............") ;
		this.libelleFichier.setEnabled(false);
		this.add (this.libelleFichier, BorderLayout.NORTH) ;

		// Sélection du temps
		this.selecTps = new SelectionTemps ();
		this.add (this.selecTps, BorderLayout.SOUTH) ;

		// Abonnement aux listeners
		AL_Lecture lec = new AL_Lecture(this) ;
		this.selecTps.getButtonTpsPrecedent().addActionListener(lec) ;
		this.selecTps.getButtonTpsSuivant().addActionListener(lec) ;

		this.majVue() ;
	}


	// Mise à jour de la fenêtre

	public void majVue()
	{
		// On récupère la valeur du temps en cours
		int tpsEnCours = this.cvl.getCP().getS().getTA() ;

		// On met à jour l'affichage du temps en cours (permet de gérer le changement d'onglet)
		this.selecTps.getTextFieldTpsEnCours().setText(Integer.toString(tpsEnCours)) ;
		
		// Si on est au temps 0, on désactive le bouton "Temps précédent"
		if (tpsEnCours == 0)
			this.selecTps.getButtonTpsPrecedent().setEnabled(false) ;
		else // Sinon, on le ré-active (si besoin)
			this.selecTps.getButtonTpsPrecedent().setEnabled(true) ;
		
		// Si le temps affiché est le dernier saisi dans la stratégie, on désactive le bouton "Temps suivant"
		if (tpsEnCours == this.cvl.getCP().getS().getNbTemps() - 1)
			this.selecTps.getButtonTpsSuivant().setEnabled(false) ;
		else // Sinon, on le ré-active (si besoin)
			this.selecTps.getButtonTpsSuivant().setEnabled(true) ;
	}


	// Getters

	public ControleurVueLecture getC()
	{
		return cvl ;
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
}
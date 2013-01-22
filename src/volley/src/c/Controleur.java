package c;

import javax.swing.*;
import v.Vue_Edition;
import v.Vue_Lecture;
import v.Vue_Parcourir;

/**
 * Controleur du projet.<br/>
 * Contient le traitement de l'ensemble du programme, notament l'action suivie par le clic de chaque bouton.
 */
public class Controleur
{
	private Vue_Lecture vl;
	private Vue_Edition ve;
	private Vue_Parcourir vp;
	
	/**
	 * Initialise les vues.
	 * @author Nathanaël Jourdane
	 */
	public Controleur ()
	{
		this.vl = null;
		this.ve = null;
	}

	/**
	 * Lance la vue d'édition. C'est l'unique méthode utilisée par le main.
	 * @author Nathanaël Jourdane
	 */
	public void demarrer ()
	{
		if (this.ve == null)
		{
			this.vl = new Vue_Lecture(this);
			this.vl.setVisible (true);	
		}
	}
	
	// *** Getters ***
	
	/**
	 * Getter de Vue_Edition.
	 * @return La vue de l'édition d'une statégie.
	 * @author Nathanaël Jourdane
	 */
	public Vue_Edition getVE()
	{
		return ve;
	}
	
	/**
	 * Getter de Vue_Lecture.
	 * @return La vue de lecture d'une statégie.
	 * @author Nathanaël Jourdane
	 */
	public Vue_Lecture getVL()
	{
		return vl;
	}
		
	// *** Méthodes de Vue_Lecture ***
	
	/**
	 * Récupère le chemin et le nom du fichier à partir du composant JFileChooser.
	 * @author Nathanaël Jourdane
	 */
	public String vl_cheminNomStrategie(JFileChooser _jfcFichier)
	{
		String cheminNomFichier = null;
		// Un fichier a été choisi
		if(_jfcFichier.showOpenDialog(vl) == JFileChooser.APPROVE_OPTION)
		{
			// Nom du fichier  choisi 
			String nom = _jfcFichier.getSelectedFile().getName();
			
			// Chemin absolu du fichier choisi
			String chemin = _jfcFichier.getSelectedFile().getAbsolutePath();
			
			cheminNomFichier = nom + chemin;
			
			System.out.println("Le fichier sélectionné est : " + cheminNomFichier);
		}
		else // Pas de fichier choisi
		{
			System.out.println("Aucun fichier sélectionné");
		}
		
		return cheminNomFichier;
	}
	
	/**
	 * Lecture d'une stratégie.
	 */
	public void vl_lireStrategie()
	{
		System.out.println("Lecture d'une stratégie.");
	}
	
	/**
	 * Ouvre une nouvelle fenetre pour que l'utilisateur puisse sélectionner une stratégie.
	 * @author Nathanaël Jourdane
	 */
	public void vl_parcourir()
	{
		System.out.println("Sélection d'un fichier...");
		this.vp = new Vue_Parcourir(this);
		this.vp.setVisible (true);		
	}
	
	// *** Méthodes de Vue_Edition ***
	
	// *** Autres méthodes ***
	
	/**
	 * Ferme le programme, avec confirmation.
	 * @author Nathanaël Jourdane
	 */
	public void arreter ()
	{
		int option = JOptionPane.showConfirmDialog(this.vl, "Voulez-vous Quitter ?");
		System.out.println("Fermeture du programme.");
		if (option == JOptionPane.OK_OPTION)
			System.exit(0);
	}

	
	// *** Méthodes privées ***
	
}
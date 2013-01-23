package c;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

import v.Vue_Edition;
import v.Vue_Fichier;
import v.Vue_Joueurs;
import v.Vue_Lecture;
import v.Vue_Fenetre;
import v.Vue_Parcourir;
import v.Vue_Terrain;

/**
 * Contrôleur du projet.<br/>
 * Contient le traitement de l'ensemble du programme, notament l'action suivie par le clic de chaque bouton.
 */
public class Controleur
{
	private Vue_Fenetre vfe;
	private Vue_Parcourir vp;
	private Vue_Terrain vt;

	private Vue_Fichier vfi;
	private Vue_Joueurs vj;
	private Vue_Edition ve;
	private Vue_Lecture vl;
	
	private String nomFichier;
	private String cheminFichier;
	
	/**
	 * Constructeur du contôleur qui initialise les vues et les arguments.
	 * @author Nathanaël Jourdane
	 */
	public Controleur ()
	{
		this.nomFichier = null;
		this.cheminFichier = null;
		this.vfe = null;
		this.vp = null;
		this.vt = null;

		this.vfi = null;
		this.vj = null;
		this.ve = null;
		this.vl = null;
	}

	/**
	 * Lance la vue principale (Vue_Fenetre). C'est l'unique méthode utilisée par le main.
	 * @author Nathanaël Jourdane
	 */
	public void demarrer ()
	{
		if (this.vfe == null)
		{
			this.vfe = new Vue_Fenetre(this);
			this.centrerFen();
			this.vfe.setVisible (true);
			this.majOnglets();
		}
	}
	
	// *** Getters & Setters ***
	
	/**
	 * Getter de nom fichier.
	 * @return Le nom du fichier.
	 * @author Nathanaël Jourdane
	 */
	public String getNomFichier()
	{
		return this.nomFichier;
	}
		
	/**
	 * Setter de nom du fichier.
	 * @param _nom Le nom du fichier.
	 * @author Nathanaël Jourdane
	 */
	public void setNomFichier(String _nom)
	{
		this.nomFichier = _nom;
	}
	
	/**
	 * Getter de Vue_Fenetre.
	 * @return La fenêtre principale du programme
	 * @author Nathanaël Jourdane
	 */
	public Vue_Fenetre getVFE()
	{
		return this.vfe;
	}
	
	/**
	 * Getter de Vue_Parcourir.
	 * @return La fenetre permetant de sélectionner un fichier de stratégie.
	 * @author Nathanaël Jourdane
	 */
	public Vue_Parcourir getVP()
	{
		return this.vp;
	}
	
	/**
	 * Getter de Vue_Terrain.
	 * @return La fenetre représentant le terrain de volley.
	 * @author Nathanaël Jourdane
	 */
	public Vue_Terrain getVT()
	{
		return this.vt;
	}
	
	/**
	 * Getter de Vue_Fichier.
	 * @return La vue de l'onglet Fichier
	 * @author Nathanaël Jourdane
	 */
	public Vue_Fichier getVFI()
	{
		return this.vfi;
	}
	
	/**
	 * Getter de Vue_Joueurs.
	 * @return La vue de l'onglet Joueurs
	 * @author Nathanaël Jourdane
	 */
	public Vue_Joueurs getVJ()
	{
		return this.vj;
	}
	
	/**
	 * Getter de Vue_Edition.
	 * @return La vue de l'onglet Edition
	 * @author Nathanaël Jourdane
	 */
	public Vue_Edition getVE()
	{
		return this.ve;
	}
	
	/**
	 * Getter de Vue_Lecture.
	 * @return La vue de l'onglet Lecture
	 * @author Nathanaël Jourdane
	 */
	public Vue_Lecture getVL()
	{
		return this.vl;
	}
		
	// *** Méthodes de Vue_Lecture ***
	
	/**
	 * Lecture d'une stratégie.
	 * @author Nathanaël Jourdane
	 */
	public void vl_lireStrategie()
	{
		if (this.vt == null)
		{
			System.out.println("Lecture d'une stratégie...");
			this.vt = new Vue_Terrain(this);
			this.centrerFen();
			this.vt.setVisible (true);				
		}
		else
		{
			System.out.println("La fenetre de terrain est déjà ouverte");
		}
	}
	
	/**
	 * Ouvre une fenetre invitant à l'utilisateur à sélectionner un fichier de stratégie.
	 * @return Une chaine contenant le chemin du fichier suivi de son nom.
	 * @author Nathanaël Jourdane
	 */
	public void vf_parcourir()
	{
		System.out.println("Sélection d'un fichier...");
		this.vp = new Vue_Parcourir(this);
		int retour = this.vp.showOpenDialog(null);

		if(retour == JFileChooser.APPROVE_OPTION) // Si un fichier a été choisi
		{
			this.nomFichier = this.vp.getSelectedFile().getName(); // Nom du fichier  choisi 
			this.cheminFichier = this.vp.getSelectedFile().getAbsolutePath(); // Chemin absolu du fichier choisi
			
			System.out.println("Le fichier " + this.nomFichier + " a été sélectionné.");
			System.out.println("Il se trouve dans : " + this.cheminFichier);
			
			this.majOnglets(); // On met à jour les onglets pour démasquer l'onglet Lecture.
		}
		else // Pas de fichier choisi
		{
			System.out.println("Aucun fichier sélectionné");
		}
	}
	
	// *** Méthodes de Vue_Fichier ***
		
	// *** Méthodes de Vue_Edition ***
	
	// *** Méthodes de Vue_Terrain ***
	
	/**
	 * Ferme correctement la fenetre de terrain.
	 * @author Nathanaël Jourdane
	 */
	public void vt_fermer()
	{
		System.out.println("Fermeture de la fenetre du terrain.");
		this.vt.setVisible(false);
		this.vt = null;
		centrerFen();
	}
		
	// *** Méthodes de Vue_Fenetre ***
	
	/**
	 * Masque les onglets dont l'utilisateur n'a pas accès.
	 * @author Nathanaël Jourdane
	 */
	public void majOnglets()
	{
		if (this.nomFichier == null)
			this.vfe.affLecture(false);
		else
			this.vfe.affLecture(true);
	}
	
	/**
	 * Positionne une ou plusieurs fenetres au centre de l'écran.
	 * @author Nathanaël Jourdane
	 */
	public void centrerFen()
	{
		// Les dimentions de l'écran
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		if (this.vfe == null) // Si on la fenetre principale n'est pas ouverte
		{
			System.out.println("Aucune fenetre à centrer.");
		}
		else
		{
			if (this.vt == null) // Si la fenetre de terrain n'est pas ouverte
			{
				this.vfe.setLocation((screen.width - this.vfe.getSize().width)/2,(screen.height - this.vfe.getSize().height)/2);
				System.out.println("1 fenêtre centrée");
			}
			else
			{
				this.vfe.setLocation(screen.width/2 - this.vfe.getSize().width - 5,(screen.height - this.vfe.getSize().height)/2); 
				this.vt.setLocation(screen.width/2 ,(screen.height - this.vt.getSize().height)/2); 
				System.out.println("2 fenêtres centrées");
			}
		}
	}
	
	/**
	 * Ferme le programme, avec confirmation.
	 * @author Nathanaël Jourdane
	 */
	public void arreter ()
	{
		int option = JOptionPane.showConfirmDialog(this.vfe, "Voulez-vous Quitter ?");
		if (option == JOptionPane.OK_OPTION)
		{
			System.out.println("Fermeture du programme.");			
			System.exit(0);
		}
	}
	
	// *** Méthodes privées ***
	
}
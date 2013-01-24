package c;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

import v.Vue_Fenetre;
import v.Vue_Parcourir;
import v.Vue_Terrain;

/**
 * Contrôleur du projet.<br/>
 * Contient le traitement de l'ensemble du programme, notament l'action suivie par le clic de chaque bouton.
 */
public class Controleur
{
	private Vue_Fenetre vf;
	private Vue_Parcourir vp;
	private Vue_Terrain vt;
	
	private String nomFichier;
	private String cheminFichier;
	private int styleQ;
	
	/**
	 * Constructeur du contôleur qui initialise les vues et les arguments.
	 * @author Nathanaël Jourdane
	 */
	public Controleur ()
	{
		this.nomFichier = null;
		this.cheminFichier = null;
		this.vf = null;
		this.vp = null;
		this.vt = null;
	}

	/**
	 * Lance la vue principale (Vue_Fenetre). C'est l'unique méthode utilisée par le main.
	 * @author Nathanaël Jourdane
	 */
	public void demarrer ()
	{
		if (this.vf == null)
		{
			this.vf = new Vue_Fenetre(this);
			this.centrerFen();
			this.vf.setVisible (true);
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
			
	// *** Méthodes de Vue_Lecture ***
	
	/**
	 * Lecture d'une stratégie.
	 * @author Nathanaël Jourdane
	 */
	public void vl_lireStrategie()
	{
		System.out.println("Silence, ça tourne !");
	}
	
	/**
	 * Affiche la fenetre de terrain si l'utilisateur est sous l'onglet Lecture ou Edition.<br/>.
	 * Masque la fenetre dans le cas contraire.<br/>
	 * La taille de la fenetre est adapté au mode demi-terrain ou terrain complet.
	 * Ne fait rien si la fenetre est déjà ouverte.
	 * @param _onglet L'indice de l'onglet ouvert.
	 * @author Nathanaël Jourdane
	 */
	public void afficherTerrain(int _onglet)
	{	
		// Si on est en mode lecture ou écriture
		if(_onglet == 2 || _onglet == 3)
		{
			// Si le terrain n'est pas ouvert, on l'ouvre
			if(this.vt == null)
			{
				System.out.println("Affichage du terrain.");
				// affiche la fenetre du terrain en précisant s'il est en DT et TC
				this.vt = new Vue_Terrain(this, this.vf.getVJ().demiT());
				this.centrerFen();
				this.vt.setVisible (true);
			}
			
			if (_onglet == 3) // si on est en Edition, quadrillage fin
				this.styleQ = 2;

			// Dans tous les cas, on trace le quadrillage en fonction du mode lecture ou écriture.
			this.vt.dessiner(this.styleQ);
		}
		// Si on est ni en Lecture ni en Ecriture et que le terrain est ouvert
		else if (this.vt != null)
		{
			System.out.println("Fermeture du terrain.");
			this.vt.setVisible (false);	
			this.vt = null; // La vue Terrain n'existe plus.
			this.centrerFen();
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
			this.vf.affLecture(false);
		else
			this.vf.affLecture(true);
	}
	
	/**
	 * Positionne une ou plusieurs fenetres au centre de l'écran.
	 * @author Nathanaël Jourdane
	 */
	public void centrerFen()
	{
		// Les dimentions de l'écran
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		if (this.vf == null) // Si on la fenetre principale n'est pas ouverte
		{
			System.out.println("Aucune fenetre à centrer.");
		}
		else
		{
			if (this.vt == null) // Si la fenetre de terrain n'est pas ouverte
			{
				this.vf.setLocation((screen.width - this.vf.getSize().width)/2,(screen.height - this.vf.getSize().height)/2);
				System.out.println("1 fenêtre centrée");
			}
			else
			{
				this.vf.setLocation(screen.width/2 - this.vf.getSize().width - 5,(screen.height - this.vf.getSize().height)/2); 
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
		int option = JOptionPane.showConfirmDialog(this.vf, "Voulez-vous Quitter ?");
		if (option == JOptionPane.OK_OPTION)
		{
			System.out.println("Fermeture du programme.");			
			System.exit(0);
		}
	}
	
	// *** Méthodes privées ***
	
}
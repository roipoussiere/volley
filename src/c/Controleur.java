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
 * @author Nathanaël Jourdane
 */
public class Controleur
{
	// Vues
	private Vue_Fenetre vf;
	private Vue_Parcourir vp;
	private Vue_Terrain vt;
		
	private Parametres p;
	
	/**
	 * Constructeur du contrôleur qui initialise les vues et les autres arguments et lance la vue principale (Vue_Fenetre).
	 */
	public Controleur ()
	{
		// Itinitialisation des vues.
		this.vf = null;
		this.vp = null;
		this.vt = null;
		this.p = new Parametres();
		
		// Ouverture de la fenêtre principale.
		this.vf = new Vue_Fenetre(this);
		this.centrerFen();
		this.vf.setVisible (true);
	}
	
	// *** Getters & Setters ***
	
	public Parametres getP()
	{
		return this.p;
	}
	
	// *** Méthodes de Vue_Fenetre ***
		
	/**
	 * Action qui suit le clic sur un onglet.<br/>
	 * Adapte le quadrillage de la vue Terrain en fonction du mode Lecture ou Edition.<br/>
	 * @param _onglet L'indice de l'onglet ouvert.
	 */
	public void clicOnglet(int _onglet)
	{
		// Si le terrain n'est pas ouvert, on l'ouvre
		if(this.vt == null)
			this.afficherTerrain();
		
		if (_onglet == 0) // Si on est en Edition, quadrillage d'Edition
			this.vt.dessiner(this.p.getStyleQL());
		else  // Si on est en Lecture, quadrillage de Lecture
			this.vt.dessiner(this.p.getStyleQE());
	}
	
	/**
	 * Ouvre une fenêtre invitant l'utilisateur à sélectionner un fichier de stratégie.<br/>
	 * Stoque le chemin et le nom du fichier dans les arguments nomFichier et cheminFichier du contrôleur.
	 */
	public void mf_ouvrir()
	{
		System.out.println("Sélection d'un fichier...");
		this.vp = new Vue_Parcourir(this);
		int retour = this.vp.showOpenDialog(null);

		if(retour == JFileChooser.APPROVE_OPTION) // Si un fichier a été choisi
		{
			this.p.setCheminFichier(this.vp.getSelectedFile().getAbsolutePath()); // Chemin absolu du fichier choisi
			
			System.out.println("Il fichier sélectionné se trouve dans : " + this.p.getCheminFichier());			
		}
		else // Pas de fichier choisi
		{
			System.out.println("Aucun fichier sélectionné");
		}
	}
	
	/**
	 * Crée une nouvelle stratégie.
	 */
	public void mf_nouveau()
	{
		System.out.println("Nouvelle stratégie...");
	}

	/**
	 * Enregistrement de la stratégie.
	 */
	public void mf_enregistrer()
	{
		System.out.println("Enregistrer...");
	}
	
	/**
	 * Enregistrement de la stratégie dans un dossier spécifié.
	 */
	public void mf_enregistrerSous()
	{
		System.out.println("Enregistrer sous...");
	}
	
	/**
	 * Paramétrage des joueurs.
	 */
	public void ms_joueurs()
	{
		System.out.println("Joueurs...");
	}
	
	/**
	 * Paramétrage du terrain.
	 * @param demiT Mode d'affichage du terrain : True pour affichage en demi terrain, false pour affichage en terrain complet.
	 */
	public void ms_terrain(boolean _demiT)
	{
		System.out.println("Demi terrain : " + _demiT);
		this.p.setDemiT(_demiT);
		this.vt_fermer();
		this.afficherTerrain();
	}
	
	/**
	 * Paramétrage de la grille.
	 */
	public void mp_grille()
	{
		System.out.println("Grille...");
	}
	
	/**
	 * Paramétrage des couleurs.
	 */
	public void mp_couleurs()
	{
		System.out.println("Couleurs...");
	}
	
	/**
	 * Affiche de l'aide pour l'utilisation du programme.
	 */
	public void ma_aide()
	{
		System.out.println("Aide...");
	}
	
	/**
	 * Affiche les informations concernant le programme.
	 */
	public void ma_apropos()
	{
		System.out.println("À propos...");
	}
	
	// *** Méthodes de Vue_Fichier ***

	// *** Méthodes de Vue_Lecture ***
			
	// *** Méthodes de Vue_Edition ***
	
	// *** Méthodes de Vue_Terrain ***
	
	/**
	 * Ferme correctement la fenêtre de terrain.
	 */
	public void vt_fermer()
	{
		System.out.println("Fermeture de la fenetre du terrain.");
		this.vt.setVisible(false);
		this.vt = null;
		centrerFen();
	}
	
	// *** Autres méthodes ***
	
	/**
	 * Positionne une ou plusieurs fenêtres au centre de l'écran.
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
	 */
	public void quitter ()
	{
		int option = JOptionPane.showConfirmDialog(this.vf, "Voulez-vous Quitter ?");
		if (option == JOptionPane.OK_OPTION)
		{
			System.out.println("Fermeture du programme.");			
			System.exit(0);
		}
	}
	
	// *** Méthodes privées ***
		
	/**
	 * Affiche la fenêtre de terrain.<br/>
	 * La taille de la fenêtre est adaptée au mode demi-terrain ou terrain complet.
	 */
	private void afficherTerrain()
	{	
		System.out.println("Affichage du terrain.");
		// affiche la fenetre du terrain en précisant s'il est en DT et TC
		this.vt = new Vue_Terrain(this, this.p.isDemiT());
		this.centrerFen(); // Centrage des fenêtres à l'écran.
		this.vt.setVisible (true);
	}
}
package c;

import java.awt.*;
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
		
		// Ouverture des fenêtres.
		this.vf = new Vue_Fenetre(this);
		this.vt = new Vue_Terrain(this);
		this.centrerFen();
		this.vf.setVisible (true);
		this.vt.setVisible (true);
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
	public void clicOnglet()
	{
		// Fonctionne que si les 2 fenêtres sont ouvertes
		if(this.vf != null && this.vt != null)
		{
			switch(vf.getOngletOuvert())
			{
			case 0:
				this.vt.dessiner(this.p.getStyleQL());
				break;
			case 1:
				this.vt.dessiner(this.p.getStyleQE());
				break;
			}
		}
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
	 * Création de la vue Joueurs.
	 */
	public void ms_joueurs()
	{
		System.out.println("Joueurs...");
		this.vf.vueJoueurs();
	}
	
	/**
	 * Affectation du mode d'affichage du terrain.
	 * @param demiT Mode d'affichage du terrain : True pour affichage en demi terrain, false pour affichage en terrain complet.
	 */
	public void ms_terrain(boolean _demiT)
	{
		if (this.vt != null)
		{
			System.out.println("Demi terrain : " + _demiT);
			this.p.setDemiT(_demiT);
			this.vt.setTaille();
			this.centrerFen();
		}
	}
	
	/**
	 * Création de la vue Paramètres.
	 */
	public void mp_param()
	{
		System.out.println("Paramètres...");
		this.vf.vueParams();
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
		
	// *** Autres méthodes ***
	
	/**
	 * Positionne une ou plusieurs fenêtres au centre de l'écran.
	 */
	public void centrerFen()
	{
		// Les dimentions de l'écran
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		if (this.vf != null)
		{
			this.vt.setLocation(screen.width/2 ,(screen.height - this.vt.getSize().height)/2); 
			this.vf.setLocation(screen.width/2 - this.vf.getSize().width - 5,(screen.height - this.vf.getSize().height)/2);
			System.out.println("Fenêtres centrées.");
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
}
package c;

import java.awt.*;
import javax.swing.*;

import v_vues.Vue_APropos;
import v_vues.Vue_Aide;
import v_vues.Vue_Fenetre;
import v_vues.Vue_Terrain;

/**
 * Contrôleur du projet.<br/>
 * Contient le traitement de l'ensemble du programme, notament l'action suivie par le clic de chaque bouton.
 * @author Nathanaël Jourdane
 */
public class Controleur
{
	// Vues
	private Vue_Fenetre vf;
	private Vue_Terrain vt;
	
	private Parametres p;
	
	/**
	 * Constructeur du contrôleur qui initialise les vues et les autres arguments et lance la vue principale (Vue_Fenetre).
	 */
	public Controleur ()
	{
		// Itinitialisation des vues.
		this.vf = null;
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
	
	public void mf_ouvrir()
	{
		System.out.println("Ouverture d'un fichier de stratégie...");
		this.parcourir();
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
		System.out.println("Enregistrement de cette stratégie...");
	}
	
	/**
	 * Enregistrement de la stratégie dans un dossier spécifié.
	 */
	public void mf_enregistrerSous()
	{
		System.out.println("Enregistrement de cette stratégie sous...");
		this.parcourir();
	}
	
	/**
	 * Création de la vue Joueurs.
	 */
	public void ms_joueurs()
	{
		System.out.println("Affectation des joueurs...");
		this.vf.vueJoueurs();
	}
	
	/**
	 * Affectation du mode d'affichage du terrain.
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
		System.out.println("Paramètres du programme...");
		this.vf.vueParams();
	}
		
	/**
	 * Affiche de l'aide pour l'utilisation du programme.
	 */
	@SuppressWarnings("unused")
	public void ma_aide()
	{
		System.out.println("Comment utiliser ce programme...");
		Vue_Aide va = new Vue_Aide(this.vf);
	}
	
	/**
	 * Affiche les informations concernant le programme.
	 */
	@SuppressWarnings("unused")
	public void ma_apropos()
	{
		System.out.println("À propos de ce programme...");
		Vue_APropos vap = new Vue_APropos(this.vf);
	}
	
	// *** Méthodes de Vue_Fichier ***

	// *** Méthodes de Vue_Lecture ***
			
	// *** Méthodes de Vue_Edition ***
	
	// *** Méthodes de Vue_Terrain ***
		
	// *** Autres méthodes ***
	
	/**
	 * Ouvre une fenêtre invitant l'utilisateur à sélectionner un fichier de stratégie.<br/>
	 * Stoque le chemin et le nom du fichier dans les arguments nomFichier et cheminFichier du contrôleur.
	 */
	private void parcourir()
	{
		JFileChooser fc = new JFileChooser();
		int retour = fc.showOpenDialog(null);

		if(retour == JFileChooser.APPROVE_OPTION) // Si un fichier a été choisi
		{
			this.p.setCheminFichier(fc.getSelectedFile().getAbsolutePath()); // Chemin absolu du fichier choisi
			
			System.out.println("Il fichier sélectionné se trouve dans : " + this.p.getCheminFichier());			
		}
		else // Pas de fichier choisi
		{
			System.out.println("Aucun fichier sélectionné");
		}
	}
	
	/**
	 * Positionne une ou plusieurs fenêtres au centre de l'écran.
	 */
	private void centrerFen()
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
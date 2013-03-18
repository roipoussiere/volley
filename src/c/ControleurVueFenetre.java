package c;

import java.awt.*;
import javax.swing.*;
import m.Strategie;
import v_vues.*;

/**
 * Contrôleur du projet.<br/>
 * Contient le traitement de l'ensemble du programme, notament l'action suivie par le clic de chaque bouton.
 * @author Nathanaël Jourdane
 */
public class ControleurVueFenetre
{
	private ControleurPrincipal cp;
	private Vue_Fenetre vf;
	private Vue_Edition ve;
	private Vue_Lecture vl;

	/**
	 * Constructeur du contrôleur qui initialise les vues et les autres arguments et lance la vue principale (Vue_Fenetre).
   * 
   * @param _cp Le controleur principal
   */
	public ControleurVueFenetre (ControleurPrincipal _cp)
	{
		this.cp = _cp;
		
		// Création des controleurs des vues des onglets
		this.ve = cp.getCVE().getVueEdition();
		this.vl = cp.getCVL().getVueLecture();
		
		// Ouverture de la fenêtre.
		this.vf = new Vue_Fenetre(this);
		
		this.centrerFen();
		this.vf.setVisible (true);
		
	}

	// *** Getters ***

	public Vue_Fenetre getVueFenetre()
	{
		return this.vf;
	}
	
	public Vue_Lecture getVueLecture()
	{
		return this.vl;
	}
	
	public Vue_Edition getVueEdition()
	{
		return this.ve;
	}

  public boolean isDT() {
    return this.cp.getP().isDemiT();
  }
	// *** Méthodes de Vue_Fenetre ***

	/**
	 * Action qui suit le clic sur un onglet.<br/>
	 * Adapte le quadrillage de la vue Terrain en fonction du mode Lecture ou Edition.<br/>
	 */
	public void clicOnglet()
	{
		// Fonctionne que si les 2 fenêtres sont ouvertes
		if(this.vf != null && this.cp.getP() != null)
		{
			switch(vf.getOngletOuvert())
			{
			case 0: // Lecture
				//this.cp.getCVT().getVT().dessiner(this.cp.getP().getStyleQL());
				this.cp.getCVL().majVue();
				break;
			case 1: // Edition
				//this.cp.getCVT().getVT().dessiner(this.cp.getP().getStyleQE());
				//this.vf.getVE().majVue();
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
		this.cp.setCVJ(new ControleurVueJoueurs(cp));
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
			this.cp.getP().setCheminFichier(fc.getSelectedFile().getAbsolutePath()); // Chemin absolu du fichier choisi

			System.out.println("Il fichier sélectionné se trouve dans : " + this.cp.getP().getCheminFichier());			
		}
		else // Pas de fichier choisi
		{
			System.out.println("Aucun fichier sélectionné");
		}
	}

	/**
	 * Positionne une ou plusieurs fenêtres au centre de l'écran.
	 */
	public void centrerFen()
	{
		// Les dimentions de l'écran
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		if (this.vf != null)
		{
			//this.cp.getCVT().getVT().setLocation(screen.width/2 ,(screen.height - this.cp.getCVT().getVT().getSize().height)/2); 
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
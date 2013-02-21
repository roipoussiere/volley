package m;


/**
 * Classe représentant les joueurs.
 * @author Florian Garnier
 */

public class Joueur extends Element
{
	private String idJoueur ; // identifiant unique pour chaque joueur de la forme EXJY (EX = Equipe X, JY = Joueur Y)
	private int numeroJoueur ; // numéro du joueur donné dans la fenêtre Vue_Joueurs
	private String nomJoueur ; // nom du joueur saisi dans la fenêtre Vue_Joueurs
	private boolean estMeneur ; // TRUE si le joueur a été désigné meneur dans la fenêtre Vue_Joueurs, FALSE sinon
	// TODO : Attributs d'apparence graphique à ajouter
	
	// Constructeur
	
	public Joueur (String _id, int _num, String _nom, boolean _estMeneur, char _posX, char _posY)
	{
		this.idJoueur = _id ;
		this.numeroJoueur = _num ;
		this.nomJoueur = _nom ;
		this.estMeneur = _estMeneur ;
		this.posX = _posX ; // position en abscisse initiale du joueur
		this.posY = _posY ; // position en ordonnée initiale du joueur
	}
	
	// Getters
	
	/**
	 * Getter de l'identifiant du joueur.
	 * @return L'identifiant.
	 */
	public String getIdJoueur ()
	{
		return idJoueur ;
	}

	/**
	 * Getter du numéro du joueur.
	 * @return Le numéro.
	 */
	public int getNumeroJoueur ()
	{
		return numeroJoueur ;
	}

	/**
	 * Getter du nom du joueur.
	 * @return Le nom.
	 */
	public String getNomJoueur ()
	{
		return nomJoueur ;
	}

	/**
	 * Getter de l'état de meneur du joueur.
	 * @return TRUE si le joueur est meneur, FALSE sinon.
	 */
	public boolean isEstMeneur ()
	{
		return estMeneur ;
	}
	
	
	// Setters
	
	/**
	 * Setter de l'identifiant du joueur. 
	 * @param idJoueur Nouvel identifiant.
	 */
	public void setIdJoueur (String idJoueur)
	{
		this.idJoueur = idJoueur ;
	}

	/**
	 * Setter du numéro du joueur. 
	 * @param numeroJoueur Nouveau numéro.
	 */
	public void setNumeroJoueur (int numeroJoueur)
	{
		this.numeroJoueur = numeroJoueur ;
	}

	/**
	 * Setter du nom du joueur. 
	 * @param nomJoueur Nouveau nom.
	 */
	public void setNomJoueur (String nomJoueur)
	{
		this.nomJoueur = nomJoueur ;
	}

	/**
	 * Setter de l'état de meneur du Joueur.
	 * @param estMeneur TRUE si le joueur doit devenir le nouveau meneur, FALSE s'il ne doit plus être meneur.
	 */
	public void setEstMeneur (boolean estMeneur)
	{
		this.estMeneur = estMeneur ;
	}
}

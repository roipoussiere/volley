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
	
	// Getters & Setters
}

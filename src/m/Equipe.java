package m;

public class Equipe implements java.io.Serializable
{
	/**
	 * 
	 */
	private Joueur[] equipe ;
	
	// Constructeurs

	public Equipe ()
	{
		this.equipe = new Joueur[6] ;
	}
	
	public Equipe (Joueur[] _tabJ)
	{
		this.equipe = _tabJ ;
	}

	// Getters

	public Joueur[] getEquipe ()
	{
		return equipe ;
	}

	// Setters
	
	public void setEquipe (Joueur[] _equipe)
	{
		this.equipe = _equipe ;
	}
	
	// Accesseurs
	
	public Joueur getJoueur (int _i)
	{
		return this.equipe[_i] ;
	}
	
	public int getNbJoueur ()
	{
		return this.equipe.length ;
	}
	
	// Modificateurs
	
	public void setJoueur (int _i, Joueur _j)
	{
		this.equipe[_i] = _j ;
	}
}

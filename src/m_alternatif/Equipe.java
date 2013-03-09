package m_alternatif;

public class Equipe
{
	private Joueur[] equipe ;
	
	// Constructeurs

	public Equipe ()
	{
		this.equipe = new Joueur[6] ;
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
	
	// Modificateurs
	
	public void setJoueur (int _i, Joueur _j)
	{
		this.equipe[_i] = _j ;
	}
}

package m;

public class Equipe
{
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
	
	/**
	 * Retourne le nombre maximal de temps saisis pour un joueur de cette équipe.
	 * @return Le nombre maximal de temps saisis pour un joueur.
	 */
	public int getNbMaxTemps ()
	{
		int tpsMax = 0 ;
		for (int i = 0 ; i < this.equipe.length ; i++)
		{
			if (tpsMax < this.equipe[i].getNbDeplacements())
				tpsMax = this.equipe[i].getNbDeplacements() ;
		}
		
		return tpsMax ;
	}
	
	// Modificateurs
	
	public void setJoueur (int _i, Joueur _j)
	{
		this.equipe[_i] = _j ;
	}
}

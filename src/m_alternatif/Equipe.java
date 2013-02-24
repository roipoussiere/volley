package m_alternatif;

import java.util.Vector;

public class Equipe
{
	private int nbJoueur ;
	private Vector<Joueur> equipe ;
	
	// Constructeurs

	public Equipe (int _nbJ)
	{
		this.nbJoueur = _nbJ ;
		this.equipe = new Vector<Joueur> (this.nbJoueur) ;
	}

	// Getters
	
	public int getNbJoueur ()
	{
		return nbJoueur ;
	}

	public Vector<Joueur> getEquipe ()
	{
		return equipe ;
	}

	// Setters
	
	public void setNbJoueur (int nbJoueur)
	{
		this.nbJoueur = nbJoueur ;
	}

	public void setEquipe (Vector<Joueur> equipe)
	{
		this.equipe = equipe ;
	}
	
	// Modificateurs
	
	public void ajouterJoueur (Joueur _j)
	{
		this.equipe.add (_j) ;
	}
	
	public void ajouterJoueurA (int _i, Joueur _j)
	{
		this.equipe.add (_i, _j) ;
	}
	
	public void supprimerJoueurA (int _i)
	{
		this.equipe.remove(_i) ;
	}
	
	public void supprimerEquipe ()
	{
		this.equipe.removeAllElements() ;
	}
}

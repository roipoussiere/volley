package m_alternatif;

import java.awt.Color;
import java.util.Vector;

/**
 * Classe représentant les éléments affichés sur le terrain (joueurs + ballon).
 * Chaque indice du vector représente un temps de jeu dans la stratégie et contient 
 * donc la position de l'élément à ce temps là.
 * @author Florian Garnier
 */
public abstract class Element
{
	private boolean affiche ;
	private Color couleurE ;
	private Vector<Position> deplacement ;
	
	// Constructeurs
	
	public Element (boolean _affiche, Color _couleur)
	{
		super() ;
		this.affiche = _affiche ;
		this.couleurE = _couleur ;
		this.deplacement = new Vector<Position> () ;
	}
	
	// Getters
	
	public boolean isAffiche ()
	{
		return affiche ;
	}

	public Color getCouleurE ()
	{
		return couleurE ;
	}

	public Vector<Position> getVectorDeplacement ()
	{
		return deplacement ;
	}
	
	// Setters

	public void setAffiche (boolean affiche)
	{
		this.affiche = affiche ;
	}

	public void setCouleurE (Color couleurE)
	{
		this.couleurE = couleurE ;
	}

	public void setVectorDeplacement (Vector<Position> deplacement)
	{
		this.deplacement = deplacement ;
	}
	
	// Accesseurs
	
	public Position getDeplacementAuTemps (int _i)
	{
		return this.deplacement.elementAt(_i) ;
	}
	
	// Modificateurs
	
	public void ajouterNouveauDeplacement (Position _pos)
	{
		this.deplacement.add(_pos) ;
	}
	
	public void majDeplacementAuTemps (int _i, Position _pos)
	{
		this.deplacement.set(_i, _pos) ;
	}
}

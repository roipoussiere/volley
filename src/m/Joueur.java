package m;

import java.awt.Color;

public class Joueur extends Element
{
	private String idJ ;
	private String nomJ ;
	private boolean meneur ;
	
	// Constructeurs
	
	public Joueur (String _idJ, String _nomJ, boolean _meneur, boolean _affiche, Color _couleur)
	{
		super (_affiche, _couleur) ;
		this.idJ = _idJ ;
		this.nomJ = _nomJ ;
		this.meneur = _meneur ;
	}
	
	// Getters
	
	public String getIdJ ()
	{
		return idJ ;
	}

	public String getNomJ ()
	{
		return nomJ ;
	}

	public boolean isMeneur ()
	{
		return meneur ;
	}
	
	// Setters
	
	public void setIdJ (String idJ)
	{
		this.idJ = idJ ;
	}
	
	public void setNomJ (String nomJ)
	{
		this.nomJ = nomJ ;
	}
	
	public void setMeneur (boolean meneur)
	{
		this.meneur = meneur ;
	}
}

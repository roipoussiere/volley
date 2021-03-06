package m;

import java.awt.Color;

public class Joueur extends Element implements java.io.Serializable
{
	private String idJ ;
	private String nomJ ;
	private boolean meneur ;
	
	// Constructeurs
	
	/*public Joueur ()
	{
		super () ;
		this.idJ = "idJ" ;
		this.nomJ = "Joueur" ;
	}
	*/
	
	public Joueur (String _idJ, String _nomJ, m.Position _pos)
	{
		super (true, Color.BLUE, _pos) ;
		this.idJ = _idJ ;
		this.nomJ = _nomJ ;
	}
	
	public Joueur (String _idJ, String _nomJ, boolean _meneur, boolean _affiche, Color _couleur, m.Position _pos)
	{
		super (_affiche, _couleur, _pos) ;
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

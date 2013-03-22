package m;


/**
 * Position qu'occupe un élément à un temps donné.
 * @author Florian Garnier
 */


public class Position
{
	private int posX ; // abscisse
	private int posY ; // ordonnée
	private Orientation ort ;
	
	// Constructeurs
	
	public Position (int _pX, int _pY)
	{
		this.posX = _pX ;
		this.posY = _pY ;
		this.ort = Orientation.AUCUNE ;
	}
	
	public Position (int _pX, int _pY, Orientation _ort)
	{
		this (_pX, _pY) ;
		this.ort = _ort ;
	}
	
	public Position (String _coord)
	{
		this.posX = (int) (_coord.charAt(0) - 'A') ;
		this.posY = Integer.parseInt(Character.toString(_coord.charAt(1))) ;
		this.ort = Orientation.HAUT ;
	}
	
	public Position (String _coord, Orientation _ort)
	{
		this (_coord) ;
		this.ort = _ort ;
	}
	
	// Getters
	
	public int getPosX ()
	{
		return posX ;
	}
	
	public int getPosY ()
	{
		return posY ;
	}
	
	public Orientation getOrt ()
	{
		return this.ort;
	}
	
	public String getPosition ()
	{
		return (String.valueOf(this.posX) + String.valueOf(this.posY)) ;
	}
	
	// Setters
	
	public void setPosX (char posX)
	{
		this.posX = posX ;
	}
	
	public void setPosY (char posY)
	{
		this.posY = posY ;
	}
	
	public void setPosition (String _coord)
	{
		this.posX = _coord.charAt(0) ;
		this.posY = _coord.charAt(1) ;
	}
	
	
	// Conversion
	
	public String toFormatSaisie ()
	{
		return (Character.toString((char) (this.posX + 'A')) + Integer.toString(this.posY)) ;
	}
	
	
	// Affichage
	
	public String toString ()
	{
		return ("[" + (char)('A'+this.posX) + ";" + String.valueOf(this.posY) + "]-" + ort) ;
	}
}

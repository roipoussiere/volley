package m;

/**
 * Position qu'occupe un élément à un temps donné.
 * @author Florian Garnier
 */
public class Position
{
	private char posX ; // abscisse
	private char posY ; // ordonnée
	
	// Constructeurs
	
	public Position (char _pX, char _pY)
	{
		this.posX = _pX ;
		this.posY = _pY ;
	}
	
	public Position (String _coord)
	{
		this.posX = _coord.charAt(0) ;
		this.posY = _coord.charAt(1) ;
	}
	
	// Getters
	
	public char getPosX ()
	{
		return posX ;
	}
	
	public char getPosY ()
	{
		return posY ;
	}
	
	public String getPosition ()
	{
		return (Integer.toString(this.posX) + Integer.toString(this.posY)) ;
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
}

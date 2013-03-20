package m;

/**
 * Position qu'occupe un élément à un temps donné.
 * @author Florian Garnier
 */
public class Position
{
	private int posX ; // abscisse
	private int posY ; // ordonnée
	
	// Constructeurs
	
	public Position (int _pX, int _pY)
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
	
	public int getPosX ()
	{
		return posX ;
	}
	
	public int getPosY ()
	{
		return posY ;
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
	
	// Affichage
	
	public String toString ()
	{
		return ("[" + (char)('A'+this.posX) + ";" + String.valueOf(this.posY) + "]") ;
	}
}

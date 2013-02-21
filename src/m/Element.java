package m;

/**
 * Classe représentant l'ensemble des éléments présents sur le terrain (joueur + ballon)
 * @author Florian
 */

public class Element
{
	private char posX ;
	private char posY ;
	
	// Getters & Setters
	
	public char getPosX ()
	{
		return posX ;
	}
	public void setPosX (char posX)
	{
		this.posX = posX ;
	}
	public char getPosY ()
	{
		return posY ;
	}
	public void setPosY (char posY)
	{
		this.posY = posY ;
	}	
}

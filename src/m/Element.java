package m;

/**
 * Classe représentant l'ensemble des éléments présents sur le terrain (joueur + ballon)
 * @author Florian Garnier
 */

public class Element
{
	protected char posX ;
	protected char posY ;
	
	// Getters
	
	/**
	 * Getter de l'abscisse de l'élément.
	 * @return L'abscisse.
	 */
	public char getPosX ()
	{
		return posX ;
	}
	
	/**
	 * Getter de l'ordonnée de l'élément.
	 * @return L'ordonnée.
	 */
	public char getPosY ()
	{
		return posY ;
	}
	
	
	// Setters
	
	/**
	 * Setter de l'abscisse de l'élément.
	 * @param posX Nouvelle abscisse.
	 */
	public void setPosX (char posX)
	{
		this.posX = posX ;
	}
	
	/**
	 * Setter de l'ordonnée de l'élément.
	 * @param posX Nouvelle ordonnée.
	 */
	public void setPosY (char posY)
	{
		this.posY = posY ;
	}	
}

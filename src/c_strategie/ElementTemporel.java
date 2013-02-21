package c_strategie;

/**
 *
 * @author Nathanaël Jourdane
 */
public class ElementTemporel
{
	private int posX;
	private int posY;
	private int idEl;

	ElementTemporel(int _idEl, int _posX, int _posY)
	{
		this.idEl = _idEl;
		this.posX = _posX;
		this.posY = _posY;
	}
	
	public int getId()
	{
		return this.idEl;
	}
	
	public int getX()
	{
		return this.posX;
	}
		
	public int getY()
	{
		return this.posY;
	}
	
	public void setXY(int _posX, int _posY)
	{
		this.posX = _posX;
		this.posY = _posY;
	}
}

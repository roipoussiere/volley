package c_strategie;
import c.Controleur;
import java.util.Vector;
/**
 *
 * @author Nathanaël Jourdane
 */
public class Strategie
{
	private Vector<Temps> strategie;
	private Controleur c;
	private Ensemble e;
	
	public Strategie(Controleur _c)
	{
		this.c = _c;
		this.e = this.c.getE();
		this.strategie = new Vector<Temps>();		
	}
	
	public Controleur getC()
	{
		return this.c;
	}
	
	public void addTemps(Temps t)
	{
		this.strategie.add(t);
	}
	
	public void suppTemps(int _idT)
	{
		this.strategie.remove(_idT);
	}
	
	public Temps DernierTemps()
	{
		return this.strategie.lastElement();
	}
}


package m;
import c.Controleur;
import java.util.Vector;
/**
 *
 * @author Nathanaël Jourdane
 */
public class Strategie
{
	private Vector<Temps> cycle;
	private Controleur c;
	private Ensemble e;
	private int ta; // temps actuel
	
	public Strategie(Controleur _c)
	{
		this.c = _c;
		this.e = this.c.getE();
		this.cycle = new Vector<Temps>(); // On créeur un vecteur de temps.
		this.cycle.add(new Temps(this)); // On ajoute le temps 0 à ce vecteur.
		this.ta = 0; // À la création de la stratégie, le temps actuel est 0.
	}
	
	public Controleur getC()
	{
		return this.c;
	}
	
	public int getTA()
	{
		return this.ta;
	}
  	
	public void setTA(int _ta)
	{
		this.ta = _ta;
	}
  
	public Temps getTemps(int _idT)
	{
		return this.cycle.get(_idT);
	}
	
	public void addTemps(Temps t)
	{
		this.cycle.add(t);
	}
	
	public void suppTemps(int _idT)
	{
		this.cycle.remove(_idT);
	}
	
	public Temps DernierTemps()
	{
		return this.cycle.lastElement();
	}
}


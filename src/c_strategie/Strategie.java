package c_strategie;
import c.Controleur;
import java.util.ArrayList;
/**
 *
 * @author Nathanaël Jourdane
 */
public class Strategie
{
	private ArrayList<Temps> strategie;
	private Controleur c;
	private Ensemble e;
	
	public Strategie(Controleur _c)
	{
		this.c = _c;
		this.e = new Ensemble(this);
		this.strategie = new ArrayList<Temps>();
		
		this.e.afficher(); //Affichage des élements (pour test)
	}
	
	public Controleur getC()
	{
		return this.c;
	}
	
	public Ensemble getE()
	{
		return this.e;
	}
	
	public void addTemps(Temps t)
	{
		this.strategie.add(t);
	}
	
	public void suppTemps(int _idT)
	{
		this.strategie.remove(_idT);
	}
}


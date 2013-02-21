package c_strategie;
import java.util.ArrayList;
/**
 *
 * @author Nathanaël Jourdane
 */
public class Strategie
{
	private ArrayList<Temps> strategie;

	public Strategie()
	{
		this.strategie = new ArrayList<Temps>();
	}
	
	public void addTemps(Temps t)
	{
		this.strategie.add(t);
	}
}


package c_strategie;

/**
 *
 * @author Nathanaël Jourdane
 */
public class Temps
{
	private Strategie s;

	public Temps(Strategie _s)
	{
		this.s = _s;
		
		Ensemble e = this.s.getE();
		for (int i=0 ; i<e.getNbJ() ; i++)
		{
			Element el = e.getEl(i);
			if (el.getEtat()) {
				
			}
		}
	}
	
	
}

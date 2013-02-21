package c_strategie;

import java.util.Vector;
import javax.swing.text.Position;

/**
 *
 * @author Nathanaël Jourdane
 */
public class Temps
{
	private Strategie s;
	private Vector<ElementTemporel> etVector; // Vecteur contenant la position de tous les élements actifs.

	public Temps(Strategie _s)
	{
		this.s = _s;
		this.etVector = new Vector<ElementTemporel>();
		
		Ensemble e = this.s.getC().getE();
		
		for (int i=0 ; i<e.getNbJ() ; i++)
		{
			if (e.getEl(i).getEtat()) { // Pour chaque élement activé, on crée un nouvel élement temporel.
				ElementTemporel pos = new ElementTemporel(i, 0, i);
				this.etVector.add(pos);
			}
		}
		
		
	}
	
	/**
	 * Renvoie un élement temporel à partir de l'id de l'élement.
	 */
	public ElementTemporel getEtParId(int _idEl)
	{
		ElementTemporel el = null;
		
		// À optimiser
		for (int i=0 ; i<this.etVector.size() ; i++)
		{
			if(this.etVector.get(i).getId() == _idEl)
				el = this.etVector.get(i);
		}
		return el;
	}
	
	public void bougerEl(int _idEl, int _posX, int _posY)
	{
		ElementTemporel et = getEtParId(_idEl);
		et.setXY(_posX, _posY);
	}
	
	
}

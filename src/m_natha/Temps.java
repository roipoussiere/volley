package m_natha;

import java.util.Vector;
import javax.swing.text.Position;

/**
 *
 * @author Nathanaël Jourdane
 */
public class Temps
{/*
	private Strategie s;
	private Vector<Mouvement> vecteurET; // Vecteur contenant la position de tous les élements actifs.

	public Temps(Strategie _s)
	{
		this.s = _s;
		this.vecteurET = new Vector<Mouvement>();
		
		Ensemble e = this.s.getC().getE();
		
		for (int i=0 ; i<e.getNbJ() ; i++)
		{
			if (e.getEl(i).getEtat()) { // Pour chaque élement activé, on crée un nouvel élement temporel.
				this.vecteurET.add(new Mouvement(i, 0, i));
			}
		}
		
		
	}
	
	public int getNbET()
	{
		return this.vecteurET.size();
	}
	
	public Mouvement getET(int _idEt)
	{
		return this.vecteurET.get(_idEt);
	}
		
	public Mouvement getETParId(int _idEl)
	{
		Mouvement el = null;
		
		// À optimiser
		for (int i=0 ; i<this.getNbET() ; i++)
		{
			if(this.vecteurET.get(i).getId() == _idEl)
				el = this.vecteurET.get(i);
		}
		return el;
	}
	
	public void bougerEl(int _idEl, int _posX, int _posY)
	{
		Mouvement et = getETParId(_idEl);
		et.setXY(_posX, _posY);
	}
	*/
}

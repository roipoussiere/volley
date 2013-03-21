package c;

import java.awt.Color;

import m.Orientation;
import v_vues.Vue_Dessin;

public class ControleurVueDessin {
	private ControleurPrincipal cp;
	private Vue_Dessin vd;
	
	private int styleQ;
	private int tc; // Taille d'une case
	
	ControleurVueDessin(ControleurPrincipal _cp) {
		this.cp = _cp;
		this.vd = new Vue_Dessin(this);
	}
	
	public Vue_Dessin getVD()
	{
		return this.vd;
	}
	
	public void majDessin()
	{
		// Affichage du quadrillage
		if (this.cp.getP().isDemiT()) // demi terrain
		{
			this.tc = 50;
			this.vd.dessinerDT(this.styleQ, this.tc, this.cp.getP().getCFond(), this.cp.getP().getCBordures(), this.cp.getP().getCLignes());
		}
		else // terrain complet
		{
			this.tc = 35;
			this.vd.dessinerTC(this.styleQ, this.tc, this.cp.getP().getCFond(), this.cp.getP().getCBordures(), this.cp.getP().getCLignes());
		}
		
		// affichage des élements
		
		for (int i=0 ; i<6 ; i++)
		{
			m.Position posE1 = this.cp.getS().getJoueurEq1(i).getDeplacementAuTemps(this.cp.getS().getTA());
			jeton(posE1, this.cp.getS().getJoueurEq1(i).getIdJ());
			System.out.println("elt de E1 à la position " + posE1);

			m.Position posE2 = this.cp.getS().getJoueurEq2(i).getDeplacementAuTemps(this.cp.getS().getTA());
			jeton(posE2, this.cp.getS().getJoueurEq2(i).getIdJ());
			System.out.println("elt de E2 à la position " + posE2);
		}
		
		// Affichage du ballon
		jeton(this.cp.getS().getBallon(), "");
	}
	
	/**
	 * Setter du style de quadrillage (aucun, fin ou large).
	 * @param _styleQ Le style de quadrillage (aucun, fin ou large).
	 */
	public void setStyleQ(int _styleQ)
	{
		this.styleQ = _styleQ;
	}
	
	public void jeton(m.Position _pos, String _nomAff)
	{
		Color c = this.cp.getP().getCoulE(0);
		if (_pos.getOrt() == Orientation.NULL)
		{
			c = this.cp.getP().getCBallon();
		}
			
		float t = (float)0.75*this.tc;
		float posX = this.tc*(_pos.getPosX()+1) + this.tc/2 - t/2;
		float posY = this.tc*(_pos.getPosY()+1) + this.tc/2 - t/2;
		this.vd.affJeton(posX, posY, _pos.getOrt().ordinal()*90+45, _nomAff, t, c);
	}
	
	public float getTC()
	{
		return this.tc;
	}

}

package c;

import java.awt.Color;

import m.Strategie;
import v_vues.Vue_Dessin;
import v_vues.Vue_Terrain;

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
			this.vd.dessinerDT(this.styleQ, this.tc, this.cp.getP().getCFond(), this.cp.getP().getCLignes(), this.cp.getP().getCQLarge(), this.cp.getP().getCQFin());
		}
		else // terrain complet
		{
			this.tc = 35;
			this.vd.dessinerTC(this.styleQ, this.tc, this.cp.getP().getCFond(), this.cp.getP().getCLignes(), this.cp.getP().getCQLarge(), this.cp.getP().getCQFin());
		}
		
		// affichage des élements
		
		for (int i=0 ; i<6 ; i++)
		{
			m.Position posE1 = this.cp.getS().getJoueurEq1(i).getDeplacementAuTemps(this.cp.getS().getTA());
			m.Position posE2 = this.cp.getS().getJoueurEq2(i).getDeplacementAuTemps(this.cp.getS().getTA());

			int posX = posE1.getPosX();
			int posY = posE1.getPosY();

			System.out.println("elt de E1 à la position [" + posX + ";" + posY + "]");
			jeton(posX, posY);

			posX = posE2.getPosX();
			posY = posE2.getPosY();

			System.out.println("elt de E2 à la position [" + posX + ";" + posY + "]");
			jeton(posX, posY);
		}

	}
	
	/**
	 * Setter du style de quadrillage (aucun, fin ou large).
	 * @param _styleQ Le style de quadrillage (aucun, fin ou large).
	 */
	public void setStyleQ(int _styleQ)
	{
		this.styleQ = _styleQ;
	}
	
	public void jeton(int _posX, int _posY)
	{
		Color c = this.cp.getP().getCoulE(0);
		int t = (int)(0.75*this.tc);
		int posX = this.tc*(_posX+1) + this.tc/2 - t/2;
		int posY = this.tc*(_posY+1) + this.tc/2 - t/2;
		this.vd.affJeton(posX, posY, t, c);
	}
	
	public int getTC()
	{
		return this.tc;
	}

}

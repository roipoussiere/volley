package c;

import java.awt.Color;

import m.Joueur;
import m.Position;
import m.TypeElt;
import v_vues.Vue_Dessin;

public class ControleurVueDessin {
	private ControleurPrincipal cp;
	private Vue_Dessin vd;
	
	private int styleQ;
	private int tc; // Taille d'une case
	
	ControleurVueDessin(ControleurPrincipal _cp) {
		this.cp = _cp;
		this.vd = new Vue_Dessin(this);
		// this.vd.repaint();
		// this.majDessin();
	}
	
	public Vue_Dessin getVD()
	{
		return this.vd;
	}
	
	public void majDessin()
	{
		initDessin();
		this.vd.repaint();
	}
	
	public void initDessin()
	{
		System.out.println("Maj du dessin : t=" + this.cp.getS().getTA());
		Joueur j;
		if (this.cp.getP().isDemiT()) // demi terrain
		{
			// Affichage du quadrillage
			this.tc = 50;
			this.vd.dessinerDT(this.styleQ, this.tc, this.cp.getP().getCFond(), this.cp.getP().getCBordures(), this.cp.getP().getCLignes());
			
			// affichage des joueurs équipe 1
			for (int i=0 ; i<6 ; i++)
			{
				j = this.cp.getS().getJoueurEq1(i);
				TypeElt type = TypeElt.JOUEUR1;
				if (j.isMeneur())
					type = TypeElt.MENEUR1;
				
				m.Position pos = j.getDeplacementAuTemps(this.cp.getS().getTA());
				System.out.println("<test_natha> position de " + j.getNomJ() + " : " + pos);
				
				jeton(pos, j.getNomJ(), j.getIdJ(), type);
			}
		}
		else // terrain complet
		{
			// Affichage du quadrillage
			this.tc = 35;
			this.vd.dessinerTC(this.styleQ, this.tc, this.cp.getP().getCFond(), this.cp.getP().getCBordures(), this.cp.getP().getCLignes());
		
			
			for (int i=0 ; i<6 ; i++)
			{
				// affichage des joueurs équipe 1
				j = this.cp.getS().getJoueurEq1(i);
				TypeElt type = TypeElt.JOUEUR1;
				if (j.isMeneur())
					type = TypeElt.MENEUR1;
				
				m.Position pos = j.getDeplacementAuTemps(this.cp.getS().getTA());
				System.out.println("<test_natha> position de " + j.getNomJ() + " : " + pos);
				
				jeton(pos, j.getNomJ(), j.getIdJ(), type);
				
				// affichage des joueurs équipe 2
				type = TypeElt.JOUEUR2;
				j = this.cp.getS().getJoueurEq2(i);
				pos = j.getDeplacementAuTemps(this.cp.getS().getTA());
				System.out.println("<test_natha> position de " + j.getNomJ() + " : " + pos);

				if (j.isMeneur())
					type = TypeElt.MENEUR2;
				
				jeton(pos, j.getNomJ(), j.getIdJ(), type);
			}
		}
		
		// Affichage du ballon
		jeton(this.cp.getS().getBallon().getDeplacementAuTemps(this.cp.getS().getTA()), "", "", TypeElt.BALLON);
	}
	
	/**
	 * Setter du style de quadrillage (aucun, fin ou large).
	 * @param _styleQ Le style de quadrillage (aucun, fin ou large).
	 */
	public void setStyleQ(int _styleQ)
	{
		this.styleQ = _styleQ;
	}
	
	// On pourrait améliorer en plaçant en paramètre un type Joueur
	public void jeton(m.Position _pos, String _nom, String _id, TypeElt _type)
	{
		Color c = Color.white;
		float t = (float)0.75*this.tc;
		int orientation = _pos.getOrt().ordinal()*90+45;
		
		switch(_type)
		{
			case JOUEUR1 :
				c = this.cp.getP().getCJoueurE1();
			break;
			case MENEUR1 :
				c = this.cp.getP().getCJoueurE1().brighter().brighter();
			break;
			case JOUEUR2 :
				c = this.cp.getP().getCJoueurE2();
			break;
			case MENEUR2 :
				c = this.cp.getP().getCJoueurE2().brighter().brighter();
			break;
			case BALLON :
				c = this.cp.getP().getCBallon();
				t = (float)0.5*this.tc;
				orientation = -1;
			break;
			default: break;
		}
		System.out.println("<test_natha> position jeton " + _nom + " : " + _pos);
		float posX = this.tc*_pos.getPosX() + this.tc/2 - t/2;
		float posY = this.vd.getHeight() - (this.tc*_pos.getPosY() + this.tc/2 + t/2 + 15);
		this.vd.affJeton(posX, posY, orientation, _nom, _id, t, c);
	}
	
	public float getTC()
	{
		return this.tc;
	}

}

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
	}
	
	public Vue_Dessin getVD()
	{
		return this.vd;
	}
	
	public void majDessin()
	{
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
				System.out.println("E1 : " + pos.getPosY());
				
				jeton(pos, j.getNomJ(), j.getIdJ(), type);
				
				// affichage des joueurs équipe 2
				System.out.println("équipe 2");
				type = TypeElt.JOUEUR2;
				j = this.cp.getS().getJoueurEq2(i);
				pos = j.getDeplacementAuTemps(this.cp.getS().getTA());
				System.out.println("E1 : " + pos.getPosY());

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
			break;
			default: break;
		}

		float posX = this.tc*(_pos.getPosX() + 1) + this.tc/2 - t/2;
		float posY = this.vd.getHeight() - (this.tc*(_pos.getPosY() + 1) + this.tc/2 - t/2);
		System.out.println("pos : " + _pos.getPosY() + " ; hauteur : " + this.vd.getHeight() + " ; posY avant : " + (this.tc*(_pos.getPosY() + 1) + this.tc/2 - t/2) + " ; posY après : " + posY);
		this.vd.affJeton(posX, posY, _pos.getOrt().ordinal()*90+45, _nom, _id, t, c);
	}
	
	public float getTC()
	{
		return this.tc;
	}

}

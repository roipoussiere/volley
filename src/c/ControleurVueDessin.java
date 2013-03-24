package c;

import java.awt.Color;

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
		if (this.cp.getP().isDemiT()) // demi terrain
		{
			// Affichage du quadrillage
			this.tc = 50;
			this.vd.dessinerDT(this.styleQ, this.tc, this.cp.getP().getCFond(), this.cp.getP().getCBordures(), this.cp.getP().getCLignes());
		
			// affichage des joueurs équipe 1
			for (int i=0 ; i<6 ; i++)
			{
				TypeElt type = TypeElt.JOUEUR;
				if (this.cp.getS().getJoueurEq2(i).isMeneur())
					type = TypeElt.MENEUR;
				
				m.Position pos = this.cp.getS().getJoueurEq2(i).getDeplacementAuTemps(this.cp.getS().getTA());
				
				jeton(pos, this.cp.getS().getJoueurEq2(i).getIdJ(), type);
				System.out.println("elem à la pos " + pos);
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
				TypeElt type = TypeElt.JOUEUR;
				if (this.cp.getS().getJoueurEq1(i).isMeneur())
					type = TypeElt.MENEUR;
				
				m.Position pos = this.cp.getS().getJoueurEq1(i).getDeplacementAuTemps(this.cp.getS().getTA());
				jeton(pos, this.cp.getS().getJoueurEq1(i).getIdJ(), type);
				System.out.println("elem à la pos " + pos);
				
				// affichage des joueurs équipe 2
				type = TypeElt.JOUEUR;
				if (this.cp.getS().getJoueurEq2(i).isMeneur())
					type = TypeElt.MENEUR;
				
				pos = this.cp.getS().getJoueurEq2(i).getDeplacementAuTemps(this.cp.getS().getTA());
				jeton(pos, this.cp.getS().getJoueurEq2(i).getIdJ(), type);
			}
		}
		
		// Affichage du ballon
		jeton(this.cp.getS().getBallon(), "", TypeElt.BALLON);
	}
	
	/**
	 * Setter du style de quadrillage (aucun, fin ou large).
	 * @param _styleQ Le style de quadrillage (aucun, fin ou large).
	 */
	public void setStyleQ(int _styleQ)
	{
		this.styleQ = _styleQ;
	}
	
	public void jeton(m.Position _pos, String _nomAff, TypeElt _type)
	{
		Color c = this.cp.getP().getCJoueur();
		if (_type == TypeElt.MENEUR)
		{
			c = c.brighter().brighter();
		}
		else if (_type == TypeElt.BALLON)
		{
			c = this.cp.getP().getCBallon();
		}
			
		float t = (float)0.75*this.tc;
		if (_type == TypeElt.BALLON)
			t = (float)0.5*this.tc;
		
		float posX = this.tc*(_pos.getPosX()+1) + this.tc/2 - t/2;
		float posY = this.tc*(_pos.getPosY()+1) + this.tc/2 - t/2;
		// Pour afficher l'équipe 1 sur le terrain, il faut la décaler vers le haut.
		if (this.cp.getP().isDemiT())
			posY -= 9*this.tc;
		this.vd.affJeton(posX, posY, _pos.getOrt().ordinal()*90+45, _nomAff, t, c);
	}
	
	public float getTC()
	{
		return this.tc;
	}

}

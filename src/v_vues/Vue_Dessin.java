package v_vues;

import c.Parametres;
import java.awt.*;
import javax.swing.*;
import m_natha.Temps;

/**
 * Vue de dessin, pour dessiner sur la fenetre de terrain.
 * @author Nathanaël Jourdane
 */
@SuppressWarnings("serial")
public class Vue_Dessin extends JPanel
{
	private Parametres p; // Pour éviter d'écrire this.vt.getC().getP();
	private Vue_Terrain vt;

	private int styleQ;
	private Temps ta; // Pour éviter d'écrire this.vt.getC().getS().getTA();
	private int tc; // Taille d'une case
	
	/**
	 * Constructeur de la vue de dessin.
	 * @param _vt La fenêtre du terrain.
	 */
	public Vue_Dessin(Vue_Terrain _vt)
	{
		this.vt = _vt;
		this.p = this.vt.getC().getP();
		
		//int vta = this.vt.getC().getS().getTA(); // récupère la valeur du temps actuel
		//this.ta = this.vt.getC().getS().getTemps(vta); // affecte le temps actuel à this.ta
	}
	
	/**
	 * Méthode qui sera appelée à chaque action sur la fenêtre, qui permet de redessiner l'intégralité de son contenu.
	 * @param _g : Le composant graphique.
	 */
	@Override
	public void paintComponent(Graphics _g)
	{
		// Affichage du quadrillage
		if (this.p.isDemiT()) // demi terrain
		{
			this.tc = 50;
			dessinerDT(_g);
		}
		else // terrain complet
		{
			this.tc = 35;
			dessinerTC(_g);
		}

    // affichage des élements
    /*
		for (int i=0 ; i<this.ta.getNbET() ; i++)
		{
			int posX = this.ta.getET(i).getX();
			int posY = this.ta.getET(i).getY();

			System.out.println("elt à la position [" + posX + ";" + posY + "]");
			element(_g, posX, posY);
		}*/
	}
	
	/**
	 * Setter du style de quadrillage (aucun, fin ou large).
	 * @param _styleQ Le style de quadrillage (aucun, fin ou large).
	 */
	public void setStyleQ(int _styleQ)
	{
		this.styleQ = _styleQ;
	}
	
	public void element(Graphics _g, int _posX, int _posY)
	{
		_g.setColor(this.p.getCoulE(0));
		int t = (int)(0.75*this.tc);
		_g.fillOval(this.tc*(_posX+1) + this.tc/2 - t/2, this.tc*(_posY+1) + this.tc/2 - t/2, t, t);
	}
	
	/**
	 * Dessine un demi terrain.
	 * @param _g Le composant graphique.
	 * @param _styleQ Style de quadrillage : 0 pour aucun, 1 pour 3 carreaux, 2 pour 9 carreaux.
	 */
	private void dessinerDT(Graphics _g)
	{
		_g.setColor(p.getCFondBas());
		_g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		if (this.styleQ == 1)
		{
			dessinerQLarge(_g, tc, tc);
		}
		else if(this.styleQ == 2)
		{
			dessinerQFin(_g, 0, tc);
			dessinerQLarge(_g, tc, tc);
		}
		
		_g.setColor(this.p.getCLignes());
		_g.drawLine(tc, tc*10, tc*10, tc*10); // ligne bas
		_g.drawLine(tc, tc, tc, tc*10); // ligne gauche
		_g.drawLine(tc*10, tc, tc*10, tc*10); // ligne droite
		_g.drawLine(tc, tc*4, tc*10, tc*4); // ligne d'attaque
		_g.drawLine(tc, tc, tc*10, tc); // ligne de service
	}
	
	/**
	 * Dessine un terrain complet.
	 * @param _g Le composant graphique.
	 * @param _styleQ Style de quadrillage : 0 pour aucun, 1 pour 3 carreaux, 2 pour 9 carreaux.
	 */
	private void dessinerTC(Graphics _g)
	{
		_g.setColor(p.getCFondHaut());
		_g.fillRect(0, 0, this.getWidth(), this.getHeight()/2);
		_g.setColor(p.getCFondBas());
		_g.fillRect(0, this.getHeight()/2, this.getWidth(), this.getHeight());
		
		if (this.styleQ == 1)
		{
			_g.setColor(this.p.getCQLarge());
			dessinerQLarge(_g, 0, tc);
			dessinerQLarge(_g, 10*tc, tc);
		}
		else if(this.styleQ == 2)
		{
			_g.setColor(this.p.getCQFin());
			dessinerQFin(_g, 0, tc);
			dessinerQFin(_g, 10*tc, tc);
			dessinerQLarge(_g, tc, tc);
			dessinerQLarge(_g, 10*tc, tc);

		}
		
		_g.setColor(this.p.getCLignes());
		
		// lignes verticales
		_g.drawLine(tc, tc, tc*10, tc); // limite haut
		_g.drawLine(tc, tc*7, tc*10, tc*7); // attaque haut
		_g.drawLine(tc, tc*10, tc*10, tc*10); // ligne de service
		_g.drawLine(tc, tc*13, tc*10, tc*13); // attaque bas
		_g.drawLine(tc, tc*19, tc*10, tc*19); // ligne bas
		
		//lignes verticales
		_g.drawLine(tc, tc, tc, tc*19); // ligne gauche
		_g.drawLine(tc*10, tc, tc*10, tc*19); // ligne droite
	}
	
	/**
	 * Dessine un quadrillage de 11*11 carreaux.
	 * @param _g Le composant graphique.
	 * @param _posY La position verticale du quadrillage.
	 * @param _tc La taille d'un carreau, qui déterminera celle du quadrillage.
	 */
	private void dessinerQFin(Graphics _g, int _posY, int _tc)
	{
		int nbX = 11;
		int nbY = 11;
		
		_g.setColor(this.p.getCQFin());
		for (int i=0 ; i<nbX+1 ; i++) {
			_g.drawLine(i*_tc, _posY, i*_tc, nbY*_tc + _posY);
		}
		for (int i=0 ; i<nbY+1 ; i++) {
			_g.drawLine(0, _posY + i*_tc, nbX*_tc, _posY + i*_tc);
		}
	}
	
	/**
	 * Dessine un quadrillage de 3*3 carreaux.
	 * @param _g Composant graphique.
	 * @param _posY La position verticale du quadrillage.
	 * @param _tc La taille d'un carreau, qui déterminera celle du quadrillage.
	 */
	private void dessinerQLarge(Graphics _g, int _posY, int _tc)
	{
		_g.setColor(this.p.getCQLarge());

		// lignes horizontales
		_g.drawLine(_tc, _posY + _tc*6, _tc*10, _posY + _tc*6);
		_g.drawLine(_tc, _posY + _tc*3, _tc*10, _posY + _tc*3);
		
		// lignes verticales
		_g.drawLine(_tc*4, _posY, _tc*4, _posY + _tc*9);
		_g.drawLine(_tc*7, _posY, _tc*7, _posY + _tc*9);
	}
}
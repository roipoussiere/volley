package v;

import java.awt.*;

import javax.swing.*;

import c.Parametres;

/**
 * Vue de dessin, pour dessiner sur la fenetre de terrain.
 * @author Nathanaël Jourdane
 */
@SuppressWarnings("serial")
public class Vue_Dessin extends JPanel
{
	private Vue_Terrain vt;
	private int styleQ;
	private Parametres p;
	
	/**
	 * Constructeur de la vue de dessin.
	 * @param _vt La fenêtre du terrain.
	 */
	public Vue_Dessin(Vue_Terrain _vt)
	{
		this.vt = _vt;
		this.p = this.vt.getC().getP();
	}
	
	/**
	 * Méthode qui sera appelée à chaque action sur la fenêtre, qui permet de redessiner l'intégralité de son contenu.
	 * @param _g : Le composant graphique.
	 */
	public void paintComponent(Graphics _g)
	{
		_g.setColor(p.getCFond());
		_g.fillRect(0, 0, this.getWidth(), this.getHeight());
		if (this.vt.getDemi()) // demi terrain
			dessinerDT(_g);
		else // terrain complet
			dessinerTC(_g);
	}
	
	/**
	 * Setter du style de quadrillage (aucun, fin ou large).
	 * @param _styleQ Le style de quadrillage (aucun, fin ou large).
	 */
	public void setStyleQ(int _styleQ)
	{
		this.styleQ = _styleQ;
	}
	
	/**
	 * Dessine un demi terrain.
	 * @param _g Le composant graphique.
	 * @param _styleQ Style de quadrillage : 0 pour aucun, 1 pour 3 carreaux, 2 pour 9 carreaux.
	 */
	private void dessinerDT(Graphics _g)
	{
		int tc = 50;
		
		if (this.styleQ == 1)
			dessinerQLarge(_g, tc, tc);
		else if(this.styleQ == 2)
			dessinerQFin(_g, 0, tc);
		
		_g.setColor(this.p.getCLignes());
		_g.drawLine(tc, tc*9, tc*10, tc*9); // ligne bas
		_g.drawLine(tc, 0, tc, tc*9); // ligne gauche
		_g.drawLine(tc*10, 0, tc*10, tc*9); // ligne droite
		_g.drawLine(tc, tc*3, tc*10, tc*3); // ligne d'attaque
	}
	
	/**
	 * Dessine un terrain complet.
	 * @param _g Le composant graphique.
	 * @param _styleQ Style de quadrillage : 0 pour aucun, 1 pour 3 carreaux, 2 pour 9 carreaux.
	 */
	private void dessinerTC(Graphics _g)
	{
		int tc = 36;
		
		if (this.styleQ == 1)
		{
			_g.setColor(this.p.getCQLarge());
			dessinerQLarge(_g, 10, tc);
			dessinerQLarge(_g, 2*tc, tc);
		}
		else if(this.styleQ == 2)
		{
			_g.setColor(this.p.getCQFin());
			dessinerQFin(_g, tc, tc);
			dessinerQFin(_g, 10*tc, tc);
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
	 * Dessine un quadrillage de 9*9 carreaux.
	 * @param _g Le composant graphique.
	 * @param _posY La position verticale du quadrillage.
	 * @param _tc La taille d'un carreau, qui déterminera celle du quadrillage.
	 */
	private void dessinerQFin(Graphics _g, int _posY, int _tc)
	{
		_g.setColor(this.p.getCQFin());
		for (int i=2 ; i<10 ; i++) // lignes verticales
			_g.drawLine(i*_tc, _posY, i*_tc, 9*_tc + _posY);
		for (int i=1 ; i<9 ; i++) // lignes horizontales
			_g.drawLine(_tc, _posY + i*_tc, 10*_tc, _posY + i*_tc);
		
		dessinerQLarge(_g, _posY, _tc); // Après avoir dessiné les carreaux fin, on dessine les larges.
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
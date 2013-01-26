package v;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Vue_Dessin extends JPanel
{
	private Vue_Terrain vt;
	private int styleQ; // 0 = sans quadrillage, 1 = 3 carreaux, 2 = 9 carreaux
	private Color cBase; // Couleur des lignes de base (limites, ligne d'attaque)
	private Color cQLarge; // Couleur du quadrillage large (3 carreaux)
	private Color cQFin; // Couleur du quadrillage fin (9 carreaux)
	
	public Vue_Dessin(Vue_Terrain _vt)
	{
		this.cBase = new Color(0, 0, 0);
		this.cQLarge = new Color(0, 80, 0);
		this.cQFin = new Color(0, 95, 0);
		this.vt = _vt;
		this.styleQ = 0;
	}
	
	public void paintComponent(Graphics _g)
	{
		Color vert = new Color(0, 100, 0);
		_g.setColor(vert);
		_g.fillRect(0, 0, this.getWidth(), this.getHeight());
		if (this.vt.getDemi()) // demi terrain
			dessinerDT(_g, this.styleQ);
		else // terrain complet
			dessinerTC(_g, this.styleQ);
	}
	
	public void setStyleQ(int _styleQ)
	{
		this.styleQ = _styleQ;
	}
	
	/**
	 * Dessine un demi terrain
	 * @param _g Composant graphique.
	 * @param _styleQ Style de quadrillage : 0 pour aucun, 1 pour 3 carreaux, 2 pour 9 carreaux.
	 * @author Nathanaël Jourdane
	 */
	public void dessinerDT(Graphics _g, int _styleQ)
	{
		int tc = 50;
		
		if (_styleQ == 1)
			dessinerQLarge(_g, tc, tc);
		else if(_styleQ == 2)
			dessinerQFin(_g, 0, tc);
		
		_g.setColor(this.cBase);
		_g.drawLine(tc, tc*9, tc*10, tc*9); // ligne bas
		_g.drawLine(tc, 0, tc, tc*9); // ligne gauche
		_g.drawLine(tc*10, 0, tc*10, tc*9); // ligne droite
		_g.drawLine(tc, tc*3, tc*10, tc*3); // ligne d'attaque
	}
	
	/**
	 * Dessine un terrain complet.
	 * @param _g Composant graphique.
	 * @param _styleQ Style de quadrillage : 0 pour aucun, 1 pour 3 carreaux, 2 pour 9 carreaux.
	 * @author Nathanaël Jourdane
	 */
	public void dessinerTC(Graphics _g, int _styleQ)
	{
		int tc = 36;
		
		if (_styleQ == 1)
		{
			//dessinerQLarge(_g, 10, tc);
			//dessinerQLarge(_g, 2*tc, tc);
		}
		else if(_styleQ == 2)
		{
			dessinerQFin(_g, tc, tc);
			dessinerQFin(_g, 10*tc, tc);
		}
		
		_g.setColor(this.cBase);
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
	 * @param _g Composant graphique.
	 * @param _posY La position verticale du quadrillage.
	 * @param _tc La taille d'un carreau, qui déterminera celle du quadrillage
	 * @author Nathanaël Jourdane
	 */
	private void dessinerQFin(Graphics _g, int _posY, int _tc)
	{
		_g.setColor(this.cQFin);
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
	 * @param _tc La taille d'un carreau, qui déterminera celle du quadrillage
	 * @author Nathanaël Jourdane
	 */
	private void dessinerQLarge(Graphics _g, int _posY, int _tc)
	{
		_g.setColor(this.cQLarge);

		// lignes horizontales
		_g.drawLine(_tc, _posY + _tc*6, _tc*10, _posY + _tc*6);
		_g.drawLine(_tc, _posY + _tc*3, _tc*10, _posY + _tc*3);
		// lignes verticales
		_g.drawLine(_tc*4, _posY, _tc*4, _posY + _tc*9);
		_g.drawLine(_tc*7, _posY, _tc*7, _posY + _tc*9);
	}
}
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
	
	public Vue_Dessin(Vue_Terrain _vt, int _styleQ)
	{
		this.cBase = new Color(0, 0, 0);
		this.cQLarge = new Color(0, 80, 0);
		this.cQFin = new Color(0, 95, 0);
		this.vt = _vt;
		this.styleQ = _styleQ;
	}
	
	public void paintComponent(Graphics _g)
	{
		this.styleQ = 2; // carreaux fins (à supprimer)
		
		//if (this.vt.getDemi()) // demi terrain
			dessinerDT(_g, this.styleQ);
		/*else // terrain complet
			dessinerTC(_g, this.styleQ);*/
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
		if (_styleQ == 1)
		{
			dessinerQLarge(_g, 10, 36);
			dessinerQLarge(_g, 100, 36);
		}
		else if(_styleQ == 2)
		{
			dessinerQFin(_g, 10, 10);
			dessinerQFin(_g, 100, 10);
		}
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

		// ligne horizontale
		_g.drawLine(_tc, _tc*6, _tc*10, _tc*6);
		// lignes verticales
		_g.drawLine(_tc*4, 0, _tc*4, _tc*9);
		_g.drawLine(_tc*7, 0, _tc*7, _tc*9);
	}
}
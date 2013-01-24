package v;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Vue_Dessin extends JPanel
{
	private Vue_Terrain vt;
	private int styleQ; // 0 = sans quadrillage, 1 = 3 carreaux, 2 = 9 carreaux
	
	public Vue_Dessin(Vue_Terrain _vt, int _styleQ)
	{
		this.vt = _vt;
		this.styleQ = _styleQ;
	}
	
	public void paintComponent(Graphics _g)
	{
		this.styleQ = 2; // carreaux fins (à supprimer)
		_g.setColor(Color.black);
		
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
		/*if (_styleQ == 1)
			dessinerQLarge(_g, 50, 50);
		else if(_styleQ == 2)*/
			dessinerQFin(_g, 0, 50);
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
		for (int i=2 ; i<10 ; i++) // lignes verticales
			_g.drawLine(i*_tc, _posY, i*_tc, 9*_tc + _posY);
		for (int i=1 ; i<9 ; i++) // lignes horizontales
			_g.drawLine(_tc, _posY + i*_tc, 10*_tc, _posY + i*_tc);
		
		//dessinerQLarge(_g, _posY, _tc); // Après avoir dessiné les carreaux fin, on dessine les larges.
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
		for (int i=4 ; i<3 ; i+=3) // lignes verticales
			_g.drawLine(i*_tc, 0, i*_tc, 3*_tc);
		for (int i=4 ; i<3 ; i+=3) // lignes horizontales
			_g.drawLine(0, _posY + i*_tc, 3*_tc, _posY + i*_tc);
	}
}
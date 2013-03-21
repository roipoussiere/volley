package v_vues;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

import m.Orientation;
import c.ControleurVueDessin;

/**
 * Vue de dessin, pour dessiner sur la fenetre de terrain.
 * @author Nathanaël Jourdane
 */
@SuppressWarnings("serial")
public class Vue_Dessin extends JPanel
{
	private ControleurVueDessin cvd;
	private Graphics2D graph;
	/**
	 * Constructeur de la vue de dessin.
	 * @param _cvd La fenêtre du terrain.
	 */
	public Vue_Dessin(ControleurVueDessin _cvd)
	{
		this.cvd = _cvd;
		this.graph = null;
	}
	
	/**
	 * Méthode qui sera appelée à chaque action sur la fenêtre, qui permet de redessiner l'intégralité de son contenu.
	 * @param _g : Le composant graphique.
	 */
	public void paintComponent(Graphics _g)
	{
		this.graph = (Graphics2D)_g;
		this.graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		this.cvd.majDessin();
	}
	
	public void affJeton(float _posX, float _posY, int _ort, String _id, float _taille, Color _coul)
	{
		// Dessin du cercle
		this.graph.setColor(_coul);
		this.graph.fill(new Ellipse2D.Float(_posX, _posY, _taille, _taille));
		
		// Contour du cercle
		this.graph.setColor(Color.BLACK);
		this.graph.draw(new Ellipse2D.Float(_posX, _posY, _taille, _taille));
		
		// Création de la barre pour l'orientation
		float angle1 = (2*_ort+1)*(float)Math.PI/4;
		float angle2 = (2*_ort+3)*(float)Math.PI/4;
		
		// Coordonnées du centre du cercle
		float cX = _posX+_taille/2;
		float cY = _posY+_taille/2;
				
		float x1 = (float) (cX+Math.cos(angle1)*_taille/2);
		float y1 = (float) (cY+Math.sin(angle1)*_taille/2);
		float x2 = (float) (cX+Math.cos(angle2)*_taille/2);
		float y2 =(float) (cY+Math.sin(angle2)*_taille/2);
		
		// Dessin de la barre
		this.graph.draw(new Line2D.Float(x1, y1, x2, y2));
		
		// Dessin de l'id
		this.graph.drawString(_id, (int)(cX-0.19*_taille), (int)(cY+0.15*_taille));
	}
	
	/**
	 * Dessine un demi terrain.
	 * @param _g Le composant graphique.
	 * @param _styleQ Style de quadrillage : 0 pour aucun, 1 pour 3 carreaux, 2 pour 9 carreaux.
	 */
	public void dessinerDT(int _styleQ, int _tc, Color _coulFond, Color _coulBord, Color _coulLigne, Color _coulQLarge, Color _coulQFin, Color _coulCoords)
	{
		this.graph.setColor(_coulBord);
		this.graph.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		this.graph.setColor(_coulFond);
		this.graph.fillRect(_tc, _tc, this.getWidth()-2*_tc, this.getHeight()-2*_tc);

		// Si styleQ = 0 on ne dessine pas de lignes
		if (_styleQ == 1)
		{
			dessinerQLarge(_tc, _tc, _coulQLarge);
		}
		else if(_styleQ == 2)
		{
			dessinerQFin(0, _tc, _coulQFin);
			dessinerQLarge(_tc, _tc, _coulQLarge);
			
			dessinerCoords(_tc, _coulCoords, true);
		}
		
		this.graph.setColor(_coulLigne);
		
		this.graph.drawLine(_tc, _tc*10, _tc*10, _tc*10); // ligne bas
		this.graph.drawLine(_tc, _tc, _tc, _tc*10); // ligne gauche
		this.graph.drawLine(_tc*10, _tc, _tc*10, _tc*10); // ligne droite
		this.graph.drawLine(_tc, _tc*4, _tc*10, _tc*4); // ligne d'attaque
		this.graph.drawLine(_tc, _tc, _tc*10, _tc); // ligne de service
	}
	
	/**
	 * Dessine un terrain complet.
	 * @param _g Le composant graphique.
	 * @param _styleQ Style de quadrillage : 0 pour aucun, 1 pour 3 carreaux, 2 pour 9 carreaux.
	 */
	public void dessinerTC(int _styleQ, int _tc, Color _coulFond, Color _coulBord, Color _coulLignes, Color _coulQLarge, Color _coulQFin, Color _coulCoords)
	{
		this.graph.setColor(_coulBord);
		this.graph.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		this.graph.setColor(_coulFond);
		this.graph.fillRect(_tc, _tc, this.getWidth()-2*_tc, this.getHeight()-2*_tc);
		
		if (_styleQ == 1)
		{
			dessinerQLarge(0, _tc, _coulQLarge);
			dessinerQLarge(10*_tc, _tc, _coulQLarge);
		}
		else if(_styleQ == 2)
		{
			dessinerQFin(0, _tc, _coulQFin);
			dessinerQFin(10*_tc, _tc,_coulQFin);
			dessinerQLarge(_tc, _tc, _coulQLarge);
			dessinerQLarge(10*_tc, _tc, _coulQLarge);
			dessinerCoords(_tc, _coulCoords, false);
		}
		
		this.graph.setColor(_coulLignes);
		
		// lignes verticales
		this.graph.drawLine(_tc, _tc, _tc*10, _tc); // limite haut
		this.graph.drawLine(_tc, _tc*7, _tc*10, _tc*7); // attaque haut
		this.graph.drawLine(_tc, _tc*10, _tc*10, _tc*10); // ligne de service
		this.graph.drawLine(_tc, _tc*13, _tc*10, _tc*13); // attaque bas
		this.graph.drawLine(_tc, _tc*19, _tc*10, _tc*19); // ligne bas
		
		//lignes verticales
		this.graph.drawLine(_tc, _tc, _tc, _tc*19); // ligne gauche
		this.graph.drawLine(_tc*10, _tc, _tc*10, _tc*19); // ligne droite
	}
	
	private void dessinerCoords(int _tc, Color _coulCoords, boolean _isDT)
	{
		this.graph.setColor(_coulCoords);
		int nbCarH = 9; // Nombre de carreaux en hauteu
		if (!_isDT)
			nbCarH = 18;
		for (int i=0 ; i<9 ; i++)
		{
			this.graph.drawString(String.valueOf((char) (i+'A')), (int) (_tc*(i+1.4)), (int) (_tc*0.6));
		}
		for (int i=0 ; i<nbCarH ; i++)
		{
			this.graph.drawString(String.valueOf(i), (int) (_tc*0.4), (int) (_tc*(i+1.6)));
		}
	}
	
	/**
	 * Dessine un quadrillage de 11*11 carreaux.
	 * @param _g Le composant graphique.
	 * @param _posY La position verticale du quadrillage.
	 * @param _tc La taille d'un carreau, qui déterminera celle du quadrillage.
	 */
	public void dessinerQFin(int _posY, int _tc, Color _coulQFin)
	{
		int nbX = 11;
		int nbY = 11;
		
		this.graph.setColor(_coulQFin);
		
		for (int i=0 ; i<nbX+1 ; i++) {
			this.graph.drawLine(i*_tc, _posY, i*_tc, nbY*_tc + _posY);
		}
		for (int i=0 ; i<nbY+1 ; i++) {
			this.graph.drawLine(0, _posY + i*_tc, nbX*_tc, _posY + i*_tc);
		}
	}
	
	/**
	 * Dessine un quadrillage de 3*3 carreaux.
	 * @param _g Composant graphique.
	 * @param _posY La position verticale du quadrillage.
	 * @param _tc La taille d'un carreau, qui déterminera celle du quadrillage.
	 */
	private void dessinerQLarge(int _posY, int _tc, Color _coulQLarge)
	{
		this.graph.setColor(_coulQLarge);

		// lignes horizontales
		this.graph.drawLine(_tc, _posY + _tc*6, _tc*10, _posY + _tc*6);
		this.graph.drawLine(_tc, _posY + _tc*3, _tc*10, _posY + _tc*3);
		
		// lignes verticales
		this.graph.drawLine(_tc*4, _posY, _tc*4, _posY + _tc*9);
		this.graph.drawLine(_tc*7, _posY, _tc*7, _posY + _tc*9);
	}
}
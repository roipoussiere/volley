package v_vues;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
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
		this.cvd.initDessin();
	}
	
	public void affJeton(float _posX, float _posY, int _angle, String _nom, String _id, float _taille, Color _coul)
	{
		// Si c'est un joueur
		if (_angle != -1)
		{
			// Dessin du jeton
			this.graph.setColor(_coul);
			this.graph.fill(new Arc2D.Float(_posX, _posY, _taille, _taille, _angle, 270, Arc2D.CHORD));
		
			// Contour du jeton
			this.graph.setColor(Color.BLACK);
			this.graph.draw(new Arc2D.Float(_posX, _posY, _taille, _taille, _angle, 270, Arc2D.CHORD));

			// Dessin de l'id
			this.graph.drawString(_id, (int)(_posX+0.26*_taille), (int)(_posY+0.68*_taille));
			
			// Dessin du nom
			this.graph.drawString(_nom, _posX, (int)(_posY+1.35*_taille));
		}
		
		// Si c'est le ballon
		else
		{
			// Dessin du cercle
			this.graph.setColor(_coul);
			this.graph.fill(new Ellipse2D.Float(_posX, _posY, _taille, _taille));
			
			// Contour du cercle
			this.graph.setColor(Color.BLACK);
			this.graph.draw(new Ellipse2D.Float(_posX, _posY, _taille, _taille));
		}
	}
	
	/**
	 * Dessine un demi terrain.
	 * @param _styleQ Style de quadrillage : 0 pour aucun, 1 pour 3 carreaux, 2 pour 9 carreaux.
	 * @param _tc La taille d'un carreau, correspondant à une zone de 1m² sur le terrain.
	 * @param _coulFond La couleur du fond du terrain
	 * @param _coulBord La couleur de la bordure du terrain
	 * @param _coulLignes La couleurs des lignes du terrain
	 */
	public void dessinerDT(int _styleQ, int _tc, Color _coulFond, Color _coulBord, Color _coulLignes)
	{
		this.graph.setColor(_coulBord.brighter());
		this.graph.fillRect(0, 0, this.getWidth(), this.getHeight());

		this.graph.setColor(_coulBord);
		this.graph.fillRect(0, 0, 11*_tc, 11*_tc);
		
		this.graph.setColor(_coulFond);
		this.graph.fillRect(_tc, _tc, 9*_tc, 9*_tc);

		// Si styleQ = 0 on ne dessine pas de lignes
		if (_styleQ == 1)
		{
			dessinerQLarge(_tc, _tc, _coulFond.darker().darker());
		}
		else if(_styleQ == 2)
		{
			dessinerQFin(0, _tc, _coulBord.darker(), true);
			dessinerQFin(0, _tc, _coulFond.darker(), false);
			dessinerQLarge(_tc, _tc, _coulFond.darker().darker());
			
			dessinerCoords(_tc, _coulBord.darker().darker().darker().darker(), true);
		}
		
		this.graph.setColor(_coulLignes);
		
		this.graph.drawLine(_tc, _tc*10, _tc*10, _tc*10); // ligne bas
		this.graph.drawLine(_tc, _tc, _tc, _tc*10); // ligne gauche
		this.graph.drawLine(_tc*10, _tc, _tc*10, _tc*10); // ligne droite
		this.graph.drawLine(_tc, _tc*4, _tc*10, _tc*4); // ligne d'attaque
		this.graph.fillRect(_tc, _tc, _tc*9, 3);  // ligne de service
	}
	
	/**
	 * Dessine un terrain complet.
	 * @param _styleQ Style de quadrillage : 0 pour aucun, 1 pour 3 carreaux, 2 pour 9 carreaux.
	 * @param _tc La taille d'un carreau, correspondant à une zone de 1m² sur le terrain.
	 * @param _coulFond La couleur du fond du terrain
	 * @param _coulBord La couleur de la bordure du terrain
	 * @param _coulLignes La couleurs des lignes du terrain
	 */
	public void dessinerTC(int _styleQ, int _tc, Color _coulFond, Color _coulBord, Color _coulLignes)
	{
		this.graph.setColor(_coulBord.brighter());
		this.graph.fillRect(0, 0, this.getWidth(), this.getHeight());

		this.graph.setColor(_coulBord);
		this.graph.fillRect(0, 0, 11*_tc, 20*_tc);
		
		this.graph.setColor(_coulFond);
		this.graph.fillRect(_tc, _tc, 9*_tc, 18*_tc);
		
		if (_styleQ == 1)
		{
			dessinerQLarge(0, _tc, _coulFond.darker().darker());
			dessinerQLarge(10*_tc, _tc, _coulFond.darker().darker());
		}
		else if(_styleQ == 2)
		{
			dessinerQFin(0, _tc, _coulBord.darker(), true);
			dessinerQFin(10*_tc, _tc, _coulBord.darker(), true);
			dessinerQFin(0, _tc, _coulFond.darker(), false);
			dessinerQFin(9*_tc, _tc, _coulFond.darker(), false);
			dessinerQLarge(_tc, _tc, _coulFond.darker().darker());
			dessinerQLarge(10*_tc, _tc, _coulFond.darker().darker());
			
			dessinerCoords(_tc, _coulBord.darker().darker().darker().darker(), false);
		}
		
		this.graph.setColor(_coulLignes);
		
		// lignes horizontales
		this.graph.drawLine(_tc, _tc, _tc*10, _tc); // limite haut
		this.graph.drawLine(_tc, _tc*7, _tc*10, _tc*7); // attaque haut
		this.graph.fillRect(_tc, _tc*10-2, _tc*9, 3);  // ligne de service
		this.graph.drawLine(_tc, _tc*13, _tc*10, _tc*13); // attaque bas
		this.graph.drawLine(_tc, _tc*19, _tc*10, _tc*19); // ligne bas
		
		//lignes verticales
		this.graph.drawLine(_tc, _tc, _tc, _tc*19); // ligne gauche
		this.graph.drawLine(_tc*10, _tc, _tc*10, _tc*19); // ligne droite
	}
	
	private void dessinerCoords(int _tc, Color _coulCoords, boolean _isDT)
	{
		this.graph.setColor(_coulCoords);
		int nbCarH = 11; // Nombre de carreaux en hauteur
		int nbCarL = 11;
		
		if (!_isDT)
			nbCarH = 20;
		
		// Coordonnées horizontales
		for (int i=0 ; i<nbCarL ; i++)
		{
			this.graph.drawString(String.valueOf((char) (i+'A')), (int) (_tc*(i+0.4)), nbCarH*_tc+13);
		}

		// Coordonnées verticales
		for (int i=0 ; i<nbCarH ; i++)
		{
			this.graph.drawString(String.valueOf(i), nbCarL*_tc+3, (int) (_tc*(nbCarH-i-0.4)));
		}
	}
	
	/**
	 * Dessine un quadrillage de 11*11 carreaux.
	 * @param _posY La position verticale du quadrillage.
	 * @param _tc La taille d'un carreau, qui déterminera celle du quadrillage.
	 * @param _coulQFin La couleur du quadrillage à dessiner.
	 * @param _avecBord True pour dessiner sur les bordures, false sinon
	 */
	public void dessinerQFin(int _posY, int _tc, Color _coulQFin, boolean _avecBord)
	{
		int nbX = 11;
		int nbY = 11;
		
		this.graph.setColor(_coulQFin);
		
		if (_avecBord)
		{
			for (int i=0 ; i<nbX+1 ; i++) {
				this.graph.drawLine(i*_tc, _posY, i*_tc, nbY*_tc + _posY);
			}
			for (int i=0 ; i<nbY ; i++) {
				this.graph.drawLine(0, _posY + i*_tc, nbX*_tc, _posY + i*_tc);
			}
		}
		else
		{
			for (int i=0 ; i<nbX ; i++) {
				this.graph.drawLine(i*_tc, _posY+_tc, i*_tc, (nbY-1)*_tc + _posY);
			}
			for (int i=0 ; i<nbY-1 ; i++) {
				this.graph.drawLine(_tc, _posY + (i+1)*_tc, (nbX-1)*_tc, _posY + (i+1)*_tc);
			}
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
package v_vues;

import c.ControleurVueDessin;
import c.Parametres;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.Position;

import m.Strategie;

/**
 * Vue de dessin, pour dessiner sur la fenetre de terrain.
 * @author Nathanaël Jourdane
 */
@SuppressWarnings("serial")
public class Vue_Dessin extends JPanel
{
	private ControleurVueDessin cvd;
	private Graphics graph;
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
	@Override
	public void paintComponent(Graphics _g)
	{
		this.graph = _g;
		this.cvd.majDessin();
	}
	
	public void affJeton(int _posX, int _posY, int taille, Color coul)
	{
		this.graph.setColor(coul);
		this.graph.fillOval(_posX, _posY, taille, taille);
	}
	
	/**
	 * Dessine un demi terrain.
	 * @param _g Le composant graphique.
	 * @param _styleQ Style de quadrillage : 0 pour aucun, 1 pour 3 carreaux, 2 pour 9 carreaux.
	 */
	public void dessinerDT(int _styleQ, int _tc, Color _coulFond, Color _coulLigne, Color _coulQLarge, Color _coulQFin)
	{
		this.graph.setColor(_coulFond); //p.getCFondBas()
		this.graph.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// Si styleQ = 0 on ne dessine pas de lignes
		if (_styleQ == 1)
		{
			dessinerQLarge(_tc, _tc, _coulQLarge);
		}
		else if(_styleQ == 2)
		{
			dessinerQFin(0, _tc, _coulQFin);
			dessinerQLarge(_tc, _tc, _coulQLarge);
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
	public void dessinerTC(int _styleQ, int _tc, Color _coulFond, Color _coulLignes, Color _coulQLarge, Color _coulQFin)
	{
		this.graph.setColor(_coulFond);
		this.graph.fillRect(0, 0, this.getWidth(), this.getHeight());
		
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
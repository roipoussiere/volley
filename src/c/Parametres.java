package c;

import java.awt.Color;

/**
 * Classe contenant tous les paramètres du programme et tous ses getters & setters.
 * @author Nathanaël Jourdane
 */
public class Parametres
{
	// Style de quadrillage : 0 : sans quadrillage, 1 : 3 carreaux, 2 : 9 carreaux
	private int styleQL; // Style de quadrillage en mode lecture.
	private int styleQE; // Style de quadrillage en mode Edition.
	
	private Color cFond; // Couleur des lignes de base (limites, ligne d'attaque)
	private Color cLignes; // Couleur des lignes de base (limites, ligne d'attaque)
	private Color cQLarge; // Couleur du quadrillage large (3 carreaux)
	private Color cQFin; // Couleur du quadrillage fin (9 carreaux)
	
	/**
	 * Affectation des valeurs par défaut
	 * @author Nathanaël Jourdane
	 */
	public Parametres()
	{
		styleQL = 0;
		styleQE = 2;
		
		cFond = new Color(0, 100, 0);
		cLignes = new Color(0, 0, 0);
		cQLarge = new Color(0, 80, 0);
		cQFin = new Color(0, 95, 0);
	}
	
	/**
	 * Getter du style de quadrillage en mode Lecture.
	 * @return Le style de quadrillage en mode Lecture.
	 * @author Nathanaël Jourdane
	 */
	public int getStyleQL()
	{
		return styleQL;
	}
	
	/**
	 * Setter du style de quadrillage en mode Lecture.
	 * @param styleL Le style de quadrillage en mode Lecture.
	 * @author Nathanaël Jourdane
	 */
	public void setStyleQL(int styleL)
	{
		this.styleQL = styleL;
	}
	
	/**
	 * Getter du style de quadrillage en mode Edition.
	 * @return Le style de quadrillage en mode Edition.
	 * @author Nathanaël Jourdane
	 */
	public int getStyleQE()
	{
		return styleQE;
	}
	
	/**
	 * Setter du style de quadrillage en mode Edition.
	 * @param styleE Le style de quadrillage en mode Edition.
	 * @author Nathanaël Jourdane
	 */
	public void setStyleQE(int styleE)
	{
		this.styleQE = styleE;
	}
	
	/**
	 * Getter de la couleur de fond du terrain.
	 * @return La couleur de fond du terrain.
	 * @author Nathanaël Jourdane
	 */
	public Color getCFond()
	{
		return cFond;
	}
	
	/**
	 * Setter de la couleur de fond du terrain.
	 * @param cFond La couleur de fond du terrain.
	 * @author Nathanaël Jourdane
	 */
	public void setCFond(Color cFond)
	{
		this.cFond = cFond;
	}
	
	/**
	 * Getter de la couleur des lignes basiques (limites, filet, ligne d'attaque).
	 * @return La couleur des lignes basiques (limites, filet, ligne d'attaque).
	 * @author Nathanaël Jourdane
	 */
	public Color getCLignes()
	{
		return cLignes;
	}
	
	/**
	 * Setter de la couleur des lignes basiques (limites, filet, ligne d'attaque).
	 * @param cFond La couleur des lignes basiques (limites, filet, ligne d'attaque).
	 * @author Nathanaël Jourdane
	 */
	public void setCLignes(Color cLignes)
	{
		this.cLignes = cLignes;
	}
	
	/**
	 * Getter de la couleur du quadrillage large (terrain découpé en 3*3).
	 * @return La couleur du quadrillage large (terrain découpé en 3*3).
	 * @author Nathanaël Jourdane
	 */
	public Color getCQLarge()
	{
		return cQLarge;
	}
	
	/**
	 * Setter de la couleur du quadrillage large (terrain découpé en 3*3).
	 * @param cFond La couleur du quadrillage large (terrain découpé en 3*3).
	 * @author Nathanaël Jourdane
	 */
	public void setCQLarge(Color cQLarge)
	{
		this.cQLarge = cQLarge;
	}
	
	/**
	 * Getter de la couleur du quadrillage fin (terrain découpé en 9*9).
	 * @return La couleur du quadrillage fin (terrain découpé en 9*9).
	 * @author Nathanaël Jourdane
	 */
	public Color getCQFin()
	{
		return cQFin;
	}
	
	/**
	 * Setter de la couleur du quadrillage fin (terrain découpé en 9*9).
	 * @param cFond La couleur du quadrillage fin (terrain découpé en 9*9).
	 * @author Nathanaël Jourdane
	 */
	public void setCQFin(Color cQFin)
	{
		this.cQFin = cQFin;
	}
}

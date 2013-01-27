package c;

import java.awt.Color;

/**
 * Classe contenant tous les paramètres du programme et tous ses getters & setters.
 * @author Nathanaël Jourdane
 */
public class Parametres
{
	// Style de quadrillage : 0 : sans quadrillage, 1 : 3 carreaux, 2 : 9 carreaux.
	private int styleQL; // Style de quadrillage en mode lecture.
	private int styleQE; // Style de quadrillage en mode Edition.
	
	private Color cFond; // Couleur des lignes de base (limites, ligne d'attaque).
	private Color cLignes; // Couleur des lignes de base (limites, ligne d'attaque).
	private Color cQLarge; // Couleur du quadrillage large (3 carreaux).
	private Color cQFin; // Couleur du quadrillage fin (9 carreaux).
	
	// Paramètres divers
	private String cheminFichier; // Chemin du fichier à lire ou éditer.
	private boolean demiT; // Mode d'affichage : Demi-terrain (true) ou terrain complet (false).

	/**
	 * Affectation des valeurs par défaut
	 */
	public Parametres()
	{
		styleQL = 0;
		styleQE = 2;
		
		cFond = new Color(0, 100, 0);
		cLignes = new Color(0, 0, 0);
		cQLarge = new Color(0, 75, 0);
		cQFin = new Color(0, 90, 0);
		
		this.cheminFichier = "/home/natha/volley/fichiers_strategie/attaque/testAtt.svb";
		this.demiT = true;
	}
	
	/**
	 * Getter du chemin du fichier à lire ou éditer.
	 * @return Le chemin du fichier à lire ou éditer.
	 */
	public String getCheminFichier()
	{
		return cheminFichier;
	}
	
	/**
	 * Setter du chemin du fichier à lire ou éditer.
	 * @param cheminFichier Le nom du fichier à lire ou éditer.
	 */
	public void setCheminFichier(String cheminFichier)
	{
		this.cheminFichier = cheminFichier;
	}
	
	/**
	 * Getter du mode d'affichage du terrain.
	 * @return Le du mode d'affichage du terrain.
	 */
	public boolean isDemiT()
	{
		return demiT;
	}
	
	/**
	 * Setter du mode d'affichage du terrain.
	 * @param demiT Le mode d'affichage du terrain.
	 */
	public void setDemiT(boolean demiT)
	{
		this.demiT = demiT;
	}

	/**
	 * Getter du style de quadrillage en mode Lecture.
	 * @return Le style de quadrillage en mode Lecture.
	 */
	public int getStyleQL()
	{
		return styleQL;
	}
	
	/**
	 * Setter du style de quadrillage en mode Lecture.
	 * @param styleL Le style de quadrillage en mode Lecture.
	 */
	public void setStyleQL(int styleL)
	{
		this.styleQL = styleL;
	}
	
	/**
	 * Getter du style de quadrillage en mode Edition.
	 * @return Le style de quadrillage en mode Edition.
	 */
	public int getStyleQE()
	{
		return styleQE;
	}
	
	/**
	 * Setter du style de quadrillage en mode Edition.
	 * @param styleE Le style de quadrillage en mode Edition.
	 */
	public void setStyleQE(int styleE)
	{
		this.styleQE = styleE;
	}
	
	/**
	 * Getter de la couleur de fond du terrain.
	 * @return La couleur de fond du terrain.
	 */
	public Color getCFond()
	{
		return cFond;
	}
	
	/**
	 * Setter de la couleur de fond du terrain.
	 * @param cFond La couleur de fond du terrain.
	 */
	public void setCFond(Color cFond)
	{
		this.cFond = cFond;
	}
	
	/**
	 * Getter de la couleur des lignes basiques (limites, filet, ligne d'attaque).
	 * @return La couleur des lignes basiques (limites, filet, ligne d'attaque).
	 */
	public Color getCLignes()
	{
		return cLignes;
	}
	
	/**
	 * Setter de la couleur des lignes basiques (limites, filet, ligne d'attaque).
	 * @param cLignes La couleur des lignes basiques (limites, filet, ligne d'attaque).
	 */
	public void setCLignes(Color cLignes)
	{
		this.cLignes = cLignes;
	}
	
	/**
	 * Getter de la couleur du quadrillage large (terrain découpé en 3*3).
	 * @return La couleur du quadrillage large (terrain découpé en 3*3).
	 */
	public Color getCQLarge()
	{
		return cQLarge;
	}
	
	/**
	 * Setter de la couleur du quadrillage large (terrain découpé en 3*3).
	 * @param cQLarge La couleur du quadrillage large (terrain découpé en 3*3).
	 */
	public void setCQLarge(Color cQLarge)
	{
		this.cQLarge = cQLarge;
	}
	
	/**
	 * Getter de la couleur du quadrillage fin (terrain découpé en 9*9).
	 * @return La couleur du quadrillage fin (terrain découpé en 9*9).
	 */
	public Color getCQFin()
	{
		return cQFin;
	}
	
	/**
	 * Setter de la couleur du quadrillage fin (terrain découpé en 9*9).
	 * @param cQFin La couleur du quadrillage fin (terrain découpé en 9*9).
	 */
	public void setCQFin(Color cQFin)
	{
		this.cQFin = cQFin;
	}
}

package c;

import java.awt.Color;

import m.Joueur;

/**
 * Classe contenant tous les paramètres du programme et tous ses getters & setters.
 * @author Nathanaël Jourdane
 */
public class Parametres
{
	// Style de quadrillage : 0 : sans quadrillage, 1 : 3 carreaux, 2 : 9 carreaux.
	private int styleQL; // Style de quadrillage en mode lecture.
	private int styleQE; // Style de quadrillage en mode Edition.
	
	private Color cFond; // Couleur de fond du terrain.
	private Color cBordures; // Couleur de la bordure du terrain.
	private Color cLignes; // Couleur des lignes de base (limites, ligne d'attaque).
	private Color cQLarge; // Couleur du quadrillage large (3 carreaux).
	private Color cQFin; // Couleur du quadrillage fin (9 carreaux).
	private Color cCoords; // Couleur des coordonnées.
	
	// Nom des élements
	private Joueur tabJE1[] = new Joueur[6];
	private Joueur tabJE2[] = new Joueur[6];
	
	// Etat des élements
	private boolean tabEtatE[] = new boolean[13];
	
	private Color tabCoulE[] = new Color[13];
	
	// Divers
	private String cheminFichier; // Chemin du fichier à lire ou éditer.
	private boolean demiT; // Mode d'affichage : Demi-terrain (true) ou terrain complet (false).
	
	/**
	 * Affectation des valeurs par défaut
	 */
	public Parametres()
	{
		// Style de quadrillage
		styleQL = 0;
		styleQE = 2;
		
		// Couleurs
		cFond = hexToRgb("#dc7814");
		cBordures = hexToRgb("#009900");
		cLignes = hexToRgb("#fafafa");
		cQLarge = hexToRgb("#c86400");
		cQFin = hexToRgb("#d26e0a");
		cCoords = hexToRgb("#dc7814");
		
		// Nom des élements
	
		// Ballon

		// Joueurs équipe 1
		this.tabJE1[0] = new Joueur("A1", "Jean", new m.Position(1, 1));
		this.tabJE1[1] = new Joueur("A2", "Marie", new m.Position(4, 1));
		this.tabJE1[2] = new Joueur("A3", "Philippe", new m.Position(7, 1));
		this.tabJE1[3] = new Joueur("A4", "Nathalie", new m.Position(1, 4));
		this.tabJE1[4] = new Joueur("A5", "Michel", new m.Position(4, 4));
		this.tabJE1[5] = new Joueur("A6", "Isabelle", new m.Position(7, 4));
		
		// Joueurs équipe 2
		this.tabJE2[0] = new Joueur("B1", "Alain", new m.Position(1, 13));
		this.tabJE2[1] = new Joueur("B2", "Sylvie", new m.Position(4, 13));
		this.tabJE2[2] = new Joueur("B3", "Patrick", new m.Position(7, 13));
		this.tabJE2[3] = new Joueur("B4", "Catherine", new m.Position(1, 16));
		this.tabJE2[4] = new Joueur("B5", "Nicolas", new m.Position(4, 16));
		this.tabJE2[5] = new Joueur("B6", "Martine", new m.Position(7, 16));
		
		// Etat des élements
		
		// ballon
		this.tabEtatE[0] = true;
		
		// Joueurs équipe 1
		this.tabEtatE[1] = true;
		this.tabEtatE[2] = true;
		this.tabEtatE[3] = true;
		this.tabEtatE[4] = true;
		this.tabEtatE[5] = true;
		this.tabEtatE[6] = false;
		
		// Joueurs équipe 2
		this.tabEtatE[7] = false;
		this.tabEtatE[8] = false;
		this.tabEtatE[9] = false;
		this.tabEtatE[10] = false;
		this.tabEtatE[11] = false;
		this.tabEtatE[12] = false;
		
		// Couleur des éléments
		
		// Ballon
		this.tabCoulE[0] = new Color(180, 180, 180);
		
		// Joueurs équipe 1
		this.tabCoulE[1] = new Color(70, 70, 70); // Meneur
		this.tabCoulE[2] = new Color(50, 50, 50);
		this.tabCoulE[3] = new Color(50, 50, 50);
		this.tabCoulE[4] = new Color(50, 50, 50);
		this.tabCoulE[5] = new Color(50, 50, 50);
		this.tabCoulE[6] = new Color(50, 50, 50);
		
		// Joueurs équipe 2
		this.tabCoulE[7] = new Color(70, 70, 70); // Meneur
		this.tabCoulE[8] = new Color(50, 50, 50);
		this.tabCoulE[9] = new Color(50, 50, 50);
		this.tabCoulE[10] = new Color(50, 50, 50);
		this.tabCoulE[11] = new Color(50, 50, 50);
		this.tabCoulE[12] = new Color(50, 50, 50);
		
		// Divers
		this.demiT = true;
		this.cheminFichier = "/home/natha/volley/fichiers_strategie/attaque/testAtt.svb";
	}
	
	private Color hexToRgb(String colorStr) {
		int r = Integer.valueOf( colorStr.substring(1, 3 ), 16 );
		int g = Integer.valueOf( colorStr.substring(3, 5 ), 16 );
		int b = Integer.valueOf( colorStr.substring(5, 7 ), 16 );
	    return new Color(r, g, b);
	}
	
	/**
	 * Getter des joueurs par défaut de l'équipe 1.
	 * @return Le joueur par défaut de l'équipe 1.
	 */
	public Joueur getJE1(int _idE)
	{
		return this.tabJE1[_idE];
	}

	/**
	 * Setter des joueurs par défaut de l'équipe 1.
	 * @param _j Le joueur par défaut de l'équipe 1.
	 * @param _idE L'index d'accès au joueur.
	 */
	public void setJe1(Joueur _j, int _idE)
	{
		this.tabJE1[_idE] = _j;
	}
	
	/**
	 * Getter des joueurs par défaut de l'équipe 2.
	 * @return Le joueur par défaut de l'équipe 2.
	 */
	public Joueur getJE2(int _idE)
	{
		return this.tabJE2[_idE];
	}

	/**
	 * Setter des joueurs par défaut de l'équipe 2.
	 * @param _j Le joueur par défaut de l'équipe 2.
	 * @param _idE L'index d'accès au joueur.
	 */
	public void setJe2(Joueur _j, int _idE)
	{
		this.tabJE2[_idE] = _j;
	}
	
	/**
	 * Getter de l'état d'un élement.
	 * @return Un booléen représentant l'état d'un élement.<br/>
	 * Avec true : l'élement est présent sur le terrain et false : l'élement n'apparait pas sur le terrain.
	 */
	public boolean getEtatE(int _idE)
	{
		return this.tabEtatE[_idE];
	}
	
	/**
	 * Setter de l'état d'un élement.
	 * @param etatE Un booléen représentant l'état d'un élement.<br/>
	 * Avec true : l'élement est présent sur le terrain et false : l'élement n'apparait pas sur le terrain.
	 */
	public void setEtatE(boolean _etatE, int _idE)
	{
		this.tabEtatE[_idE] = _etatE;
	}

		/**
	 * Getter de l'état d'un élement.
	 * @return Un booléen représentant l'état d'un élement.<br/>
	 * Avec true : l'élement est présent sur le terrain et false : l'élement n'apparait pas sur le terrain.
	 */
	public Color getCoulE(int _idE)
	{
		return this.tabCoulE[_idE];
	}
	
	/**
	 * Setter de l'état d'un élement.
	 * @param etatE Un booléen représentant l'état d'un élement.<br/>
	 * Avec true : l'élement est présent sur le terrain et false : l'élement n'apparait pas sur le terrain.
	 */
	public void setCoulE(Color _coulE, int _idE)
	{
		this.tabCoulE[_idE] = _coulE;
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
	 * @param _cheminFichier Le nom du fichier à lire ou éditer.
	 */
	public void setCheminFichier(String _cheminFichier)
	{
		this.cheminFichier = _cheminFichier;
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
	 * @param _demiT Le mode d'affichage du terrain.
	 */
	public void setDemiT(boolean _demiT)
	{
		this.demiT = _demiT;
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
	 * @param _styleL Le style de quadrillage en mode Lecture.
	 */
	public void setStyleQL(int _styleL)
	{
		this.styleQL = _styleL;
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
	 * @param _styleE Le style de quadrillage en mode Edition.
	 */
	public void setStyleQE(int _styleE)
	{
		this.styleQE = _styleE;
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
	 * @param _cFond La couleur de fond du terrain.
	 */
	public void setCFond(Color _cFond)
	{
		this.cFond = _cFond;
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
	 * @param _cLignes La couleur des lignes basiques (limites, filet, ligne d'attaque).
	 */
	public void setCLignes(Color _cLignes)
	{
		this.cLignes = _cLignes;
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
	 * @param _cQLarge La couleur du quadrillage large (terrain découpé en 3*3).
	 */
	public void setCQLarge(Color _cQLarge)
	{
		this.cQLarge = _cQLarge;
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
	 * @param _cQFin La couleur du quadrillage fin (terrain découpé en 9*9).
	 */
	public void setCQFin(Color _cQFin)
	{
		this.cQFin = _cQFin;
	}
	
	/**
	 * Getter de la couleur du quadrillage fin (terrain découpé en 9*9).
	 * @return La couleur du quadrillage fin (terrain découpé en 9*9).
	 */
	public Color getCCoords()
	{
		return cCoords;
	}
	
	/**
	 * Setter de la couleur du quadrillage fin (terrain découpé en 9*9).
	 * @param _cQFin La couleur du quadrillage fin (terrain découpé en 9*9).
	 */
	public void setCCoords(Color _cCoords)
	{
		this.cCoords = _cCoords;
	}
}

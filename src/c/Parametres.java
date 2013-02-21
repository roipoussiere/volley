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
	
	private Color cFondBas; // Couleur de fond du demi-terrain bas.
	private Color cFondHaut; // Couleur de fond du demi-terrain haut.
	private Color cLignes; // Couleur des lignes de base (limites, ligne d'attaque).
	private Color cQLarge; // Couleur du quadrillage large (3 carreaux).
	private Color cQFin; // Couleur du quadrillage fin (9 carreaux).
	
	// Nom des élements
	private String tabNomE[] = new String[13];
	
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
		//conversion hex to int : int j = Integer.parseInt(s, 16);
		cFondBas = new Color(220, 120, 20); //#dc7814
		cFondHaut = new Color(190, 90, 0); //#be5a00
		cLignes = new Color(250, 250, 250); //#fafafa
		cQLarge = new Color(200, 100, 0); //#c86400
		cQFin = new Color(210, 110, 10); //#d26e0a
		
		// Nom des élements
	
		// Ballon
		this.tabNomE[0] = "Ballon";

		// Joueurs équipe 1
		this.tabNomE[1] = "Jean";
		this.tabNomE[2] = "Marie";
		this.tabNomE[3] = "Philippe";
		this.tabNomE[4] = "Nathalie";
		this.tabNomE[5] = "Michel";
		this.tabNomE[6] = "Isabelle";
		
		// Joueurs équipe 2
		this.tabNomE[7] = "Alain";
		this.tabNomE[8] = "Sylvie";
		this.tabNomE[9] = "Patrick";
		this.tabNomE[10] = "Catherine";
		this.tabNomE[11] = "Nicolas";
		this.tabNomE[12] = "Martine";
		
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
		this.tabCoulE[0] = new Color(250, 250, 250);
		
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
	
	/**
	 * Getter de nom d'un élement.
	 * @return Le nom d'un élement
	 */
	public String getNomE(int _idE)
	{
		return this.tabNomE[_idE];
	}

	/**
	 * Setter de nom d'un élement.
	 * @param _nomE Le nom d'un élement.
	 */
	public void setNomE(String _nomE, int _idE)
	{
		this.tabNomE[_idE] = _nomE;
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
	public Color getCFondBas()
	{
		return cFondBas;
	}
	
	/**
	 * Setter de la couleur de fond du terrain.
	 * @param _cFond La couleur de fond du terrain.
	 */
	public void setCFondBas(Color _cFondBas)
	{
		this.cFondBas = _cFondBas;
	}
	
	/**
	 * Getter de la couleur de fond du terrain.
	 * @return La couleur de fond du terrain.
	 */
	public Color getCFondHaut()
	{
		return cFondHaut;
	}
	
	/**
	 * Setter de la couleur de fond du terrain.
	 * @param _cFond La couleur de fond du terrain.
	 */
	public void setCFondHaut(Color _cFondHaut)
	{
		this.cFondHaut = _cFondHaut;
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
}

package c;

import java.awt.Color;

import m.Joueur;
import m.Orientation;
import m.TypeElt;

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
	private Color cJoueurE1;
	private Color cJoueurE2;
	private Color cBallon;
	
	// Etat des élements
	private boolean tabEtatE[] = new boolean[13];
	
	// Divers
	private String cheminFichier; // Chemin du fichier à lire ou éditer.
	private boolean demiT; // Mode d'affichage : Demi-terrain (true) ou terrain complet (false).
	
	/**
	 * Affectation des valeurs par défaut
	 */
	public Parametres()
	{
		// Style de quadrillage
		this.styleQL = 2;
		this.styleQE = 2;
		
		// Couleurs
		this.cFond = hexToRgb("#dc7814");
		this.cBordures = hexToRgb("#009900");
		this.cLignes = hexToRgb("#fafafa");
		this.cBallon = hexToRgb("#FFCC33");
		this.cJoueurE1 = hexToRgb("#4b44e1");
		this.cJoueurE2 = hexToRgb("#AA0000");
		
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
	 * @param _etatE Un booléen représentant l'état d'un élement.<br/>
	 * Avec true : l'élement est présent sur le terrain et false : l'élement n'apparait pas sur le terrain.
	 * @param _idE L'index du tableau permetant d'accéder au joueur.
	 */
	public void setEtatE(boolean _etatE, int _idE)
	{
		this.tabEtatE[_idE] = _etatE;
	}
	
	/**
	 * Setter de la couleur du joueur de la 1ere équipe.
	 * @param _cJoueurE1 La couleur du joueur de la 1ere équipe.
	 */
	public void setCJoueurE1(Color _cJoueurE1)
	{
		this.cJoueurE1 = _cJoueurE1;
	}
	
	/**
	 * Getter de la couleur du joueur de la 1ere équipe
	 * @return La couleur du joueur de la 1ere équipe.
	 */
	public Color getCJoueurE1()
	{
		return this.cJoueurE1;
	}
	
	/**
	 * Setter de la couleur du joueur de la 2eme équipe.
	 * @param _cJoueurE2 La couleur du joueur de la 2eme équipe.
	 */
	public void setCJoueurE2(Color _cJoueurE2)
	{
		this.cJoueurE2 = _cJoueurE2;
	}
	
	/**
	 * Getter de la couleur du joueur de la 2eme équipe
	 * @return La couleur du joueur de la 2eme équipe.
	 */
	public Color getCJoueurE2()
	{
		return this.cJoueurE2;
	}

	/**
	 * Setter de la couleur du ballon.
	 * @param _cBallon La couleur du ballon.
	 */
	public void setCBallon(Color _cBallon)
	{
		this.cBallon = _cBallon;
	}
	
	/**
	 * Getter de la couleur du ballon.
	 * @return La couleur du ballon.	*/
	public Color getCBallon()
	{
		return this.cBallon;
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
	 * Getter de la couleur des bordures du terrain.
	 * @return La couleur des bordures du terrain.
	 */
	public Color getCBordures()
	{
		return cBordures;
	}
	
	/**
	 * Setter de la couleur des bordures du terrain.
	 * @param _cBordures La couleur des bordures du terrain.
	 */
	public void setCBordures(Color _cBordures)
	{
		this.cBordures = _cBordures;
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
}

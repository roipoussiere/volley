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
	
	// Joueurs
	private String nomJ1[] = new String[6];
	private String nomJ2[] = new String[6];
	private boolean etatJ1[] = new boolean[6];
	private boolean etatJ2[] = new boolean[6];
	
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
		cFondBas = new Color(220, 120, 20);
		cFondHaut = new Color(190, 90, 0);
		cLignes = new Color(250, 250, 250);
		cQLarge = new Color(200, 100, 0);
		cQFin = new Color(210, 110, 10);
		
		// Nom des joueurs
		this.nomJ1[0] = "Jean";
		this.nomJ1[1] = "Marie";
		this.nomJ1[2] = "Philippe";
		this.nomJ1[3] = "Nathalie";
		this.nomJ1[4] = "Michel";
		this.nomJ1[5] = "Isabelle";
		
		this.nomJ2[0] = "Alain";
		this.nomJ2[1] = "Sylvie";
		this.nomJ2[2] = "Patrick";
		this.nomJ2[3] = "Catherine";
		this.nomJ2[4] = "Nicolas";
		this.nomJ2[5] = "Martine";
		
		// État des joueurs
		this.etatJ1[0] = true;
		this.etatJ1[1] = true;
		this.etatJ1[2] = true;
		this.etatJ1[3] = true;
		this.etatJ1[4] = true;
		this.etatJ1[5] = true;

		this.etatJ2[0] = false;
		this.etatJ2[1] = false;
		this.etatJ2[2] = false;
		this.etatJ2[3] = false;
		this.etatJ2[4] = false;
		this.etatJ2[5] = false;

		// Divers
		this.demiT = true;
		this.cheminFichier = "/home/natha/volley/fichiers_strategie/attaque/testAtt.svb";
	}
	
	/**
	 * Getter des noms des joueurs de la 1ere équipe.
	 * @return Un tableau contenant les 6 noms des joueurs de la 1ere équipe.
	 */
	public String[] getNomJ1()
	{
		return nomJ1;
	}

	/**
	 * Setter des noms des joueurs de la 1ere équipe.
	 * @param _nomJ1 Un tableau contenant les 6 noms des joueurs de la 1ere équipe.
	 */
	public void setNomJ1(String[] _nomJ1)
	{
		this.nomJ1 = _nomJ1;
	}
	
	/**
	 * Getter des noms des joueurs de la 2eme équipe.
	 * @return Un tableau contenant les 6 noms des joueurs de la 2eme équipe.
	 */
	public String[] getNomJ2()
	{
		return nomJ2;
	}
	
	/**
	 * Setter des noms des joueurs de la 2eme équipe.
	 * @param _nomJ2 Un tableau contenant les 6 noms des joueurs de la 2eme équipe.
	 */
	public void setNomJ2(String[] _nomJ2)
	{
		this.nomJ2 = _nomJ2;
	}
	
	/**
	 * Getter de l'état des joueurs de la 1ere équipe.
	 * @return Un tableau de booléens contenant l'état des 6 joueurs de la 1ere équipe.<br/>
	 * Avec true : le joueur est présent sur le terrain et false : le joueur n'apparait pas sur le terrain.
	 */
	public boolean[] getEtatJ1()
	{
		return etatJ1;
	}
	
	/**
	 * Setter de l'état des joueurs de la 1ere équipe.
	 * @param _etatJ1 Un tableau de booléens contenant l'état des 6 joueurs de la 1ere équipe.<br/>
	 * Avec true : le joueur est présent sur le terrain et false : le joueur n'apparait pas sur le terrain.
	 */
	public void setEtatJ1(boolean[] _etatJ1)
	{
		this.etatJ1 = _etatJ1;
	}
	
	/**
	 * Getter de l'état des joueurs de la 2eme équipe.
	 * @return Un tableau de booléens contenant l'état des 6 joueurs de la 2eme équipe.<br/>
	 * Avec true : le joueur est présent sur le terrain et false : le joueur n'apparait pas sur le terrain.
	 */
	public boolean[] getEtatJ2()
	{
		return etatJ2;
	}
	
	/**
	 * Setter de l'état des joueurs de la 2eme équipe.
	 * @param _etatJ2 Un tableau de booléens contenant l'état des 6 joueurs de la 2eme équipe.<br/>
	 * Avec true : le joueur est présent sur le terrain et false : le joueur n'apparait pas sur le terrain.
	 */
	public void setEtatJ2(boolean[] _etatJ2)
	{
		this.etatJ2 = _etatJ2;
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

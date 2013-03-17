/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package c;

import m.*;

/**
 *
 * @author Nathanaël Jourdane
 */
public class ControleurPrincipal {
	private ControleurVueFenetre cvf;
	private ControleurVueTerrain cvt;
	private ControleurVueEdition cve;
	private ControleurVueJoueurs cvj;
	private Parametres p;
	private Strategie s; // À supprimer : normalement la création de la stratégie ne se fait pas ici.

	/**
	 * Constructeur de ControleurPrincipal.
	 */
	public ControleurPrincipal() {
		// Initialisations
		cvf = new ControleurVueFenetre(this);
		
		// *** Mise en place d'une stratégie de base pour les tests ***
		
		Joueur[] tabEq1 = new Joueur[6] ;
		Joueur[] tabEq2 = new Joueur[6] ;
		for (int i = 0 ; i < 6 ; i++)
		{
			tabEq1[i] = new Joueur ("E1-J" + (i + 1), "E1-Prénom" + (i + 1)) ;
			tabEq2[i] = new Joueur ("E2-J" + (i + 1), "E2-Prénom" + (i + 1)) ;
		}
		
		Equipe e1 = new Equipe(tabEq1) ;
		Equipe e2 = new Equipe(tabEq2) ;
		
		this.s = new Strategie(e1, e2) ;
		
		// *** Stratégie de test crée ***
		
		this.p = new Parametres(); // Initialisation des paramètres
		//this.s = new Strategie(); // À supprimer : la création d'une stratégie ne devrait pas se faire ici.
	}


	/**
	 * Getters de ControleurVueFenetre.
	 * @return Le controleur de VueFenetre.
	 */
	public ControleurVueFenetre getCVF() {
		return cvf;
	}

	/**
	 * Getters de ControleurVueTerrain.
	 * @return Le controleur de VueTerrain.
	 */
	public ControleurVueTerrain getCVT() {
		return cvt;
	}

	/**
	 * Getters de ControleurVueEdition.
	 * @return Le controleur de VueEdition.
	 */
	public ControleurVueEdition getCVE() {
		return cve;
	}

	/**
	 * Getters de ControleurVueJoueurs.
	 * @return Le controleur de VueJoueurs.
	 */
	public ControleurVueJoueurs getCVJ() {
		return cvj;
	}

	/**
	 * Getters de Parametres.
	 * @return La classe Parametres dans laquelle se trouve tous les paramètres de l'application.
	 */
	public Parametres getP()
	{
		return this.p;
	}

	// À supprimer
	public Strategie getS()
	{
		return this.s;
	}

}

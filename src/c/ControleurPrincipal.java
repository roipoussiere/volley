/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package c;

import m.Strategie;

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
    //cve = new ControleurVueEdition();
    //cvj = new ControleurVueJoueurs();
    this.p = new Parametres(); // Initialisation des paramètres
		this.s = new Strategie(); // À supprimer : la création d'une stratégie ne devrait pas se faire ici.
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

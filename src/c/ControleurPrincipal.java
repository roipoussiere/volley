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
	private Parametres p;
	private Strategie s;
	private ControleurVueEdition cve;
	private ControleurVueLecture cvl;
	private ControleurVueJoueurs cvj;
	private ControleurVueDessin cvd;
	private ControleurVueTerrain cvt;
	private ControleurVueFenetre cvf;

  /**
   * Constructeur de ControleurPrincipal.
   */
  public ControleurPrincipal() {
	// Initialisations
	this.p = new Parametres(); // Initialisation des paramètres
	this.s = new Strategie();
	this.cve = new ControleurVueEdition(this);
	this.cvl = new ControleurVueLecture(this);
	// Vueterrain est crée mais le terrain est affiché à la création de VueFenetre
	// pour éviter de voir la fenêtre qui se déplace.
	this.cvj = null; // vueJoueurs n'être pas crée maintenant, mais quand on clique sur le bouton.
	this.cvd = new ControleurVueDessin(this);
	this.cvt = new ControleurVueTerrain(this);
	this.cvf = new ControleurVueFenetre(this);
  }

  /**
  * Getters de Parametres.
  * @return La classe Parametres dans laquelle se trouve tous les paramètres de l'application.
  */
 public Parametres getP()
	{
		return this.p;
	}
 
	public Strategie getS()
	{
		return this.s;
	}
	
  /**
  * Getters de ControleurVueEdition.
  * @return Le controleur de VueEdition.
  */
 public ControleurVueEdition getCVE() {
     return cve;
 }
 
 /**
 * Getters de ControleurVueDessin.
 * @return Le controleur de VueDessin.
 */
public ControleurVueDessin getCVD() {
    return cvd;
}

 /**
 * Getters de ControleurVueLecture.
 * @return Le controleur de VueLecture.
 */
public ControleurVueLecture getCVL() {
    return cvl;
}

/**
* Getters de ControleurVueJoueurs.
* @return Le controleur de VueJoueurs.
*/
public ControleurVueJoueurs getCVJ() {
   return cvj;
}

/**
* Setter de ControleurVueJoueurs.
*/
public void setCVJ(ControleurVueJoueurs _cvj) {
   this.cvj = _cvj;
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
  * Setter de strategie
  */
  
  public void setS(Strategie _strat) 
  {
  	this.s = _strat;
  }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package c;

/**
 *
 * @author Nathanaël Jourdane
 */
public class ControleurPrincipal {
  ControleurVueEdition cve;
  ControleurVueFenetre cvf;
  ControleurVueJoueurs cvj;
  
  public ControleurPrincipal() {
    cvf = new ControleurVueFenetre();
    //cve = new ControleurVueEdition();
    //cvj = new ControleurVueJoueurs();
  }

}

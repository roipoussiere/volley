package c;

import v_vues.Vue_Edition;

/**
 * Contrôleur de la vue Édition.
 * @author Florian
 */
public class ControleurVueEdition {
	private Controleur c ;
	private Vue_Edition ve ;
	
	/**
	 * Création du constructeur.
	 * @param _c Le controleur
	 * @param _ve La Vue_Edition liée
	 */
	public ControleurVueEdition (Controleur _c, Vue_Edition _ve) {
		this.c = _c ;
		this.ve = _ve ;
	}
	
  /**
   * Getter du controleur
   * @return 
   */
  public Controleur getC() {
    return this.c;
  }
	/**
	 * Met à jour le temps en cours de traitement dans la stratégie.
	 * @param _tpsTraite Le temps en cours de traitement.
	 */
	public void majStrategieE1 (int _tpsTraite) {
		for (int i = 0 ; i < this.c.getE().getNbJ() ; i++) {
			// A COMPLETER !
		}
	}
  
  /**
   * Getter du temps maximum
   * @return Le temps maximum : S'il est atteint, le bouton 'temps suivant' est bloqué.
   */
  public int getTmpMAX()
  {
    // À modifier
    return 3;
  }
}

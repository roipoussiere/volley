package c;

import v_vues.Vue_Terrain;

/**
 *
 * @author Nathanaël Jourdane
 */
public class ControleurVueTerrain {
  private Vue_Terrain vt;
  private ControleurPrincipal cp;
  
  /**
   * Constructeur de ControleurVueTerrain.
   */
  public ControleurVueTerrain(ControleurPrincipal _cp) {
    this.cp = _cp;
    this.vt = new Vue_Terrain(this);
    this.vt.setTaille();
  }
  
  /**
   * Getter de Vue_Terrain
   * @return La vue du terrain
   */
  public Vue_Terrain getVT() {
    return vt;
  }
  
  public void quitter() {
    this.cp.getCVF().quitter();
  }
  
  public Parametres getP() {
	return this.cp.getP();
  }
  
  	/**
	 * Affectation du mode d'affichage du terrain.
	 */
	public void ms_terrain(boolean _demiT)
	{
		if (this.vt != null)
		{
			System.out.println("Demi terrain : " + _demiT);
			this.cp.getP().setDemiT(_demiT);
			this.vt.setTaille();
			this.cp.getCVF().centrerFen();
		}
	}
}

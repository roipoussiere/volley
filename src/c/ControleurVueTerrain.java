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
    this.vt = new Vue_Terrain(this, this.cp.getCVD());
    this.vt.setTaille(this.cp.getP().isDemiT());
  }
  
  /**
   * Getter de Vue_Terrain
   * @return La vue du terrain
   */
  public Vue_Terrain getVT() {
    return vt;
  }
  
  public void refresh() {
	  this.vt.setTaille(this.cp.getP().isDemiT());
  }
  
  public void quitter() {
    this.cp.getCVF().quitter();
  }
  
  	/**
	 * Affectation du mode d'affichage du terrain.
	 */
	public void modeAff(boolean _demiT)
	{
		if (this.vt != null)
		{
			System.out.println("Mode : demi terrain");
			this.cp.getP().setDemiT(_demiT);
			this.vt.setTaille(this.cp.getP().isDemiT());
			this.cp.getCVF().centrerFen();
		}
		else
		{
			System.out.println("Mode : terrain complet");			
		}
	}
}

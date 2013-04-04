package c;

import v_vues.Vue_Lecture;

public class ControleurVueLecture {
	private ControleurPrincipal cp;
	private Vue_Lecture vl;
	
	public ControleurVueLecture(ControleurPrincipal _cp)
	{
		this.cp = _cp;
		this.vl = new Vue_Lecture(this);
	}
	
	public Vue_Lecture getVueLecture ()
	{
		return this.vl ;
	}
	
	public ControleurPrincipal getCP ()
	{
		return this.cp ;
	}
	
	public void majNomStrategie (String _nomS)
	{
		if(!this.cp.getS().getNomStrat().equals(_nomS))
			this.cp.getCVF().setSauvegarder(false);
		this.cp.getS().setNomStrat(_nomS) ;
		System.out.println("<test_flo> Nom de la stratégie mis à jour...");
		
	}
	
	public void majVue()
	{
		this.vl.majVue() ;
	}
}

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
	
	public void majVue()
	{
		this.vl.majVue() ;
	}
}

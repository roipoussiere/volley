package m_alternatif;

public class Strategie
{
	public enum TypeStrategie {ATTAQUE, DEFENSE} ;
	
	private Equipe eq1, eq2 ;
	private TypeStrategie typeS ;
	
	// Constructeurs
	
	public Strategie (Equipe _e1, Equipe _e2)
	{
		this.eq1 = _e1 ;
		this.eq2 = _e2 ;
		this.typeS = TypeStrategie.ATTAQUE ; // Par défaut --> A CHANGER (?)
	}
	
	public Strategie (Equipe _e1, Equipe _e2, TypeStrategie _ts)
	{
		this.eq1 = _e1 ;
		this.eq2 = _e2 ;
		this.typeS = _ts ;
	}
	
	// Getters
	
	public Equipe getEq1 ()
	{
		return eq1 ;
	}

	public Equipe getEq2 ()
	{
		return eq2 ;
	}

	public TypeStrategie getTypeS ()
	{
		return typeS ;
	}
	
	// Setters
	
	public void setEq1 (Equipe eq1)
	{
		this.eq1 = eq1 ;
	}

	public void setEq2 (Equipe eq2)
	{
		this.eq2 = eq2 ;
	}

	public void setTypeS (TypeStrategie typeS)
	{
		this.typeS = typeS ;
	}
}

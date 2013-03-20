package m;

public class Strategie
{
	public enum TypeStrategie {ATTAQUE, DEFENSE};
	
	private Equipe eq1, eq2 ;
	private TypeStrategie typeS ;
	private int tempsActuel;
	
	// Constructeurs
	
	public Strategie ()
	{
		// Il est nécessaire de remplir les équipes au début, sinon tous les joueurs sont à NULL.
		// À remplacer par les valeurs dans Parametres()
		
		Joueur j11 = new Joueur("11", "Joueur_1-1", new m.Position(0,0));
		Joueur j12 = new Joueur("12", "Joueur_1-2", new m.Position(0,1));
		Joueur j13 = new Joueur("13", "Joueur_1-3", new m.Position(0,2));
		Joueur j14 = new Joueur("14", "Joueur_1-4", new m.Position(0,3));
		Joueur j15 = new Joueur("15", "Joueur_1-5", new m.Position(0,4));
		Joueur j16 = new Joueur("16", "Joueur_1-6", new m.Position(0,5));
		Joueur[] e1 = {j11, j12, j13, j14, j15, j16};
		
		Joueur j21 = new Joueur("21", "Joueur_1-1", new m.Position(1,0));
		Joueur j22 = new Joueur("22", "Joueur_2-2", new m.Position(1,1));
		Joueur j23 = new Joueur("23", "Joueur_2-3", new m.Position(1,2));
		Joueur j24 = new Joueur("24", "Joueur_2-4", new m.Position(1,3));
		Joueur j25 = new Joueur("25", "Joueur_2-5", new m.Position(1,4));
		Joueur j26 = new Joueur("26", "Joueur_2-6", new m.Position(1,5));
		Joueur[] e2 = {j21, j22, j23, j24, j25, j26};
		
		this.eq1 = new Equipe(e1) ;
		this.eq2 = new Equipe(e2) ;
		
		this.typeS = TypeStrategie.ATTAQUE ; // Par défaut --> A CHANGER (?)
		this.tempsActuel = 0; // Temps à 0 à la création de la stratégie
	}
    
	public Strategie (Equipe _e1, Equipe _e2)
	{
		this.eq1 = _e1 ;
		this.eq2 = _e2 ;
		this.typeS = TypeStrategie.ATTAQUE ; // Par défaut --> A CHANGER (?)
		this.tempsActuel = 0; // Temps à 0 à la création de la stratégie
	}
	
	public Strategie (Equipe _e1, Equipe _e2, TypeStrategie _ts)
	{
		this.eq1 = _e1 ;
		this.eq2 = _e2 ;
		this.typeS = _ts ;
		this.tempsActuel = 0; // Temps à 0 à la création de la stratégie
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
	
	public int getTA ()
	{
		return this.tempsActuel;
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
	
	public void setTA (int _tempsActuel)
	{
		this.tempsActuel = _tempsActuel;
	}
	
	// Accesseurs
	
	public Joueur getJoueurEq1 (int _i)
	{
		return this.eq1.getJoueur(_i) ;
	}
	
	public Joueur getJoueurEq2 (int _i)
	{
		return this.eq2.getJoueur(_i) ;
	}
	
	public Equipe getEquipeNum (int _i)
	{
		if (_i == 1)
			return this.eq1 ;
		else if (_i == 2)
			return this.eq2 ;
		else
			return null ;
	}
	
}

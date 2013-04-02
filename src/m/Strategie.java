package m;

import java.awt.Color;

public class Strategie implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	private Equipe eq1, eq2 ;
	private Element ballon;
	private TypeStrategie typeS ;
	private int tempsActuel;
	
	// Constructeurs
	
	public Strategie ()
	{
		// Il est nécessaire de remplir les équipes au début, sinon tous les joueurs sont à NULL.
		
		Joueur e1[] = new Joueur[6];
		Joueur e2[] = new Joueur[6];
		
		// Joueurs équipe 1
		e1[0] = new Joueur("JE", "Jean", new m.Position("C5", Orientation.HAUT));
		e1[0].setMeneur(true);
		e1[1] = new Joueur("MA", "Marie", new m.Position("F5", Orientation.HAUT));
		e1[2] = new Joueur("PH", "Philippe", new m.Position("I5", Orientation.HAUT));
		e1[3] = new Joueur("NA", "Nathalie", new m.Position("C2", Orientation.HAUT));
		e1[4] = new Joueur("MI", "Michel", new m.Position("F2", Orientation.HAUT));
		e1[5] = new Joueur("IS", "Isabelle", new m.Position("I2", Orientation.HAUT));
		
		// Joueurs équipe 2
		e2[0] = new Joueur("AL", "Alain", new m.Position("C14", Orientation.BAS));
		e2[0].setMeneur(true);
		e2[1] = new Joueur("SY", "Sylvie", new m.Position("F14", Orientation.BAS));
		e2[2] = new Joueur("PA", "Patrick", new m.Position("I14", Orientation.BAS));
		e2[3] = new Joueur("CA", "Catherine", new m.Position("C17", Orientation.BAS));
		e2[4] = new Joueur("NI", "Nicolas", new m.Position("F17", Orientation.BAS));
		e2[5] = new Joueur("MA", "Martine", new m.Position("I17", Orientation.BAS));

		this.eq1 = new Equipe(e1) ;
		this.eq2 = new Equipe(e2) ;
		this.ballon = new Element(true, Color.YELLOW, new m.Position("F6", Orientation.AUCUNE));
		
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
	
	public Element getBallon()
	{
		return this.ballon;
	}
	
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
	
	/**
	 * Retourne le nombre de temps traité dans la stratégie.
	 * @return Le nombre de temps traité.
	 * Tips : soustraire 1 pour obtenir l'indice du dernier temps.
	 */
	public int getNbTemps ()
	{
		return (this.eq1.getJoueur(0).getNbDeplacements()) ;
		/* 
		 * Fonctionnement : les joueurs de la startégie ont tous le même nombre de temps traités, quelque soit leur équipe.
		 * Ceci est géré dans la classe ControleurVueEdition.
		 */
	}
}

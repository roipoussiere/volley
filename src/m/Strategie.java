package m;

import java.awt.Color;

import c.ControleurPrincipal;

public class Strategie implements java.io.Serializable
{
	/**
	 * 
	 */
	private ControleurPrincipal cp;
	private Equipe eq1, eq2 ;
	private Element ballon;
	private TypeStrategie typeS ;
	private int tempsActuel;
	
	// Constructeurs
	
	public Strategie (ControleurPrincipal _cp)
	{
		this.cp = _cp;
		// Il est nécessaire de remplir les équipes au début, sinon tous les joueurs sont à NULL.
		// À remplacer par les valeurs dans Parametres()
		
		Joueur e1[] = new Joueur[6];
		Joueur e2[] = new Joueur[6];
		
		e1[0] = cp.getP().getJE1(0);
		e1[0].setMeneur(true);
		e2[0] = cp.getP().getJE2(0);
		e2[0].setMeneur(true);
		
		for (int i = 1 ; i<6 ; i++)
		{
			e1[i] = cp.getP().getJE1(i);
			e2[i] = cp.getP().getJE2(i);
		}
		
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

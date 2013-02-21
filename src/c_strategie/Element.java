package c_strategie;

import c.Parametres;
import java.awt.Color;

/**
 * L'élement 0 est le ballon,<br/>
 * L'élement 1 est le meneur de la 1ere équipe,<br/>
 * Les élements 2 à 6 sont les autres joueurs de la 1ere équipe,<br/>
 * L'élement 7 est le meneur de la 2eme équipe,<br/>
 * Les élements 8 à 12 sont les autres joueurs de la 2eme équipe.<br/>
 * @author Nathanaël Jourdane
 */
public class Element
{
	private Ensemble e;
	
	private int id;
	private boolean etat;
	private String nom;
	private Color couleur;
	
	public Element(Ensemble _e, int _i)
	{
		this.e = _e;
		Parametres param = this.e.getC().getP();
		
		this.id = _i;
		this.etat = param.getEtatE(_i);
		this.nom = param.getNomE(_i);
		this.couleur = param.getCoulE(_i);
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public boolean getEtat()
	{
		return this.etat;
	}
	
	public String getNom()
	{
		return this.nom;
	}

	public Color getCoul()
	{
		return this.couleur;
	}
	
	/**
	 *
	 * @return
	 */
	@Override
	public String toString()
	{
		String etat = "désactivé";
		if (this.getEtat()) {
			etat = "activé";
		}
		return "Élément n°" + this.id + " : " + this.getNom() + " - " + etat;
	}
}

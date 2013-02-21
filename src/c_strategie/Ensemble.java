package c_strategie;

import c.Controleur;

/**
 * Représente les 2 équipes et le ballon.
 * @author Nathanaël Jourdane
 */
public class Ensemble
{
	private static final int nbJ = 6; // Nombre de joueurs par équipe
	private static final int nbEl = nbJ*2 + 1; // Nombre d'élements (2 équipes + 1  ballon)
	
	Element tabEls[] = new Element[nbEl]; // Crée tous les elements
	private Controleur c;
	
	public Ensemble(Controleur _c)
	{
		this.c = _c;
		for (int i=0 ; i<nbEl ; i++) {
			tabEls[i] = new Element(this, i);
		}
	}
	
	public void afficher()
	{
		for (int i=0 ; i<nbEl ; i++)
		{
			System.out.println(tabEls[i]);
		}
	}
	
	/**
	 * Getter de la stratégie.
	 * @return La stratégie.
	 */
	public Controleur getC()
	{
		return this.c;
	}
	
	/**
	 * Getter du tableau d'éléments.
	 * @return Le tableau d'éléments.
	 */
	public Element getEl(int _idEl)
	{
		return this.tabEls[_idEl];
	}
	
	/**
	 * Getter du ballon
	 * @return Le ballon.
	 */
	public Element getBallon()
	{
		return this.tabEls[0];
	}

	/**
	 * Getter d'un joueur de la 1ere équipe.
	 * @param _idJ L'identifiant du joueur de la 1ere équipe (entre 0 et 5).<br/>
	 * L'id 0 correspond au meneur.
	 * @return Un joueur de la 1ere équipe.
	 */
	public Element getJE1(int _idJ)
	{
		return this.tabEls[_idJ+1];
	}

	/**
	 * Getter d'un joueur de la 2eme équipe.
	 * @param _idJ L'identifiant du joueur de la 2eme équipe (entre 0 et 5).<br/>
	 * L'id 0 correspond au meneur.
	 * @return Un joueur de la 2eme équipe.
	 */
	public Element getJE2(int _idJ)
	{
		return this.tabEls[_idJ+1+nbJ];
	}
	
	public int getNbJ()
	{
		return this.nbJ;
	}
	
	public int getNbEl()
	{
		return this.nbEl;		
	}
}
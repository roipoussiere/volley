package c_strategie;

import c.Controleur;

/**
 * Représente les 2 équipes et le ballon.
 * @author Nathanaël Jourdane
 */
public class Ensemble
{
	Element tabEls[] = new Element[13]; // crée les 13 elements : 2 équipe de 6 joueurs et un ballon.
	private Controleur c;
	
	public Ensemble(Controleur _c)
	{
		this.c = _c;
		for (int i=0 ; i<13 ; i++) {
			tabEls[i] = new Element(this, i);
		}
	}
	
	public void afficher()
	{
		for (int i=0 ; i<13 ; i++)
		{
			System.out.println(tabEls[i]);
		}
	}
	
	/**
	 * Getter du contrôleur.
	 * @return Le contrôleur.
	 */
	public Controleur getC()
	{
		return this.c;
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
		return this.tabEls[_idJ+7];
	}
}
package m;

import java.util.Vector;

/**
 * Classe représentant les equipes des joueurs.
 * @author Xavier Chalut
 */

public class Equipe {

	private Vector<Joueur> vecJ;
	
	Equipe()
	{
		vecJ = new Vector<Joueur>();
	}
	
	public Vector<Joueur> getJoueurs()
	{
		return this.vecJ;
	}
}

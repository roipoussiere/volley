package c;

import m.Joueur;
import m.Strategie;
import m.Position;
import m.Equipe;
import v_vues.Vue_Edition;

/**
 * Contrôleur de la vue Édition.
 * @author Florian
 */
public class ControleurVueEdition
{
	private Vue_Edition ve ;
	private Strategie str ;

	/**
	 * Création du constructeur.
	 * @param _ve La Vue_Edition liée
	 * @param _str La Strategie liée
	 */
	public ControleurVueEdition (Vue_Edition _ve, Strategie _str)
	{
		this.ve = _ve ;
		this.str = _str ;
	}
	
	
	// Getters
	
	public Vue_Edition getVueEdition ()
	{
		return this.ve ;
	}
	
	public Strategie getStrategie ()
	{
		return this.str ;
	}
		
	
	// Modificateurs

	/**
	 * Ajoute le déplacement d'un joueur à un nouveau temps.
	 * Initilise les déplacements de tous les autres joueurs à leur position précédente.
	 * @param _eq Equipe traitée.
	 */
	public void ajouterDeplacement (Joueur _j, Position _pos)
	{
		// On ajoute le nouveau déplacement
		_j.ajouterNouveauDeplacement(_pos) ;
		// On met à jour l'affichage de la fenêtre Vue_Edition
		this.ve.majVueEdition() ;
	}
	
	
	// Méthodes annexes
	
	
	// Méthodes utilisées pour les tests (A SUPPRIMER !)
	
	private void afficherDeplacementEquipeAuTemps (Equipe _eq, int _tps)
	{
		System.out.println("<test_flo> Déplacements au temps " + _tps + " : ") ;
		for (int i = 0 ; i < _eq.getEquipe().length ; i++)
		{
			System.out.println("<test_flo> Joueur " + (i+1) + " : " + _eq.getJoueur(i).getDeplacementAuTemps(_tps)) ;
		}
	}
}
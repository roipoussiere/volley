package c;

import javax.swing.JOptionPane;

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
	private ControleurPrincipal cp;
	private Vue_Edition ve;

	/**
	 * Création du constructeur.
	 * @param _ve La Vue_Edition liée
	 * @param _str La Strategie liée
	 */
	public ControleurVueEdition (ControleurPrincipal _cp)
	{
		// Récupération du controleur principal
		this.cp = _cp;
	
		// Ouverture de la fenêtre.
		this.ve = new Vue_Edition(this);
	}


	// Getters

	public Vue_Edition getVueEdition ()
	{
		return this.ve ;
	}

	public Strategie getStrategie ()
	{
		return this.cp.getS() ;
	}


	// Modificateurs
	
	public void creerNouveauTemps ()
	{
		Joueur joueurEq1, joueurEq2 ;
		int tpsEnCours = this.cp.getS().getTA() ;
		
		// On crée un nouveau temps dans le vector de déplacement de chaque joueur de chaque équipe
		for (int i = 0 ; i < this.cp.getS().getEq1().getNbJoueur() ; i++)
		{
			// On initialise les déplacements des joueurs à ceux du temps précédent
			joueurEq1 = this.cp.getS().getEq1().getJoueur(i) ;
			joueurEq1.ajouterNouveauDeplacement(joueurEq1.getDeplacementAuTemps(tpsEnCours - 1)) ;
			
			joueurEq2 = this.cp.getS().getEq2().getJoueur(i) ;
			joueurEq2.ajouterNouveauDeplacement(joueurEq2.getDeplacementAuTemps(tpsEnCours - 1)) ;
		}
	}

	public void saisirDeplacement (Equipe _eq, Joueur _j, Position _pos, int _tps)
	{
		if (!estPositionOccupee(_eq, _pos, _tps))
		{
			// Si le déplacement de ce joueur à ce temps est saisi pour la première fois
			if (_tps == _j.getVectorDeplacement().size()) // si _tps est le prochain indice du vector de déplacement à remplir
			{
				// On ajoute le nouveau déplacement
				_j.ajouterNouveauDeplacement(_pos) ; // QUESTION : utilisé que pour le premier déplacement ?
			}
			else
			{
				// On remplace le déplacement déjà présent
				_j.majDeplacementAuTemps(_tps, _pos) ;
			}

			// On met à jour l'affichage de la fenêtre Vue_Edition
			this.ve.majVueEdition() ;
		}
	}


	// Méthodes annexes

	private boolean estPositionOccupee (Equipe _eq, Position _pos, int _tps)
	{
		for (int i = 0 ; i < _eq.getNbJoueur() ; i++)
		{
			if (_eq.getJoueur(i).getDeplacementAuTemps(_tps).equals(_pos))
			{
				JOptionPane.showMessageDialog (this.ve, "Cette position est déjà occupée par " + _eq.getJoueur(i).getNomJ() + ".", null, JOptionPane.ERROR_MESSAGE) ;
				return true ;
			}	
		}

		return false ;
	}


	// Méthodes utilisées pour les tests (A SUPPRIMER !)

	private void afficherDeplacementEquipeAuTemps (Equipe _eq, int _tps)
	{
		System.out.println("<test_flo> Déplacements au temps " + _tps + " : ") ;
		for (int i = 0 ; i < _eq.getEquipe().length ; i++)
		{
			System.out.println("<test_flo> Joueur " + (i+1) + " : " + _eq.getJoueur(i).getDeplacementAuTemps(_tps)) ;
		}
	}


	public void majVue()
	{
		// À compléter
	}
}
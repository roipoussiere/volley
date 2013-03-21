package c;

import javax.swing.JOptionPane;
import m.*;
import v_vues.Vue_Edition;

/**
 * Contrôleur de la vue Édition.
 * @author Florian
 */
public class ControleurVueEdition
{
	// Constantes indiquants les limites du quadrillage
	// A REMPLACER AVEC LES VALEURS OBTENUES DEPUIS LA CLASSE TERRAIN
	private final char MINIMUM_ABSCISSE = 'A' ;
	private final char MAXIMUM_ABSCISSE = 'I' ;
	private final char MINIMUM_ORDONNEE = '0' ;
	private final char MAXIMUM_ORDONNEE = '9' ;

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

	public void enregistrerDeplacements (Equipe _eq, int _tps)
	{
		String depSaisie ; // contient le déplacement saisi
		boolean ok = true ; // évalue la condition d'enregistrement
		int i = 0 ; // indice de parcours
		
		// On vérifie d'abord que chaque champ de saisie est valide
		while (i < _eq.getNbJoueur() && ok)
		{
			depSaisie = this.ve.getSaisieDeplacementJ(i).getDepActuel().getText() ;
			if (depSaisie.isEmpty())
			{
				// Si le champ de saisie est vide, on le complète avec le déplacement précédent
				this.ve.getSaisieDeplacementJ(i).getDepActuel().setText(this.ve.getSaisieDeplacementJ(i).getDepPrec().getText()) ;
			}
			else
			{
				if (!controlerFormatSaisie(depSaisie) || !estPositionLibre(_eq, _eq.getJoueur(i), new Position (depSaisie), _tps))
				{
					// Sinon, on vide le champ et on place le curseur à l'intérieur
					this.ve.getSaisieDeplacementJ(i).getDepActuel().setText("") ;
					this.ve.getSaisieDeplacementJ(i).getDepActuel().requestFocus() ;
					ok = false ;
				}
			}
			
			i++ ;
		}
		
		if (ok)
		{
			// Si tous les champs de saisie sont valides, on enregistre les déplacements
			for (i = 0 ; i < _eq.getNbJoueur() ; i++)
			{
				// On récupère le champ de saisie du déplacement
				depSaisie = this.ve.getSaisieDeplacementJ(i).getDepActuel().getText() ;
				_eq.getJoueur(i).majDeplacementAuTemps(_tps, new Position (depSaisie, (Orientation) this.ve.getSaisieDeplacementJ(i).getListeOrientation().getSelectedItem())) ;
			}
		}
	}
	
	
	// Mise à jour de la vue
	
	public void majVue ()
	{
		this.ve.majVueEdition() ;
	}


	// Méthodes annexes

	private boolean estPositionLibre (Equipe _eq, Joueur _j, Position _pos, int _tps)
	{
		for (int i = 0 ; i < _eq.getNbJoueur() ; i++)
		{
			if (!_eq.getJoueur(i).equals(_j)) // on évite de comparer au joueur lui-même
			{
				if (_eq.getJoueur(i).getDeplacementAuTemps(_tps).getPosX() == _pos.getPosX() && _eq.getJoueur(i).getDeplacementAuTemps(_tps).getPosY() == _pos.getPosY())
				{
					JOptionPane.showMessageDialog (this.ve, "Cette position est déjà occupée par " + _eq.getJoueur(i).getNomJ() + ".", null, JOptionPane.ERROR_MESSAGE) ;
					return false ;
				}	
			}
		}

		return true ;
	}


	/**
	 * Contrôle si la saisie passée en paramètre est conforme aux normes ou pas
	 * @param _saisie Le contenu du champs de saisie à contrôler.
	 * @return TRUE si la saisie est conforme aux normes, FALSE sinon.
	 */
	private boolean controlerFormatSaisie (String _saisie)
	{
		if (_saisie.length() > 2) // Si la saisie est trop longue
		{
			JOptionPane.showMessageDialog (this.ve, "Saisie incorrecte !\nUn maxixum de 2 caractères est attendu.", null, JOptionPane.ERROR_MESSAGE) ;
		}
		else if (_saisie.charAt(0) < MINIMUM_ABSCISSE || _saisie.charAt(0) > MAXIMUM_ABSCISSE) // Si le premier caractère n'est pas une abscisse répertoriée
		{
			JOptionPane.showMessageDialog (this.ve, "Saisie incorrecte !\nLe premier caractère doit être une lettre.", null, JOptionPane.ERROR_MESSAGE) ;
		}
		else if (_saisie.charAt(1) < MINIMUM_ORDONNEE || _saisie.charAt(1) > MAXIMUM_ORDONNEE) // Si le second caractère n'est pas une ordonnée répertoriée
		{
			JOptionPane.showMessageDialog (this.ve, "Saisie incorrecte !\nLe second caractère doit être un chiffre.", null, JOptionPane.ERROR_MESSAGE) ;
		}
		else
		{
			return true ;
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
}
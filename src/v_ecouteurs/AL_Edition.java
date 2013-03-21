package v_ecouteurs;

import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import m.Joueur;
import m.Position;
import m.Equipe;

import v_vues.Vue_Edition;

/**
 * ActionListener des boutons de l'onglet Edition
 * @author Florian Garnier
 */
public class AL_Edition implements ActionListener, DocumentListener
{
	// Constantes indiquants les limites du quadrillage
	// A REMPLACER AVEC LES VALEURS OBTENUES DEPUIS LA CLASSE TERRAIN
	private final char MINIMUM_ABSCISSE = 'A' ;
	private final char MAXIMUM_ABSCISSE = 'I' ;
	private final char MINIMUM_ORDONNEE = '1' ;
	private final char MAXIMUM_ORDONNEE = '9' ;

	private Vue_Edition ve;

	/**
	 * Constructeur de l'ActionListener.
	 * @param _ve Vue d'Edition d'une stratégie.
	 */
	public AL_Edition(Vue_Edition _ve)
	{
		this.ve = _ve;
	}

	/**
	 * Ecoute les actions effectués sur les composants de la fenêtre.
	 * @param _ae Evenement.
	 */
	@Override
	public void actionPerformed (ActionEvent _ae)
	{
		// Clic sur le bouton "Temps précédent"
		if (_ae.getSource().equals(this.ve.getSelecTps().getButtonTpsPrecedent()))
		{
			// On appelle le listener intégré dans SelectionTemps
			this.ve.getSelecTps().actionPerformed(_ae) ;
			// On met à jour le temps actuel dans Strategie
			this.ve.getC().getStrategie().setTA(this.ve.getSelecTps().getTempsSelectionne()) ;
			// On met à jour l'affichage de la fenêtre
			this.ve.majVueEdition() ;
		}

		// Clic sur le bouton "Temps suivant"
		if (_ae.getSource().equals(this.ve.getSelecTps().getButtonTpsSuivant()))
		{
			// On appelle le listener intégré dans SelectionTemps
			this.ve.getSelecTps().actionPerformed(_ae) ;
			System.out.println("<test_flo> Temps en cours : " + this.ve.getSelecTps().getTempsSelectionne()) ;
			// Si le temps affiché n'existe pas encotre dans la stratégie, on le crée
			if (this.ve.getSelecTps().getTempsSelectionne() >= this.ve.getC().getStrategie().getNbTemps())
				this.ve.getC().creerNouveauTemps() ;
			// On met à jour le temps actuel dans Strategie
			this.ve.getC().getStrategie().setTA(this.ve.getSelecTps().getTempsSelectionne()) ;
			// On met à jour l'affichage de la fenêtre
			this.ve.majVueEdition() ;
		}
	}

	@Override
	public void changedUpdate (DocumentEvent e) {}

	@Override
	public void insertUpdate (DocumentEvent e)
	{
		if (e.getDocument().getLength() >= 2)
		{
			// On récupère le numéro du joueur concerné par le changement
			int numJ = 0 ;
			for (int i = 0 ; i < this.ve.getDeplacementJ().length ; i++)
			{
				if (e.getDocument() == this.ve.getSaisieDeplacementJ(i).getDepActuel().getDocument())
					numJ = i ;
			}

			// On récupère le contenu du champ de saisie
			String saisie = this.ve.getSaisieDeplacementJ(numJ).getDepActuel().getText() ;
			System.out.println("<test_flo> Saisie brute : " + saisie) ;

			// On formate le champ de saisie (minuscule --> majuscule)
			saisie = saisie.toUpperCase() ;
			System.out.println("<test_flo> Saisie en majuscule : " + saisie) ;

			if (controlerFormatSaisie(saisie))
			{
				System.out.println("<test_flo> Saisie OK") ;

				// On convertit la saisie en position
				Position pos = new Position(saisie) ;
				// On récupère l'équipe concernée (pour récupérer le joueur...)
				Equipe eq = this.ve.getC().getStrategie().getEquipeNum(this.ve.getNumEquipeSelec()) ;
				// On appelle la méthode du contrôleur pour ajouter le déplacement
				this.ve.getC().saisirDeplacement(eq, eq.getJoueur(numJ), pos, this.ve.getSelecTps().getTempsSelectionne()) ;
			}
		}
	}

	@Override
	public void removeUpdate (DocumentEvent e)
	{
		System.out.println("remove");

	}


	// Méthodes annexes

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
}
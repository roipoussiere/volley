package v_ecouteurs;

import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import m.Position;

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
		}

		// Clic sur le bouton "Temps suivant"
		if (_ae.getSource().equals(this.ve.getSelecTps().getButtonTpsSuivant()))
		{
			// On appelle le listener intégré dans SelectionTemps
			this.ve.getSelecTps().actionPerformed(_ae) ;
			// On désactive le bouton "Temps suivant" jusqu'au remplissage d'au moins 1 champ de déplacement
			if (estChampVide())
				this.ve.getSelecTps().getButtonTpsSuivant().setEnabled(false) ;
		}
	}

	@Override
	public void changedUpdate (DocumentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertUpdate (DocumentEvent e)
	{
		if (e.getDocument().getLength() >= 2)
		{
			try 
			{
				String saisie = e.getDocument().getText(0, e.getDocument().getLength()) ;
				System.out.println("<test_flo> Saisie brute : " + saisie) ;
				
				// On formate le champ de saisie (minuscule --> majuscule)
				saisie = saisie.toUpperCase() ;
				System.out.println("<test_flo> Saisie en majuscule : " + saisie) ;
				
				if (controlerFormatSaisie(saisie))
				{
					System.out.println("<test_flo> Saisie OK") ;
					
					// On appelle la méthode de MAJ du contrôleur en passant en paramètre la position saisie
					if (this.ve.getListEquipe().getSelectedIndex() == 0)
					{
						// Si on travaille sur la première équipe...
						this.ve.getC().ajouterDeplacementE1() ;
					}
					else
					{
						// Si on travaille sur la deuxième équipe...
						this.ve.getC().ajouterDeplacementE2() ;
					}
				}
				else
				{
					// On supprime le contenu du champ de saisie
				}
			}
			catch (BadLocationException e2)
			{
				e2.printStackTrace() ;
			}
		}
	}

	@Override
	public void removeUpdate (DocumentEvent e) {
		// TODO Auto-generated method stub

	}
	
	
	// Méthodes annexes
	
	private boolean estChampVide ()
	{
		boolean ok = true ;
		int i = 0 ;
		
		while (ok && i < this.ve.getDeplacementJ().length)
		{
			if (! this.ve.getSaisieDeplacementJ(i).getDepActuel().getText().isEmpty())
				ok = false ;
			
			i++ ;
		}
		
		return ok ;
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
}
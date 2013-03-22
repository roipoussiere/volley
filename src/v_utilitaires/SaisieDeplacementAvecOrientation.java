package v_utilitaires;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import m.Orientation;

@SuppressWarnings("serial")
public class SaisieDeplacementAvecOrientation extends SaisieDeplacement
{
	private JComboBox listeOrientation ;

	public SaisieDeplacementAvecOrientation (String _nomJ, int _numJ)
	{
		super(_nomJ, _numJ) ;

		GridBagConstraints gbc = new GridBagConstraints () ;
		
		// Création de la liste de sélection de l'orientation
		this.listeOrientation = new JComboBox (new Orientation[] {Orientation.AUCUNE, Orientation.GAUCHE, Orientation.BAS, Orientation.DROITE, Orientation.HAUT}) ;
		gbc.gridx = 3 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 10, 0, 10) ;
		this.add (this.listeOrientation, gbc) ;
	}
	
	public JComboBox getListeOrientation ()
	{
		return this.listeOrientation ;
	}
}

package v_utilitaires;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import m.Orientation;

@SuppressWarnings("serial")
public class SaisieDeplacementAvecOrientation extends SaisieDeplacement
{
	private JComboBox listeOrientation ;

	public SaisieDeplacementAvecOrientation (String _nomJ)
	{
		super(_nomJ) ;

		GridBagConstraints gbc = new GridBagConstraints () ;
		
		// Création de la liste de sélection de l'orientation
		this.listeOrientation = new JComboBox (new Orientation[] {Orientation.GAUCHE, Orientation.BAS, Orientation.DROITE, Orientation.HAUT}) ;
		gbc.gridx = 3 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 10, 0, 10) ;
		this.add (this.listeOrientation, gbc) ;
	}
	
	public SaisieDeplacementAvecOrientation (String _nomJ, String _idJ)
	{
		this(_nomJ) ;
		this.infoJ.setText(_nomJ + " (" + _idJ + ")") ;
	}
	
	public JComboBox getListeOrientation ()
	{
		return this.listeOrientation ;
	}
}

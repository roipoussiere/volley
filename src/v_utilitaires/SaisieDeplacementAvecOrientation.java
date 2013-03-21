package v_utilitaires;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import m.Orientation;

public class SaisieDeplacementAvecOrientation extends SaisieDeplacement
{
	private static final long serialVersionUID = 1L;
	private JComboBox<Orientation> listeOrientation ;

	public SaisieDeplacementAvecOrientation (String _nomJ)
	{
		super(_nomJ) ;

		GridBagConstraints gbc = new GridBagConstraints () ;
		
		// Création de la liste de sélection de l'orientation
		this.listeOrientation = new JComboBox<Orientation> (new Orientation[] {Orientation.GAUCHE, Orientation.BAS, Orientation.DROITE, Orientation.HAUT}) ;
		gbc.gridx = 3 ; gbc.gridy = 0 ;
		gbc.gridwidth = 1 ; gbc.gridheight = 1 ;
		gbc.anchor = GridBagConstraints.LINE_START ;
		gbc.insets = new Insets (0, 10, 0, 10) ;
		this.add (this.listeOrientation, gbc) ;
	}
	
	public JComboBox<Orientation> getListeOrientation ()
	{
		return this.listeOrientation ;
	}
}

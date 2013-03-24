package v_vues;

import c.ControleurVueDessin;
import c.ControleurVueTerrain;
import java.awt.event.*;
import javax.swing.*;

/**
 * Vue de la fenêtre représentant le terrain de volley.
 * @author Nathanaël Jourdane
 */
@SuppressWarnings("serial")
public class Vue_Terrain extends JFrame implements WindowListener
{
	private ControleurVueTerrain cvt;
	private ControleurVueDessin cvd;
	
	/**
	 * Création de la fenêtre représentant le terrain de volley.
	 * @param _c Le contrôleur.
	 */
	public Vue_Terrain(ControleurVueTerrain _cvt, ControleurVueDessin _cvd)
	{
		super ();
		this.cvt = _cvt;
		this.cvd = _cvd;
		this.addWindowListener(this); // On abonne la fenêtre à elle-même.
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		
		this.setContentPane(this.cvd.getVD());
	}
	
	/**
	 * Dessine le quadrillage sur le terrain, qui varie en fonction du mode Lecture ou Edition.
	 * @param _styleQ Le style de quadrillage du terrain
	 */
	public void dessiner(int _styleQ)
	{
		this.cvd.setStyleQ(_styleQ);
		this.cvd.getVD().repaint();
	}
	
	/**
	 * 
	 */
	public void setTaille(boolean _demiT)
	{
		// Si demi-terrain : zone de 11*10 cases de 50px chacune = 550*500 + bordures de la fenêtre
		if (_demiT) {	
			this.setSize(577, 593);
			System.out.println("Redimentionnement en demi-terrain.");
		}
		else {
			this.setSize(412, 743);
			System.out.println("Redimentionnement en terrain complet.");
		}
	}
		
	/**
	 * Getter du contrôleur.
	 * @return Le contrôleur.
	 */
	public ControleurVueTerrain getCVT()
	{
		return this.cvt;
	}
	
	/**
	 * Action qui suit la fermeture de la fenêtre.
	 * @param arg0 L'évenement de clic sur le bouton de fermeture de la fenêtre.
	 */
	@Override
	public void windowClosing(WindowEvent arg0)
	{
		this.getCVT().quitter();
	}
	
	// Ces méthodes sont les autres évenements possibles sur la fenêtre, que nous utilisons pas.
	@Override
	public void windowActivated(WindowEvent arg0) {}
	@Override
	public void windowClosed(WindowEvent arg0) {}
	@Override
	public void windowDeactivated(WindowEvent arg0) {}
	@Override
	public void windowDeiconified(WindowEvent arg0) {}
	@Override
	public void windowIconified(WindowEvent arg0) {}
	@Override
	public void windowOpened(WindowEvent arg0) {}
}
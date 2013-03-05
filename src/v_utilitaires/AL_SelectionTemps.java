package v_utilitaires;

import java.awt.event.*;

/**
 * ActionListener des boutons de l'onglet Edition
 * @author Nathanael Jourdane
 */
public class AL_SelectionTemps implements ActionListener
{
	private SelectionTemps st;

	/**
	 * Constructeur de l'ActionListener.
	 * @param _st Selecteur de temps.
	 */
	public AL_SelectionTemps(SelectionTemps _st)
	{
		this.st = _st;
	}

	/**
	 * Ecoute les actions effectués sur les composants de la fenêtre.
	 * @param _ae Evenement.
	 */
	@Override
	public void actionPerformed (ActionEvent _ae)
	{
    int ta = this.st.getStrategie().getTA();
    
    // Clic sur le bouton "Temps précédent"
		if (_ae.getSource().equals(this.st.getBPPrecedent()))
		{
			if (ta > 0) {
        ta-- ;
      }
      
		}
		
		// Clic sur le bouton "Temps suivant"
		if (_ae.getSource().equals(this.st.getBPSuivant()))
    { 
			if (ta < this.st.getStrategie().getTMax()) {
        ta++ ;
      }
		}
    
    // Mise à jour du temps actuel
    this.st.getStrategie().setTA(ta);
    
    //Mise à jour du composant
    this.st.majSelectionTemps();
	}
}
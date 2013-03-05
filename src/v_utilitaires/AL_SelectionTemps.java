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
    int tmpMax = 3; // À modifier
    
    // Clic sur le bouton "Temps précédent"
		if (_ae.getSource().equals(this.st.getBPPrecedent()))
		{
      // On réactive le bouton "Temps suivant" si on était au temps max
      if (ta == tmpMax) {
				this.st.activerBPSuivant(true);
			}
      
			if (ta > 0) {
        ta-- ;
      }
      
			// On désactive le bouton "Temps précédent" si on est au temps 0
      if (ta == 0) {
				this.st.activerBPPrecedent(false);
			}
		}
		
		// Clic sur le bouton "Temps suivant"
		if (_ae.getSource().equals(this.st.getBPSuivant()))
    { 
			if (ta < tmpMax) {
        ta++ ;
      }
      
			// On désactive le bouton "Temps précédent" si on est au temps 0
      if (ta == tmpMax) {
				this.st.activerBPPrecedent(false);
			}
		}

    // Mise à jour du temps dans la fenêtre
    this.st.getTemps().setText(Integer.toString(ta)) ;
    
    // Mise à jour du temps actuel
    this.st.getStrategie().setTA(ta);
	}
}
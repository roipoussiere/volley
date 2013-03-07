package c;

import m_alternatif.Strategie;
import v_vues.Vue_Edition;

/**
 * Contrôleur de la vue Édition.
 * @author Florian
 */
public class ControleurVueEdition
{
	private Vue_Edition ve ;
	private Strategie str ;

	/**
	 * Création du constructeur.
	 * @param _ve La Vue_Edition liée
	 * @param _str La Strategie liée
	 */
	public ControleurVueEdition (Vue_Edition _ve, Strategie _str)
	{
		this.ve = _ve ;
		this.str = _str ;
	}

	/**
	 * Met à jour le temps en cours de traitement dans la stratégie.
	 * @param _tpsTraite Le temps en cours de traitement.
	 */
	public void majStrategieE1 (int _tpsTraite)
	{
		
	}
}
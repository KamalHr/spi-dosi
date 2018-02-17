package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Formation;

public interface FormationBusiness {
	Formation creerFormation(Formation formationACreer);
	List<Formation> recupererToutesLesFormations();
	List<Formation> rechercheFormationParNom(String nom);
	List<Formation> rechercheFormationParNoFormation(String id);
	void supprimerFormationParCodeFormation(String id);
	void supprimerFormation(Formation formationASuppr);
}

package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Candidat;

public interface CandidatBusiness {
	Candidat creerCandidat(Candidat candidatACreer);
	void supprimerCandidat(Candidat candidatASuppr);
	void supprimerCandidat(String noCandidatASuppr);
	List<Candidat> rechercheCandidatParNom(String Nom);
	Candidat rechercheCandidatParID(String id);
	List<Candidat> rechercheCandidatParUniversite(String Universite);
	List<Candidat> recupererTousLesCandidats();
}
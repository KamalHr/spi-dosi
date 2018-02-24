package fr.univbrest.dosi.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.repository.CandidatRepository;

@Service
public class CandidatBusinessJPA implements CandidatBusiness {

	CandidatRepository candidatRepo;
	@Autowired
	public CandidatBusinessJPA(CandidatRepository repos) {
		this.candidatRepo = repos;
	}
	
	@Override
	public Candidat creerCandidat(Candidat candidatACreer) {
		candidatACreer.setDateReponseCandidat(new Date());
		return candidatRepo.save(candidatACreer);
	}

	@Override
	public void supprimerCandidat(Candidat candidatASuppr) {
		candidatRepo.delete(candidatASuppr);
	}

	@Override
	public List<Candidat> rechercheCandidatParNom(String nom) {
		return candidatRepo.findByNom(nom);
	}

	@Override
	public List<Candidat> rechercheCandidatParUniversite(String universiteOrigine) {
		return candidatRepo.findByUniversiteOrigine(universiteOrigine);
	}

	@Override
	public void supprimerCandidat(String noCandidatASuppr) {
		candidatRepo.delete(noCandidatASuppr);
	}

	@Override
	public List<Candidat> recupererTousLesCandidats() {
		return (List<Candidat>) candidatRepo.findAll();
	}

	@Override
	public Candidat rechercheCandidatParID(String id) {
		return candidatRepo.findOne(id);
	}

}

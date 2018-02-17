package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.repository.EnseignantRepository;

@Service
public class EnseignantBusinessJPA implements EnseignantBusiness {
	private EnseignantRepository enseignantRepo;
	
	@Autowired
	public EnseignantBusinessJPA(EnseignantRepository enseignantRepo) {
		this.enseignantRepo = enseignantRepo;
	}
	
	@Override
	public Enseignant creerEnseignant(Enseignant enseignantACreer) {
		return enseignantRepo.save(enseignantACreer);
	}

	@Override
	public void supprimerEnseignant(Enseignant EnseignantASuppr) {
		enseignantRepo.delete(EnseignantASuppr);
	}

	@Override
	public List<Enseignant> recupererTousLEsEnseignants() {
		return (List<Enseignant>) enseignantRepo.findAll();
	}

	@Override
	public List<Enseignant> recupererEnseignantParNom(String nom) {
		return enseignantRepo.findByNom(nom);
	}

	@Override
	public Enseignant recupererEnseignantParNoEnseignant(long noEnseignant) {
		return enseignantRepo.findByNoEnseignant(noEnseignant);
	}

	@Override
	public Enseignant recupererEnseignantParEmailUbo(String emailUbo) {
		return enseignantRepo.findByEmailUbo(emailUbo);
	}

}

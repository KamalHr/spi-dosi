package fr.univbrest.dosi.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repository.FormationRepository;

@Service
public class FormationBusinessJPA implements FormationBusiness {
	
	private FormationRepository formationRepo;
	
	@Autowired
	public FormationBusinessJPA(FormationRepository repos) {
		this.formationRepo = repos;
	}
	
	@Override
	public Formation creerFormation(Formation formationACreer) {
		formationACreer.setDebutAccreditation(new Date());
		return formationRepo.save(formationACreer);
	}
	
	@Override
	public List<Formation> recupererToutesLesFormations() {
		return (List<Formation>) formationRepo.findAll();
	}

	@Override
	public List<Formation> rechercheFormationParNom(String nom) {
		return formationRepo.findByNomFormation(nom);
	}

	@Override
	public List<Formation> rechercheFormationParNoFormation(String id) {
		// TODO Auto-generated method stub
		return formationRepo.findByCodeFormation(id);
	}

	@Override
	public void supprimerFormationParCodeFormation(String id) {
		formationRepo.delete(id);
	}

	@Override
	public void supprimerFormation(Formation formationASuppr) {
		formationRepo.delete(formationASuppr);
	}

}


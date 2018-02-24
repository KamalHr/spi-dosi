package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.business.EnseignantBusiness;

@RestController
@CrossOrigin(origins = "http://localhost:5500", maxAge = 3600)
@RequestMapping(value="/enseignants")
public class EnseignantController {
	
	private EnseignantBusiness enseignantBusiness;

	@Autowired
	public EnseignantController(EnseignantBusiness enseignantBusiness) {
		this.enseignantBusiness = enseignantBusiness;
	}

	@RequestMapping(method=RequestMethod.POST)
	public Enseignant creerEnseignant(@RequestBody Enseignant enseignantACreer) {
		return enseignantBusiness.creerEnseignant(enseignantACreer);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public void supprimerEnseignant(@RequestBody Enseignant EnseignantASuppr) {
		enseignantBusiness.supprimerEnseignant(EnseignantASuppr);
	}

	@RequestMapping(method=RequestMethod.GET)
	public List<Enseignant> recupererTousLEsEnseignants() {
		return enseignantBusiness.recupererTousLEsEnseignants();
	}

	@RequestMapping(method=RequestMethod.GET, value="/nom/{nom}")
	public List<Enseignant> recupererEnseignantParNom(@PathVariable String Nom) {
		return enseignantBusiness.recupererEnseignantParNom(Nom);
	}
	@RequestMapping(method=RequestMethod.GET, value="/{noEnseignant}")
	public Enseignant recupererEnseignantParNoEnseignant(@PathVariable long noEnseignant) {
		return enseignantBusiness.recupererEnseignantParNoEnseignant(noEnseignant);
	}

	@RequestMapping(method=RequestMethod.GET, value="/emailUbo/{emailUbo:.+}")
	public Enseignant recupererEnseignantParEmailUbo(@PathVariable String emailUbo) {
		System.out.println(emailUbo);
		return enseignantBusiness.recupererEnseignantParEmailUbo(emailUbo);
	}
	
}

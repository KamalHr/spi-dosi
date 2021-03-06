package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.business.FormationBusiness;

@RestController
@CrossOrigin(origins = "http://localhost:5500", maxAge = 3600)
@RequestMapping("/formations")
public class FormationController {

	FormationBusiness formationBusiness;
	
	@Autowired
	public FormationController(FormationBusiness business) {
		this.formationBusiness = business;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Formation creerFormation(@RequestBody Formation formation) {
		return formationBusiness.creerFormation(formation);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public void supprimerFormation(@RequestBody Formation formationASuppr) {
		formationBusiness.supprimerFormation(formationASuppr);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{codeFormation}")
	public void supprimerFormation(@PathVariable String codeFormation) {
		formationBusiness.supprimerFormationParCodeFormation(codeFormation);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Formation RecupererLaFormationAvecLeCodeFormation(@PathVariable String id) {
		System.out.println("getByID : "+id);
		return formationBusiness.rechercheFormationParNoFormation(id);
	}
	
	@RequestMapping( method=RequestMethod.GET)
	public List<Formation> recupererToutesLesFormations() {
		System.out.println("GetAll");
		return formationBusiness.recupererToutesLesFormations();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/nom/{nom}")
	public List<Formation> RecupererLaFormationAvecLeNom(@PathVariable String nom) {
		System.out.println("GetByNom: "+nom);
		return formationBusiness.rechercheFormationParNom(nom);
	}

	@RequestMapping(method = RequestMethod.PUT)
    public Formation miseAjourdeFormation(@RequestBody Formation formationAMettreAJour){
	    return formationBusiness.mettreAJourFormation(formationAMettreAJour);
    }
}

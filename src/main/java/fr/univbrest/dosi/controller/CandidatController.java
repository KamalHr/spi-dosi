package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.business.CandidatBusiness;

@RestController
@RequestMapping("/candidats")
public class CandidatController {
	private CandidatBusiness candidatBusiness;
	
	@Autowired
	public CandidatController(CandidatBusiness business) {
		this.candidatBusiness = business;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Candidat creerCandidat(@RequestBody Candidat candidat) {
		return candidatBusiness.creerCandidat(candidat);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Candidat> recupererTousLesCandidat(){
		return candidatBusiness.recupererTousLesCandidats();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public List<Candidat> recupererCandidatParID(@PathVariable String id) {
		return candidatBusiness.rechercheCandidatParID(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/nom/{nom}")
	public List<Candidat> recupererCandidatParNom(@PathVariable String nom){
		return candidatBusiness.rechercheCandidatParNom(nom);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/universite/{universite}")
	public List<Candidat> recupererCandidatParUniversite(@PathVariable String universite){
		return candidatBusiness.rechercheCandidatParUniversite(universite);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public void supprimerCandidat(@RequestBody Candidat candidatASuppr) {
		candidatBusiness.supprimerCandidat(candidatASuppr);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void supprimerCandidat(@PathVariable String id) {
		candidatBusiness.supprimerCandidat(id);
	}
}

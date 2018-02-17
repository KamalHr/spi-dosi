package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.business.PromotionBusiness;
import net.spy.memcached.tapmessage.RequestMessage;

@RestController
@RequestMapping(value="/promotions")
public class PromotionController {
	PromotionBusiness promotionBusiness;
	
	@Autowired
	public PromotionController(PromotionBusiness promotionBusiness) {
		super();
		this.promotionBusiness = promotionBusiness;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void creerPromotion(@RequestBody Promotion promotionACreer) {
		promotionBusiness.creerPromotion(promotionACreer);
	}
	@RequestMapping(method=RequestMethod.DELETE)
	public void supprimerFormation(@RequestBody Promotion promotionASuppr) {
		promotionBusiness.supprimerPromotion(promotionASuppr);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/{codeFormation}/{anneeUniversitaire}")
	public void supprimerFormation(@PathVariable String codeFormation, @PathVariable String anneeUniversitaire) {
		PromotionPK promotionPk = new PromotionPK();
		promotionPk.setAnneeUniversitaire(anneeUniversitaire);
		promotionPk.setCodeFormation(codeFormation);
		promotionBusiness.supprimerPromotion(promotionPk);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Promotion> recupererToutesLesPromotions() {
		return promotionBusiness.recupererToutesLesPromotions();
	}
	@RequestMapping(method=RequestMethod.GET, value="/sigle/{siglePromotion}")
	public List<Promotion> recupererPromotionParSigle(@PathVariable String siglePromotion) {
		return promotionBusiness.recupererPromotionParSigle(siglePromotion);
	}
	@RequestMapping(method=RequestMethod.GET, value="/{codeFormation}/{anneeUniversitaire}")
	public Promotion recupererPromotionParId(@PathVariable String codeFormation, @PathVariable String anneeUniversitaire) {
		PromotionPK promotionPk = new PromotionPK();
		promotionPk.setAnneeUniversitaire(anneeUniversitaire);
		promotionPk.setCodeFormation(codeFormation);
		return promotionBusiness.recupererPromotionParId(promotionPk);
	}

	@RequestMapping(method=RequestMethod.GET, value="/lieuRentree/{lieuRentree}")
	public List<Promotion> recupererPromotionParLieuRentree(@PathVariable String lieuRentree) {
		return promotionBusiness.recupererPromotionParLieuRentree(lieuRentree);
	}

	
}

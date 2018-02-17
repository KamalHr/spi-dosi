package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.repository.PromotionRepository;
@Service
public class PromotionBusinessJPA implements PromotionBusiness {
	
	PromotionRepository promotionRepo;
	
	@Autowired
	public PromotionBusinessJPA(PromotionRepository promotionRepo) {
		super();
		this.promotionRepo = promotionRepo;
	}

	@Override
	public Promotion creerPromotion(Promotion promotionACreer) {
		return promotionRepo.save(promotionACreer);
	}

	@Override
	public void supprimerPromotion(Promotion promotionASuppr) {
		promotionRepo.delete(promotionASuppr);
	}

	@Override
	public void supprimerPromotion(PromotionPK id) {
		promotionRepo.delete(id);
	}

	@Override
	public List<Promotion> recupererToutesLesPromotions() {
		return (List<Promotion>) promotionRepo.findAll();
	}

	@Override
	public List<Promotion> recupererPromotionParSigle(String siglePromotion) {
		return promotionRepo.findBySiglePromotion(siglePromotion);
	}

	@Override
	public Promotion recupererPromotionParId(PromotionPK id) {
		return promotionRepo.findOne(id);
	}

	@Override
	public List<Promotion> recupererPromotionParLieuRentree(String lieuRentree) {
		return promotionRepo.findByLieuRentree(lieuRentree);
	}

}

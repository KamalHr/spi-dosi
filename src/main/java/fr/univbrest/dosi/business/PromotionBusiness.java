package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;

public interface PromotionBusiness {
	public Promotion creerPromotion(Promotion promotionACreer);
	public void supprimerPromotion(Promotion promotionASuppr);
	public void supprimerPromotion(PromotionPK id);
	public List<Promotion> recupererToutesLesPromotions();
	public List<Promotion> recupererPromotionParSigle(String siglePromotion);
	public Promotion recupererPromotionParId(PromotionPK id);
	public List<Promotion> recupererPromotionParLieuRentree(String lieuRentree);
}

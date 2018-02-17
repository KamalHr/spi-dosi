package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.repository.PromotionRepository;

public class PromotionBusinessJPATest {
	private PromotionBusinessJPA promotionBusiness;

	private PromotionRepository promotionRepo;
	
	@Before
	public void setup() {
		Promotion promotion1 = new Promotion(new PromotionPK("2017-2018","M2DOSI"), "Micro 1.2", "DOSI10");
		Promotion promotion2 = new Promotion(new PromotionPK("2018-2019","M2DOSI"), "Micro 2.2", "DOSI11");
		
		List<Promotion> listePromotion = Lists.newArrayList();
		listePromotion.add(promotion1);
		listePromotion.add(promotion2);
		promotionRepo = new PromotionRepositoryList(listePromotion);
		promotionBusiness = new PromotionBusinessJPA(promotionRepo);
	}

	@Test
	public void creerPromotion() {
		Promotion promotionACreer = new Promotion(new PromotionPK("2016-2017","M2DOSI"), "Micro 2.2", "DOSI9");
		promotionBusiness.creerPromotion(promotionACreer);
		assertThat(promotionRepo.count()).isEqualTo(3);
	}
	
	@Test
	public void supprimerPromotion() {
		Promotion promotionASuppr = new Promotion(new PromotionPK("2017-2018","M2DOSI"), "Micro 1.2", "DOSI10");
		promotionBusiness.supprimerPromotion(promotionASuppr);
		assertThat(promotionRepo.count()).isEqualTo(1);
	}
	
	@Test
	public void recupererToutesLesPromotions() {
		List<Promotion> liste = promotionBusiness.recupererToutesLesPromotions();
		assertThat(liste).hasSize(2);
	}
	
	@Test
	public void recupererPromotionParSigle() {
		List<Promotion> liste = promotionBusiness.recupererPromotionParSigle("DOSI11");
		assertThat(liste).hasSize(1);
		assertThat(liste).extracting("lieuRentree").containsExactly("Micro 2.2");
	}
	
	@Test
	public void recupererPromotionParId() {
		PromotionPK id = new PromotionPK("2017-2018","M2DOSI");
		Promotion promotion = promotionBusiness.recupererPromotionParId(id);
		assertThat(promotion.getSiglePromotion()).matches("DOSI10");
	}
	
	@Test
	public void recupererPromotionParLieuRentree() {
		List<Promotion> liste = promotionBusiness.recupererPromotionParLieuRentree("Micro 2.2");
		assertThat(liste).hasSize(1);
		assertThat(liste).extracting("siglePromotion").containsExactly("DOSI11");
	}
	
}

class PromotionRepositoryList implements PromotionRepository{

	List<Promotion> data;
	
	public PromotionRepositoryList(List<Promotion> data) {
		super();
		this.data = data;
	}

	@Override
	public long count() {
		return data.size();
	}

	@Override
	public void delete(PromotionPK arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Promotion entity) {
		data = data.stream()
				.filter(element -> !element.equals(entity))
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Iterable<? extends Promotion> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(PromotionPK arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Promotion> findAll() {
		return data;
	}

	@Override
	public Iterable<Promotion> findAll(Iterable<PromotionPK> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Promotion findOne(PromotionPK arg0) {
		// TODO Auto-generated method stub
		return data.stream()
				.filter(element -> element.getId().equals(arg0))
				.collect(Collectors.toList()).get(0);
	}

	@Override
	public <S extends Promotion> S save(S entity) {
		data.add(entity);
		return entity;
	}

	@Override
	public <S extends Promotion> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Promotion> findBySiglePromotion(String siglePromotion) {
		return data.stream()
				.filter(element -> element.getSiglePromotion().matches(siglePromotion))
				.collect(Collectors.toList());
	}

	@Override
	public List<Promotion> findByLieuRentree(String lieuRentree) {
		return data.stream()
				.filter(element -> element.getLieuRentree().matches(lieuRentree))
				.collect(Collectors.toList());
	}
	
}
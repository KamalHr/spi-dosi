package fr.univbrest.dosi.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)
public class PromotionRepositoryTest {
	
	@Autowired
	private PromotionRepository promotionRepo;
	@Autowired
	private FormationRepository formationRepo;

	@Before
	public void setup() {
		Formation formation1 = new Formation("M2DOSI", null, "M2", "O", new Date(), BigDecimal.valueOf(2.0), "DOSI");
		formationRepo.save(formation1);
		Promotion promotion1 = new Promotion(new PromotionPK("2017-2018","M2DOSI"), "Micro 2.2", "DOSI10");
		Promotion promotion2 = new Promotion(new PromotionPK("2018-2019","M2DOSI"), "Micro 1.2", "DOSI11");
		promotionRepo.save(promotion1);
		promotionRepo.save(promotion2);
	}
	
	@Test
	public void doitCompterLesPromotion() {
		assertThat(promotionRepo.count()).isEqualTo(2);
	}

	@Test
	public void doitChercherParSiglePromotion() {
		List<Promotion> promotion = promotionRepo.findBySiglePromotion("DOSI11");
		assertThat(promotion).hasSize(1);
		assertThat(promotion).extracting("id").containsExactly(new PromotionPK("2018-2019","M2DOSI"));
	}

	@Test
	public void doitChercherParID() {
		Promotion promotion = promotionRepo.findOne(new PromotionPK("2017-2018","M2DOSI"));
		assertThat(promotion.getLieuRentree()).matches("Micro 2.2");
	}	
	
	@Test
	public void doitChercherParLieuRentree() {
		List<Promotion> promotion = promotionRepo.findByLieuRentree("Micro 2.2");
		assertThat(promotion).hasSize(1);
		assertThat(promotion).extracting("id").containsExactly(new PromotionPK("2017-2018","M2DOSI"));
	}
}

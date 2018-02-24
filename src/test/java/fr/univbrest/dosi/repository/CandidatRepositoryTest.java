package fr.univbrest.dosi.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.repository.CandidatRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class CandidatRepositoryTest {
	
	@Autowired
	CandidatRepository candidatRepo;
	
	@Before
	public void setup() {
		Candidat candidat1 = new Candidat("1","HOUREDDINE", "Kamal","UIZ");
		Candidat candidat2 = new Candidat("2","HAKKOU", "Meryem","UMP");
		candidatRepo.save(candidat1);
		candidatRepo.save(candidat2);
	}
	@Test
	public void doitCompterLesCandidats() {
		Long resultat = candidatRepo.count();
		assertThat(resultat).isEqualTo(2);
	}
	@Test
	public void doitRechercherParNom() {
		List<Candidat> resultat = candidatRepo.findByNom("HOUREDDINE");
		assertThat(resultat).hasSize(1);
		assertThat(resultat.get(0).getNom()).isEqualTo("HOUREDDINE");
		assertThat(resultat.get(0).getNoCandidat()).isEqualTo("1");
	}
	@Test
	public void doitRechercherParUniversiteOrigine() {
		List<Candidat> resultat = candidatRepo.findByUniversiteOrigine("UMP");
		assertThat(resultat).hasSize(1);
		assertThat(resultat.get(0).getNom()).isEqualTo("HAKKOU");
		assertThat(resultat.get(0).getNoCandidat()).isEqualTo("2");
	}
}

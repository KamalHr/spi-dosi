package fr.univbrest.dosi.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.bean.Enseignant;

@RunWith(SpringJUnit4ClassRunner.class)
public class EnseignantRepositoryTest {
	
	@Autowired
	private EnseignantRepository enseignantRepo;
	
	@Before
	public void setup() {
		Enseignant enseignant1 = new Enseignant(1, "29200", "philippe.saliou@univ-brest.fr", "SALIOU", "Philippe", "CHR");
		enseignantRepo.save(enseignant1);
	}
	
	@Test
	public void doitCompterLesEnseignants() {
		assertThat(enseignantRepo.count()).isEqualTo(1);
	}

	@Test
	public void doitChercherParNoEnseignant() {
		Enseignant enseignant = enseignantRepo.findByNoEnseignant(1);
		assertThat(enseignant.getNom()).matches("SALIOU");
	}

	@Test
	public void doitChercherParNom() {
		List<Enseignant> enseignant = enseignantRepo.findByNom("SALIOU");
		assertThat(enseignant).extracting("prenom").containsExactly("Philippe");
	}

	@Test
	public void doitChercherParEmailUbo() {
		Enseignant enseignant = enseignantRepo.findByEmailUbo("philippe.saliou@univ-brest.fr");
		assertThat(enseignant.getNom()).isEqualTo("SALIOU");
	}

	@Test
	public void doitChercherParNoEnseignant2() {
		Enseignant enseignant = enseignantRepo.findOne((long)1);
		assertThat(enseignant.getNom()).matches("SALIOU");
	}
	
	
}

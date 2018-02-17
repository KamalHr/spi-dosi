package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.repository.EnseignantRepository;

public class EnseignantBusinessJPATest {

	private EnseignantBusinessJPA enseignantBusiness;

	private EnseignantRepository enseignantRepo;
	
	@Before
	public void setup() {
		Enseignant enseignant1 = new Enseignant(1, "29200", "philippe.saliou@univ-brest.fr", "SALIOU", "Philippe", "CHR");
		Enseignant enseignant2 = new Enseignant(2, "29200", "philippe.saliou1@univ-brest.fr", "SALIOU2", "Philippe2", "CHR");
		
		List<Enseignant> listeEnseignant = Lists.newArrayList();
		listeEnseignant.add(enseignant1);
		listeEnseignant.add(enseignant2);
		enseignantRepo = new EnseignantRepositoryList(listeEnseignant);
		enseignantBusiness = new EnseignantBusinessJPA(enseignantRepo);
	}
	
	@Test
	public void doitCreerEnseignant() {
		Enseignant enseignantACreer = new Enseignant(3, "29200", "philippe.saliou2@univ-brest.fr", "SALIOU3", "Philippe3", "CHR");
		enseignantBusiness.creerEnseignant(enseignantACreer);
		assertThat(enseignantRepo.count()).isEqualTo(3);
	}
	
	@Test
	public void doitSupprimerEnseignant() {
		Enseignant EnseignantASuppr = new Enseignant(2, "29200", "philippe.saliou1@univ-brest.fr", "SALIOU2", "Philippe2", "CHR");
		enseignantBusiness.supprimerEnseignant(EnseignantASuppr);
		assertThat(enseignantRepo.count()).isEqualTo(1);
	}

	@Test
	public void doitRecupererTousLEsEnseignants() {
		List<Enseignant> liste = enseignantBusiness.recupererTousLEsEnseignants();
		assertThat(liste).hasSize(2);
	}

	@Test
	public void doitRecupererEnseignantParNom() {
		List<Enseignant> liste = enseignantBusiness.recupererEnseignantParNom("SALIOU");
		assertThat(liste).hasSize(1);
		assertThat(liste).extracting("prenom").containsExactly("Philippe");
	}


	@Test
	public void doitRecupererEnseignantParEmailUbo() {
		Enseignant enseignant = enseignantBusiness.recupererEnseignantParEmailUbo("philippe.saliou@univ-brest.fr");
		assertThat(enseignant.getNoEnseignant()).isEqualTo(1);
	}
	
	
}

class EnseignantRepositoryList implements EnseignantRepository{

	private List<Enseignant> data;
	
	public EnseignantRepositoryList(List<Enseignant> data) {
		this.data = data;
	}

	@Override
	public long count() {
		return data.size();
	}

	@Override
	public void delete(Long entity) {
		data = data.stream()
				.filter(element -> element.getNoEnseignant() != entity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Enseignant entity) {
		data = data.stream()
				.filter(element -> !element.equals(entity))
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Iterable<? extends Enseignant> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Enseignant> findAll() {
		return data;
	}

	@Override
	public Iterable<Enseignant> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enseignant findOne(Long arg0) {
		List<Enseignant> data1 = data.stream().filter(element -> element.getNoEnseignant() == arg0)
				.collect(Collectors.toList());
		return data1.size() != 0? data1.get(0):null;
	}

	@Override
	public <S extends Enseignant> S save(S entity) {
		data.add(entity);
		return entity;
	}

	@Override
	public <S extends Enseignant> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enseignant findByNoEnseignant(long noEnseignant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enseignant> findByNom(String nom) {
		return data.stream()
				.filter(element -> element.getNom().matches(nom))
				.collect(Collectors.toList());
	}

	@Override
	public Enseignant findByEmailUbo(String emailUbo) {
		List<Enseignant> data1 = data.stream()
				.filter(element -> element.getEmailUbo().matches(emailUbo))
				.collect(Collectors.toList());
		return data1.get(0);
	}
	
}
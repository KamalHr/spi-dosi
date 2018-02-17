package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.repository.CandidatRepository;

public class CandidatBusinessJPATest {
	CandidatBusinessJPA candidatBusiness;
	CandidatRepository candidatRepo;
	@Before
	public void setup() {
		Candidat candidat1 = new Candidat("1","Nom1", "Prenom1","Univ1");
		Candidat candidat2 = new Candidat("2","Nom2", "Prenom2","Univ2");
		Candidat candidat3 = new Candidat("3","Nom3", "Prenom3","Univ3");
		Candidat candidat4 = new Candidat("4","Nom4", "Prenom4","Univ4");
		Candidat candidat5 = new Candidat("5","Nom5", "Prenom5","Univ5");
		List<Candidat> data = new ArrayList();
		data.add(candidat1);
		data.add(candidat2);
		data.add(candidat3);
		data.add(candidat4);
		data.add(candidat5);
		candidatRepo = new CandidatRepositoryList(data);
		candidatBusiness = new CandidatBusinessJPA(candidatRepo);
	}
	@Test
	public void doitCreerUnCandidat() {
		Candidat candidat1 = new Candidat("6","HOUREDDINE", "Kamal","UIZ");
		Candidat resultat = candidatBusiness.creerCandidat(candidat1);
		assertThat(resultat.getNom()).isEqualTo("HOUREDDINE");
		assertThat(candidatRepo.count()).isEqualTo(6);
	}
	
	@Test
	public void doitSupprimerUnCandidat() {
		Candidat candidat5 = new Candidat("5","Nom5", "Prenom5","Univ5");
		candidatBusiness.supprimerCandidat(candidat5);
		assertThat(candidatRepo.count()).isEqualTo(4);
		candidatBusiness.supprimerCandidat("4");
		assertThat(candidatRepo.count()).isEqualTo(3);
	}
	
	@Test
	public void doitChercherParNom() {
		List<Candidat> candidats = candidatBusiness.rechercheCandidatParNom("Nom4");
		assertThat(candidats).extracting("prenom").containsExactly("Prenom4");
		
	}
	
	@Test
	public void doitChercherParUniveriste() {
		List<Candidat> candidats = candidatBusiness.rechercheCandidatParUniversite("Univ5");
		assertThat(candidats).extracting("prenom").containsExactly("Prenom5");
	}
}
@Repository
class CandidatRepositoryList implements CandidatRepository{
	
	private List<Candidat> data;
	
	public CandidatRepositoryList(List<Candidat> data) {
		super();
		this.data = data;
	}

	@Override
	public long count() {
		return data.size();
	}

	@Override
	public void delete(String noCandidat) {
		for(Candidat candidat: data) {
			if(candidat.getNoCandidat().matches(noCandidat)) {
				data.remove(candidat);
				break;
			}
		}
	}

	@Override
	public void delete(Candidat entity) {
		if(data.remove(entity)) {
			System.out.println("Done");
		}else {
			System.out.println("Not Done");
		}
	}

	@Override
	public void delete(Iterable<? extends Candidat> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Candidat> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Candidat> findAll(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Candidat findOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Candidat> S save(S entity) {
		data.add(entity);
		return entity;
	}

	@Override
	public <S extends Candidat> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidat> findByNom(String nom) {
		return data.stream()
				.filter(candidat -> candidat.getNom().matches(nom))
				.collect(Collectors.toList());
	}

	@Override
	public List<Candidat> findByUniversiteOrigine(String universiteOrigine) {
		return data.stream()
				.filter(candidat -> candidat.getUniversiteOrigine().matches(universiteOrigine))
				.collect(Collectors.toList());
	}

	@Override
	public List<Candidat> findByNoCandidat(String universiteOrigine) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
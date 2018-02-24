package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.stereotype.Repository;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.business.FormationBusiness;
import fr.univbrest.dosi.business.FormationBusinessJPA;
import fr.univbrest.dosi.repository.FormationRepository;

public class FormationBusinessJPATest {
	FormationBusinessJPA formationBusiness;
	
	@Test
	public void doitCreerUneFormation() {
		FormationRepository repos = new FormationRepositoryList();
		formationBusiness = new FormationBusinessJPA(repos);
		Formation formation = new Formation("33", null, "M2", "O", new Date(), BigDecimal.valueOf(2.0), "DOSI");
		
		Formation resultat = formationBusiness.creerFormation(formation);
		System.out.println(resultat.getDebutAccreditation());
		assertThat(resultat.getDebutAccreditation()).isCloseTo(new Date(), 500);
		assertThat(repos.count()).isEqualTo(1);		
	}
}

class FormationRepositoryList implements FormationRepository{
	private List<Formation> data;
	
	public FormationRepositoryList() {
		data = Lists.newArrayList();
	}

	@Override
	public long count() {
		return data.size();
	}

	@Override
	public void delete(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Formation arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Formation> arg0) {
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
	public Iterable<Formation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Formation> findAll(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Formation findOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Formation> S save(S entity) {
		data.add(entity);
		return entity;
	}

	@Override
	public <S extends Formation> Iterable<S> save(Iterable<S> arg0) {
		return null;
	}

	@Override
	public List<Formation> findByNomFormation(String nomFormation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Formation> findByCodeFormation(String codeFormation) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
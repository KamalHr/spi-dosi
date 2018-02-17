package fr.univbrest.dosi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.univbrest.dosi.bean.Formation;

@Repository
public interface FormationRepository extends CrudRepository<Formation, String> {
	List<Formation> findByNomFormation(String nomFormation);
	List<Formation> findByCodeFormation(String codeFormation);
}

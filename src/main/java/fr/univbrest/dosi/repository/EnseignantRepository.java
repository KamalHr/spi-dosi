package fr.univbrest.dosi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.univbrest.dosi.bean.Enseignant;

@Repository
public interface EnseignantRepository extends CrudRepository<Enseignant, Long> {
	public Enseignant findByNoEnseignant(long noEnseignant);
	public List<Enseignant> findByNom(String nom);
	public Enseignant findByEmailUbo(String emailUbo);
}

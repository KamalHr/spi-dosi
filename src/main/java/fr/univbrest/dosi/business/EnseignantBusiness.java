package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Enseignant;

public interface EnseignantBusiness {
	public Enseignant creerEnseignant(Enseignant enseignantACreer);
	public void supprimerEnseignant(Enseignant EnseignantASuppr);
	public List<Enseignant> recupererTousLEsEnseignants();
	public List<Enseignant> recupererEnseignantParNom(String Nom);
	public Enseignant recupererEnseignantParNoEnseignant(long noEnseignant);
	public Enseignant recupererEnseignantParEmailUbo(String emailUbo);
}

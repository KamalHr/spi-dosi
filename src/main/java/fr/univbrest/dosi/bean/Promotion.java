package fr.univbrest.dosi.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PROMOTION database table.
 * 
 */
@Entity
@NamedQuery(name="Promotion.findAll", query="SELECT p FROM Promotion p")
public class Promotion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentaire == null) ? 0 : commentaire.hashCode());
		result = prime * result + ((dateRentree == null) ? 0 : dateRentree.hashCode());
		result = prime * result + ((dateReponseLalp == null) ? 0 : dateReponseLalp.hashCode());
		result = prime * result + ((dateReponseLp == null) ? 0 : dateReponseLp.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lieuRentree == null) ? 0 : lieuRentree.hashCode());
		result = prime * result + ((nbMaxEtudiant == null) ? 0 : nbMaxEtudiant.hashCode());
		result = prime * result + ((processusStage == null) ? 0 : processusStage.hashCode());
		result = prime * result + ((siglePromotion == null) ? 0 : siglePromotion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promotion other = (Promotion) obj;
		if (commentaire == null) {
			if (other.commentaire != null)
				return false;
		} else if (!commentaire.equals(other.commentaire))
			return false;
		if (dateRentree == null) {
			if (other.dateRentree != null)
				return false;
		} else if (!dateRentree.equals(other.dateRentree))
			return false;
		if (dateReponseLalp == null) {
			if (other.dateReponseLalp != null)
				return false;
		} else if (!dateReponseLalp.equals(other.dateReponseLalp))
			return false;
		if (dateReponseLp == null) {
			if (other.dateReponseLp != null)
				return false;
		} else if (!dateReponseLp.equals(other.dateReponseLp))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lieuRentree == null) {
			if (other.lieuRentree != null)
				return false;
		} else if (!lieuRentree.equals(other.lieuRentree))
			return false;
		if (nbMaxEtudiant == null) {
			if (other.nbMaxEtudiant != null)
				return false;
		} else if (!nbMaxEtudiant.equals(other.nbMaxEtudiant))
			return false;
		if (processusStage == null) {
			if (other.processusStage != null)
				return false;
		} else if (!processusStage.equals(other.processusStage))
			return false;
		if (siglePromotion == null) {
			if (other.siglePromotion != null)
				return false;
		} else if (!siglePromotion.equals(other.siglePromotion))
			return false;
		return true;
	}

	public Promotion(PromotionPK id, String lieuRentree, String siglePromotion) {
		this.id = id;
		this.lieuRentree = lieuRentree;
		this.siglePromotion = siglePromotion;
	}

	@EmbeddedId
	private PromotionPK id;

	private String commentaire;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_RENTREE")
	private Date dateRentree;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_REPONSE_LALP")
	private Date dateReponseLalp;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_REPONSE_LP")
	private Date dateReponseLp;

	@Column(name="LIEU_RENTREE")
	private String lieuRentree;

	@Column(name="NB_MAX_ETUDIANT")
	private BigDecimal nbMaxEtudiant;

	@Column(name="PROCESSUS_STAGE")
	private String processusStage;

	@Column(name="SIGLE_PROMOTION")
	private String siglePromotion;

	//uni-directional many-to-one association to Enseignant
	@ManyToOne
	@JoinColumn(name="NO_ENSEIGNANT")
	private Enseignant enseignant;

	//uni-directional many-to-one association to Formation
	@ManyToOne
	@JoinColumn(name="CODE_FORMATION", insertable=false, updatable=false)
	private Formation formation;

	public Promotion() {
	}

	public PromotionPK getId() {
		return this.id;
	}

	public void setId(PromotionPK id) {
		this.id = id;
	}

	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Date getDateRentree() {
		return this.dateRentree;
	}

	public void setDateRentree(Date dateRentree) {
		this.dateRentree = dateRentree;
	}

	public Date getDateReponseLalp() {
		return this.dateReponseLalp;
	}

	public void setDateReponseLalp(Date dateReponseLalp) {
		this.dateReponseLalp = dateReponseLalp;
	}

	public Date getDateReponseLp() {
		return this.dateReponseLp;
	}

	public void setDateReponseLp(Date dateReponseLp) {
		this.dateReponseLp = dateReponseLp;
	}

	public String getLieuRentree() {
		return this.lieuRentree;
	}

	public void setLieuRentree(String lieuRentree) {
		this.lieuRentree = lieuRentree;
	}

	public BigDecimal getNbMaxEtudiant() {
		return this.nbMaxEtudiant;
	}

	public void setNbMaxEtudiant(BigDecimal nbMaxEtudiant) {
		this.nbMaxEtudiant = nbMaxEtudiant;
	}

	public String getProcessusStage() {
		return this.processusStage;
	}

	public void setProcessusStage(String processusStage) {
		this.processusStage = processusStage;
	}

	public String getSiglePromotion() {
		return this.siglePromotion;
	}

	public void setSiglePromotion(String siglePromotion) {
		this.siglePromotion = siglePromotion;
	}

	public Enseignant getEnseignant() {
		return this.enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Formation getFormation() {
		return this.formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

}
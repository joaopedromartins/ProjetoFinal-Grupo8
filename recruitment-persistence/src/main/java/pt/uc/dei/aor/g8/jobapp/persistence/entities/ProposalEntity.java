package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.ProposalStatus;

@Entity
@Table(name = "Proposal")
@NamedQuery(name = "Proposal.listOfAllProposalBetweenDates", query = "SELECT p FROM ProposalEntity p WHERE p.proposalDate >= :start AND p.proposalDate < :end")
public class ProposalEntity implements Serializable{
	
	public static final String LIST_OF_ALL_PROPOSAL_BETWEEN_DATES = "Proposal.listOfAllProposalBetweenDates";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date proposalDate;

	@Column
	private String proposal;

	@Enumerated(EnumType.STRING)
	@Column
	private  ProposalStatus proposalStatus;



	public ProposalEntity() {

	}

	public ProposalEntity(Date proposalDate, String proposal) {
		super();
		this.proposalDate = proposalDate;
		this.proposal = proposal;
		this.proposalStatus = ProposalStatus.SUBMITTED;
	}



	public Date getProposalDate() {
		return proposalDate;
	}

	public void setProposalDate(Date proposalDate) {
		this.proposalDate = proposalDate;
	}

	public String getProposal() {
		return proposal;
	}

	public void setProposal(String proposal) {
		this.proposal = proposal;
	}

	public ProposalStatus getProposalStatus() {
		return proposalStatus;
	}

	public void setProposalStatus(ProposalStatus proposalStatus) {
		this.proposalStatus = proposalStatus;
	}

	public long getId() {
		return id;
	}

}

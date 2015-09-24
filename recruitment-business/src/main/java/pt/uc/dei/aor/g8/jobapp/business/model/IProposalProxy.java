package pt.uc.dei.aor.g8.jobapp.business.model;

import java.util.Date;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.ProposalStatus;

public interface IProposalProxy {
	
	public Date getProposalDate();
	public void setProposalDate(Date proposalDate);

	public String getProposal();
	public void setProposal(String proposal);
	
	public ProposalStatus getProposalStatus();
	public void setProposalStatus(ProposalStatus proposalStatus);

	public long getId();

}

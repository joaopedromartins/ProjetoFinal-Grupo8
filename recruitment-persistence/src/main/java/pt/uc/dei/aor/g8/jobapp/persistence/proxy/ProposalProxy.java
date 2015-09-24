package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import java.util.Date;

import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.ProposalStatus;
import pt.uc.dei.aor.g8.jobapp.business.model.IProposalProxy;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.ProposalEntity;

@Stateless
public class ProposalProxy implements IProposalProxy, IEntityAware<ProposalEntity> {

	private ProposalEntity entity;
	
	
	public ProposalProxy() {
		this(null);
	}
	
	public ProposalProxy (ProposalEntity proposal){
		if(proposal == null){
			this.entity = new ProposalEntity();
		} else {
			this.entity = proposal;
		}
	}

	public ProposalProxy (Date proposalDate, String proposal){
		this.entity = new ProposalEntity(proposalDate, proposal);
	}

	@Override
	public ProposalEntity getEntity() {
		return entity;
	}

	@Override
	public Date getProposalDate() {
		return entity.getProposalDate();
	}

	@Override
	public void setProposalDate(Date proposalDate) {
		entity.setProposalDate(proposalDate);
	}

	@Override
	public String getProposal() {
		return entity.getProposal();
	}

	@Override
	public void setProposal(String proposal) {
		entity.setProposal(proposal);
	}

	@Override
	public ProposalStatus getProposalStatus() {
		return entity.getProposalStatus();
	}

	@Override
	public void setProposalStatus(ProposalStatus proposalStatus) {
		entity.setProposalStatus(proposalStatus);
	}

	@Override
	public long getId() {
		return entity.getId();
	}

}

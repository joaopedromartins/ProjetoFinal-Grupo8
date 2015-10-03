package pt.uc.dei.aor.g8.jobapp.business.persistence;

import java.util.Date;
import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.model.IProposalProxy;

public interface IProposalPresistenceService {

	public List<IProposalProxy> listOfAllProposalBetweenDates (Date start, Date end);
	public IProposalProxy findById(long id);
	public IProposalProxy updateProposal (IProposalProxy proposal);
}

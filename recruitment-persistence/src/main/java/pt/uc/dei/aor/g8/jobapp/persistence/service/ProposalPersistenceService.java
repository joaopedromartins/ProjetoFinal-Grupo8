package pt.uc.dei.aor.g8.jobapp.persistence.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pt.uc.dei.aor.g8.jobapp.business.persistence.IProposalPresistenceService;

@Stateless
public class ProposalPersistenceService implements IProposalPresistenceService {

	@PersistenceContext (unitName="recruitment")
	private EntityManager em;

	public ProposalPersistenceService() {
	
	}

}

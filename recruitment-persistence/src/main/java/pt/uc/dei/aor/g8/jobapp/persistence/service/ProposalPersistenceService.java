package pt.uc.dei.aor.g8.jobapp.persistence.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pt.uc.dei.aor.g8.jobapp.business.model.IProposalProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IProposalPresistenceService;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.ProposalEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.ProposalProxy;

@Stateless
public class ProposalPersistenceService implements IProposalPresistenceService {

	@PersistenceContext (unitName="recruitment")
	private EntityManager em;

	public ProposalPersistenceService() {
	
	}
	@Override
	public List<IProposalProxy> listOfAllProposalBetweenDates (Date start, Date end){
		TypedQuery<ProposalEntity> query = em.createNamedQuery(ProposalEntity.LIST_OF_ALL_PROPOSAL_BETWEEN_DATES, ProposalEntity.class);
		query.setParameter("start", start);
		query.setParameter("end", end);
		List <ProposalEntity> entity = query.getResultList();
		
		List <IProposalProxy> proxy = new ArrayList<>();
		for (ProposalEntity p: entity){
			proxy.add(new ProposalProxy(p));
		}
		return proxy;	
	}
	

}

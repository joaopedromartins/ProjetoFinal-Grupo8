package pt.uc.dei.aor.g8.jobapp.persistence.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IProposalProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IProposalPresistenceService;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.JobApplicationEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.PositionEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.ProposalEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.UserEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.IEntityAware;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.JobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.PositionProxy;
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
	
	@Override
	public IProposalProxy findById(long id) {
		ProposalEntity entity = em.find(ProposalEntity.class,id );
		return new ProposalProxy(entity);
	}
	@Override
	public IProposalProxy updateProposal(IProposalProxy proposal) {
		ProposalEntity entity = getEntity(proposal);
		entity=em.merge(entity);
		return new ProposalProxy(entity);
	}
	
	
	@SuppressWarnings("unchecked")
	private ProposalEntity getEntity(IProposalProxy proxy) {
		if (proxy instanceof IEntityAware<?>) {
			return ((IEntityAware<ProposalEntity>) proxy).getEntity();
		}
		throw new IllegalStateException();
	}
	
	

}

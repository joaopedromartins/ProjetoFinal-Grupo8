package pt.uc.dei.aor.g8.jobapp.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.ICandidatePersistenceService;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.CandidateEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.UserEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.CandidateProxy;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.IEntityAware;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.UserProxy;

@Stateless
public class CandidateService implements ICandidatePersistenceService {

	@PersistenceContext (unitName="recruitment")
	private EntityManager em;

	public CandidateService() {

	}

	@SuppressWarnings("unchecked")
	private CandidateEntity getEntity(ICandidateProxy candidateProxy) {
		if (candidateProxy instanceof IEntityAware<?>) {
			return ((IEntityAware<CandidateEntity>) candidateProxy).getEntity();
		}
		throw new IllegalStateException();
	}

	@Override
	public ICandidateProxy saveCandidate(ICandidateProxy newCandidate) {
		CandidateEntity entity = getEntity(newCandidate);
		em.persist(entity);
		return new CandidateProxy(entity);
	}

	@Override
	public ICandidateProxy editCandidate(ICandidateProxy CandidateProxy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICandidateProxy findCandidateByUsername(String username) {
		TypedQuery <CandidateEntity> query = em.createNamedQuery(CandidateEntity.FIND_CANDIDATE_BY_USERNAME, CandidateEntity.class);
		query.setParameter("username",username);
		List <CandidateEntity> entity = query.getResultList();
		
		ICandidateProxy proxy;
		if( entity.size() == 1){
			proxy = new CandidateProxy(entity.get(0));
		} else {
			proxy=null;
		}
		
		return proxy;
	}
	
	@Override
	public ICandidateProxy findCandidateByEmail(String email) {
		TypedQuery <CandidateEntity> query = em.createNamedQuery(CandidateEntity.FIND_CANDIDATE_BY_EMAIL, CandidateEntity.class);
		query.setParameter("email",email);
		List <CandidateEntity> entity = query.getResultList();
		
		ICandidateProxy proxy;
		if( entity.size() == 1){
			proxy = new CandidateProxy(entity.get(0));
		} else {
			proxy=null;
		}
		
		return proxy;
	}

	
}

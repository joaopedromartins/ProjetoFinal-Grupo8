package pt.uc.dei.aor.g8.jobapp.persistence.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.ICandidatePersistenceService;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IJobAdvertisingChanelPersistenceService;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.CandidateEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.JobAdvertisingChanelEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.CandidateProxy;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.IEntityAware;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.JobAdvertisingChanelProxy;

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

	
}

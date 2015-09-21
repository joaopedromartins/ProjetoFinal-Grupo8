package pt.uc.dei.aor.g8.jobapp.persistence.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pt.uc.dei.aor.g8.jobapp.business.model.IJobInterviewProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IJobInterviewPersistenceService;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.JobInterviewEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.IEntityAware;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.JobInterviewProxy;


@Stateless
public class JobInterviewPersistenceService implements IJobInterviewPersistenceService {

	@PersistenceContext (unitName="recruitment")
	private EntityManager em;

	public JobInterviewPersistenceService() {
	}

	@Override
	public IJobInterviewProxy newInterview(IJobInterviewProxy proxyInterview) {
		JobInterviewEntity entity = getEntity(proxyInterview);
		em.persist(entity);
		return new JobInterviewProxy(entity);
	}

	@SuppressWarnings("unchecked")
	private JobInterviewEntity getEntity(IJobInterviewProxy proxyInterview) {
		if ( proxyInterview instanceof IEntityAware<?>){
			return ((IEntityAware<JobInterviewEntity>) proxyInterview).getEntity();
		}
		throw new IllegalStateException();
	}

	
	
}

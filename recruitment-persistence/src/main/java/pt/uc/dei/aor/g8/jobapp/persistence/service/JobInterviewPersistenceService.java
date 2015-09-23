package pt.uc.dei.aor.g8.jobapp.persistence.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pt.uc.dei.aor.g8.jobapp.business.model.IJobInterviewProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IJobInterviewPersistenceService;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.JobInterviewEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.UserEntity;
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

	@Override
	public List<IJobInterviewProxy> listOfAllInterviews() {
		TypedQuery<JobInterviewEntity> query = em.createNamedQuery(JobInterviewEntity.LIST_OF_ALL_INTERVIEWS, JobInterviewEntity.class);
		List <JobInterviewEntity> entity = query.getResultList();

		List <IJobInterviewProxy> proxy = new ArrayList<>();
		for (JobInterviewEntity i: entity){
			proxy.add(new JobInterviewProxy(i));
		}
		return proxy;
	}
	
	@SuppressWarnings("unchecked")
	private UserEntity getUserEntity(IUserProxy userProxy) {
		if (userProxy instanceof IEntityAware<?>) {
			return ((IEntityAware<UserEntity>) userProxy).getEntity();
		}
		throw new IllegalStateException();
	}

	@Override
	public List<IJobInterviewProxy> listInterviewsOfInterview(IUserProxy interviewer) {
		TypedQuery <JobInterviewEntity> query = em.createNamedQuery(JobInterviewEntity.LIST_INTERVIEWS_OF_INTERVIEWER,JobInterviewEntity.class);
		query.setParameter("interviewer",getUserEntity(interviewer));
		List <JobInterviewEntity> entity = query.getResultList();

		List <IJobInterviewProxy> proxy = new ArrayList<>();
		for (JobInterviewEntity i: entity){
			proxy.add(new JobInterviewProxy(i));
		}
		return proxy;
	}



}

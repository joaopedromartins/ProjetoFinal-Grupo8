package pt.uc.dei.aor.g8.jobapp.persistence.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IJobApplicationPersistenceService;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.CandidateEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.JobApplicationEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.IEntityAware;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.JobApplicationProxy;

@Stateless
public class JobApplicationPersistenceService implements IJobApplicationPersistenceService {
	
	@PersistenceContext (unitName="recruitment")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	private JobApplicationEntity getEntity(IJobApplicationProxy jobApplicationProxy) {
		if (jobApplicationProxy instanceof IEntityAware<?>) {
			return ((IEntityAware<JobApplicationEntity>) jobApplicationProxy).getEntity();
		}
		throw new IllegalStateException();
	}

	@Override
	public IJobApplicationProxy saveJobApplication(IJobApplicationProxy newJobApplication) {
		JobApplicationEntity entity = getEntity(newJobApplication);
		em.persist(entity);
		return new JobApplicationProxy(entity);
	}
	
	public boolean existsJobApplicationToPositionCodeAndUsername(String positionCode, String username) {
		TypedQuery<JobApplicationEntity> query = em.createNamedQuery(JobApplicationEntity.LIST_OF_ALL_JOB_APPLICATION_TO_POSITION_CODE_AND_USERNAME, JobApplicationEntity.class);
		query.setParameter( "code", positionCode);
		query.setParameter( "username", username);
		List<JobApplicationEntity> entity= query.getResultList();
		
		return !entity.isEmpty();
	}
	
	public IJobApplicationProxy spontaneousJobApllicationByCandidate(ICandidateProxy candidate){
		TypedQuery<JobApplicationEntity> query = em.createNamedQuery(JobApplicationEntity.FIND_SPONTANEOUS_JOBAPP_BY_CANDIDATE, JobApplicationEntity.class);
		query.setParameter( "candidateEntity", candidateCoverterProxyToEntity(candidate));
		List <JobApplicationEntity> entity = query.getResultList();
		
		IJobApplicationProxy proxy;
		if( entity.size() == 1){
			proxy = new JobApplicationProxy(entity.get(0));
		} else {
			proxy=null;
		}
		return proxy;
	}
	
	@SuppressWarnings("unchecked")
	private CandidateEntity candidateCoverterProxyToEntity (ICandidateProxy candidate){
		CandidateEntity entity = ((IEntityAware<CandidateEntity>)candidate).getEntity();
		return entity;
	}


	@Override
	public List<IJobApplicationProxy> listOfAllCandidateJobApplication(String username) {
		
		TypedQuery <JobApplicationEntity> query = em.createNamedQuery(JobApplicationEntity.LIST_OF_ALL_CANDIDATE_JOB_APPLICATION, JobApplicationEntity.class);
		query.setParameter( "login", username);
		List <JobApplicationEntity> entity= query.getResultList();

		List<IJobApplicationProxy> proxy= new ArrayList<>();
		for(JobApplicationEntity p: entity){
			proxy.add(new JobApplicationProxy(p));
		}
		
		return proxy;
	}

	@Override
	public IJobApplicationProxy editJobApplication(IJobApplicationProxy jobApplicationProxy) {
		JobApplicationEntity entity = getEntity(jobApplicationProxy);
		entity=em.merge(entity);
		return new JobApplicationProxy(entity);
	}

	@Override
	public List<IJobApplicationProxy> findAllJobApplication() {
		TypedQuery <JobApplicationEntity> query = em.createNamedQuery(JobApplicationEntity.LIST_OF_ALL, JobApplicationEntity.class);
		List <JobApplicationEntity> entity = query.getResultList();
		
		List <IJobApplicationProxy> proxy = new ArrayList<>();
		for (JobApplicationEntity jA: entity){
			proxy.add(new JobApplicationProxy(jA));
		}
		return proxy;
	}

	@Override
	public IJobApplicationProxy findById(long id) {
		JobApplicationEntity entity = em.find(JobApplicationEntity.class,id );
		return new JobApplicationProxy(entity);
	}

}

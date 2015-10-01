package pt.uc.dei.aor.g8.jobapp.persistence.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IJobApplicationPersistenceService;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.CandidateEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.JobApplicationEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.PositionEntity;
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
	public IJobApplicationProxy candidateSpontaneousJobApplication(String username) {
		TypedQuery <JobApplicationEntity> query = em.createNamedQuery(JobApplicationEntity.LIST_SPONTANEOUS_JOB_APPLICATION_BY_USERNAME, JobApplicationEntity.class);
		query.setParameter( "login", username);
		List <JobApplicationEntity> entity= query.getResultList();
				
		IJobApplicationProxy proxy;
		if( entity.size() == 1){
			proxy = new JobApplicationProxy(entity.get(0));
		} else {
			proxy=null;
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
	public IJobApplicationProxy findById(long id) {
		JobApplicationEntity entity = em.find(JobApplicationEntity.class,id );
		return new JobApplicationProxy(entity);
	}

	@Override
	public List<IJobApplicationProxy> listOfJobApplicationByCandidate(ICandidateProxy candidate) {
		TypedQuery <JobApplicationEntity> query = em.createNamedQuery(JobApplicationEntity.LIST_OF_JOBAPPLICATION_BY_CANDIDATE, JobApplicationEntity.class);
		query.setParameter( "candidate", candidateCoverterProxyToEntity(candidate));
		List <JobApplicationEntity> entity = query.getResultList();
		
		List <IJobApplicationProxy> proxy = new ArrayList<>();
		for (JobApplicationEntity jA: entity){
			proxy.add(new JobApplicationProxy(jA));
		}
		return proxy;
	}

	@Override
	public List<IJobApplicationProxy> listOfAllSpontaneous() {
		TypedQuery <JobApplicationEntity> query = em.createNamedQuery(JobApplicationEntity.LIST_OF_ALL_SPONTANEOUS_JOBAPPLICATION, JobApplicationEntity.class);
		List <JobApplicationEntity> entity = query.getResultList();
		
		List <IJobApplicationProxy> proxy = new ArrayList<>();
		for (JobApplicationEntity jA: entity){
			proxy.add(new JobApplicationProxy(jA));
		}
		return proxy;
	}

	@Override
	public List<IJobApplicationProxy> listOfAllSpontaneousSituation() {
		TypedQuery <JobApplicationEntity> query = em.createNamedQuery(JobApplicationEntity.LIST_OF_ALL_SPONTANEOUS_SITUATION, JobApplicationEntity.class);
		List <JobApplicationEntity> entity = query.getResultList();
		
		List <IJobApplicationProxy> proxy = new ArrayList<>();
		for (JobApplicationEntity jA: entity){
			proxy.add(new JobApplicationProxy(jA));
		}
		return proxy;
	}

	@Override
	public IJobApplicationProxy findJobApplicationByCandidateAndPosition(ICandidateProxy candidate,
			IPositionProxy position) {
		TypedQuery<JobApplicationEntity> query = em.createNamedQuery(JobApplicationEntity.LIST_OF_JOBAPPLICATION_BY_CANDIDATE_AND_POSITION, JobApplicationEntity.class);
		query.setParameter( "candidate", candidateCoverterProxyToEntity(candidate));
		query.setParameter( "position", positionCoverterProxyToEntity(position));
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
	private PositionEntity positionCoverterProxyToEntity (IPositionProxy position){
		PositionEntity entity = ((IEntityAware<PositionEntity>)position).getEntity();
		return entity;
	}
	
	@Override
	public List <IJobApplicationProxy> listOfAllAppNotSituationSpontaneous (){
		TypedQuery <JobApplicationEntity> query = em.createNamedQuery(JobApplicationEntity.LIST_OF_ALL_APPLICATION_NOT_SITUATION_SPONTANEOUS, JobApplicationEntity.class);
		List <JobApplicationEntity> entity = query.getResultList();
		
		List <IJobApplicationProxy> proxy = new ArrayList<>();
		for (JobApplicationEntity jA: entity){
			proxy.add(new JobApplicationProxy(jA));
		}
		return proxy;
	}

	@Override
	public List<IJobApplicationProxy> listOfAllAppBetweenDates(Date startDate, Date endDate) {
		TypedQuery <JobApplicationEntity> query = em.createNamedQuery(JobApplicationEntity.LIST_OF_ALL_APP_BETWEEN_DATES, JobApplicationEntity.class);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		List <JobApplicationEntity> entity = query.getResultList();
		
		List <IJobApplicationProxy> proxy = new ArrayList<>();
		for (JobApplicationEntity jA: entity){
			proxy.add(new JobApplicationProxy(jA));
		}
		return proxy;
	}

	@Override
	public List<IJobApplicationProxy> listOfAllAppSpontaneousBetweenDates(Date startDate, Date endDate) {
		TypedQuery <JobApplicationEntity> query = em.createNamedQuery(JobApplicationEntity.LIST_OF_ALL_APP_SPONTANEOUS_BETWEEN_DATES, JobApplicationEntity.class);
		
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		List <JobApplicationEntity> entity = query.getResultList();
		
		List <IJobApplicationProxy> proxy = new ArrayList<>();
		for (JobApplicationEntity jA: entity){
			proxy.add(new JobApplicationProxy(jA));
		}
		return proxy;
	}


}

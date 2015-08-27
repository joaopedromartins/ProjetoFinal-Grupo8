package pt.uc.dei.aor.g8.jobapp.persistence.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IJobAdvertisingChanelPersistenceService;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.JobAdvertisingChanelEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.IEntityAware;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.JobAdvertisingChanelProxy;

@Stateless
public class JobAdvertisingChanelPersistenceService implements IJobAdvertisingChanelPersistenceService {

	@PersistenceContext (unitName="recruitment")
	private EntityManager em;

	public JobAdvertisingChanelPersistenceService() {

	}

	@Override
	public IJobAdvertisingChanelProxy addChanel(IJobAdvertisingChanelProxy newChanel) {
		JobAdvertisingChanelEntity entity = getEntity(newChanel);
		em.persist(entity);
		return new JobAdvertisingChanelProxy(entity);
	}

	@SuppressWarnings("unchecked")
	private JobAdvertisingChanelEntity getEntity(IJobAdvertisingChanelProxy jobAdvertisingChanelProxy) {
		if (jobAdvertisingChanelProxy instanceof IEntityAware<?>) {
			return ((IEntityAware<JobAdvertisingChanelEntity>) jobAdvertisingChanelProxy).getEntity();
		}
		throw new IllegalStateException();
	}

	@Override
	public List<IJobAdvertisingChanelProxy> listOfAllChanel() {
		TypedQuery<JobAdvertisingChanelEntity> query = em.createNamedQuery(JobAdvertisingChanelEntity.LIST_OF_ALL_CHANELS,JobAdvertisingChanelEntity.class);
		List<JobAdvertisingChanelEntity> entity = query.getResultList();

		List<IJobAdvertisingChanelProxy> proxy = new ArrayList<>();
		for(JobAdvertisingChanelEntity j: entity){
			proxy.add(new JobAdvertisingChanelProxy(j));
		}

		return proxy;
	}
	
	@Override
	public IJobAdvertisingChanelProxy findNameChanel(String nameChanel) {
		TypedQuery<JobAdvertisingChanelEntity> query = em.createNamedQuery(JobAdvertisingChanelEntity.CHANEL_NAME, JobAdvertisingChanelEntity.class);
		query.setParameter("chanelName",nameChanel);
		List<JobAdvertisingChanelEntity> entity = query.getResultList();
		
		IJobAdvertisingChanelProxy proxy;
		if( entity.size()==1){
			proxy = new JobAdvertisingChanelProxy(entity.get(0));
		} else {
			proxy=null;
		}
		
		return proxy;
	}



}

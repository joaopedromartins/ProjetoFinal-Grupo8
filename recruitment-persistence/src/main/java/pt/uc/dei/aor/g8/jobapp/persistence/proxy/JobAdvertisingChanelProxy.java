package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.JobAdvertisingChanelEntity;

@Stateless
public class JobAdvertisingChanelProxy implements IJobAdvertisingChanelProxy, IEntityAware<JobAdvertisingChanelEntity> {

	private JobAdvertisingChanelEntity entity;

	public JobAdvertisingChanelProxy() {
		
	}

	public JobAdvertisingChanelProxy(String chanelName) {
		this.entity = new JobAdvertisingChanelEntity(chanelName);
	}

	public JobAdvertisingChanelProxy (JobAdvertisingChanelEntity jobAdvertisingChanel){
		if (jobAdvertisingChanel==null){
			this.entity = new JobAdvertisingChanelEntity();
		} else {
			this.entity = jobAdvertisingChanel;
		}
	}


	@Override
	public JobAdvertisingChanelEntity getEntity() {

		return entity;
	}

	@Override
	public String getChanelName() {

		return entity.getChanelName();
	}

	@Override
	public void setChanelName(String chanelName) {
		entity.setChanelName(chanelName);
	}


	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		return entity.equals(((IEntityAware<JobAdvertisingChanelEntity>)o).getEntity());
	}
	
	@Override
	public int hashCode() {
		return entity.hashCode();
	}
	
	@Override
	public String toString() {
		return entity.toString();
	}

}

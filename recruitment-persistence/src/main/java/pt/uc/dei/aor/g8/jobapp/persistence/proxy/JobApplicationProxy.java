package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import java.math.BigInteger;

import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.Status;
import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.JobAdvertisingChanelEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.JobApplicationEntity;

@Stateless
public class JobApplicationProxy implements IJobApplicationProxy, IEntityAware<JobApplicationEntity> {

	private JobApplicationEntity entity;

	public JobApplicationProxy() {
		
	}

	public JobApplicationProxy(String address, String city,
			String country, BigInteger phone, String diploma, String school, String letter,
			String cv, IJobAdvertisingChanelProxy source, String status) {
		this.entity = new JobApplicationEntity(address, city,
				country, phone, diploma, school, letter,
				cv, new JobAdvertisingChanelEntity( source.getChanelName()), status);
	}

	public JobApplicationProxy (JobApplicationEntity jobApplication){
		if (jobApplication==null){
			this.entity=new JobApplicationEntity();
		} else {
			this.entity=jobApplication;
		}
	}


	@Override
	public JobApplicationEntity getEntity() {
		return entity;
	}

	@Override
	public ICandidateProxy getCandidateEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPositionProxy getPositionEntity() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
	

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		return entity.equals(((IEntityAware<JobApplicationEntity>)o).getEntity());
	}
	
	@Override
	public int hashCode() {
		return entity.hashCode();
	}
	
	@Override
	public String toString() {
		return entity.toString();
	}

	@Override
	public void setCandidateEntity(ICandidateProxy candidateJobApplication) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPositionEntity(IPositionProxy positionJobApplication) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCity(String city) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCountry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCountry(String country) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BigInteger getPhone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPhone(BigInteger phone) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDiploma() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDiploma(String diploma) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getSchool() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSchool(String school) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLetter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLetter(String letter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCv() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCv(String cv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IJobAdvertisingChanelProxy getJobApplicationSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setJobApplicationSource(IJobAdvertisingChanelProxy jobApplicationSource) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Status getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStatus(Status status) {
		// TODO Auto-generated method stub
		
	}


	

	

	
}

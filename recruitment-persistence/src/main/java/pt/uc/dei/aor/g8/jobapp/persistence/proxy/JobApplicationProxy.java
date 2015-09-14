package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import java.math.BigInteger;

import javax.ejb.Stateless;


import pt.uc.dei.aor.g8.jobapp.business.enumeration.Status;
import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.CandidateEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.JobApplicationEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.PositionEntity;

@Stateless
public class JobApplicationProxy implements IJobApplicationProxy, IEntityAware<JobApplicationEntity> {

	private JobApplicationEntity entity;

	public JobApplicationProxy() {
		
	}

	public JobApplicationProxy(String address, String city,
			String country, BigInteger phone, String diploma, String school, String letter,
			String cv, String source, String status, ICandidateProxy candidateProxy, IPositionProxy positionProxy)  {
		this.entity = new JobApplicationEntity(address, city, country, phone, diploma, school, letter,
				cv, source, status, 
				candidateCoverterProxyToEntity(candidateProxy), 
				positionCoverterProxyToEntity(positionProxy) );
	}
	
	
	
	@SuppressWarnings("unchecked")
	private CandidateEntity candidateCoverterProxyToEntity (ICandidateProxy candidate){
		CandidateEntity entity = ((IEntityAware<CandidateEntity>)candidate).getEntity();
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	private PositionEntity positionCoverterProxyToEntity (IPositionProxy position){
		PositionEntity entity = ((IEntityAware<PositionEntity>)position).getEntity();
		return entity;
	}
	

	public JobApplicationProxy (JobApplicationEntity jobApplication){
		if (jobApplication==null){
			this.entity=new JobApplicationEntity();
		} else {
			this.entity=jobApplication;
		}
	}

	
	//Getters and Setters


	@Override
	public String getAddress() {
		return entity.getAddress();
	}
	@Override
	public void setAddress(String address) {
		entity.setAddress(address);
	}

	@Override
	public String getCity() {
		return entity.getCity();
	}
	@Override
	public void setCity(String city) {
		entity.setCity(city);
	}

	@Override
	public String getCountry() {
		return entity.getCountry();
	}
	@Override
	public void setCountry(String country) {
		entity.setCountry(country);
	}

	@Override
	public BigInteger getPhone() {
		return entity.getPhone();
	}
	@Override
	public void setPhone(BigInteger phone) {
		entity.setPhone(phone);
	}

	@Override
	public String getDiploma() {
		return entity.getDiploma();
	}
	@Override
	public void setDiploma(String diploma) {
		entity.setDiploma(diploma);
	}

	@Override
	public String getSchool() {
		return entity.getSchool();
	}
	@Override
	public void setSchool(String school) {
		entity.setSchool(school);
	}

	@Override
	public String getLetter() {
		return entity.getLetter();
	}
	@Override
	public void setLetter(String letter) {
		entity.setLetter(letter);
	}

	@Override
	public String getCv() {
		return entity.getCv();
	}
	@Override
	public void setCv(String cv) {
		entity.setCv(cv);
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
	public String getStatus() {
		return entity.getStatus();
	}
	@Override
	public void setStatus(String status) {
		entity.setStatus(status);
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
	public void setCandidateEntity(ICandidateProxy candidateJobApplication) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IPositionProxy getPositionEntity() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setPositionEntity(IPositionProxy positionJobApplication) {
		// TODO Auto-generated method stub
		
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
	
}

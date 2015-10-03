package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.JobAppSituation;
import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobInterviewProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IProposalProxy;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.CandidateEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.JobApplicationEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.JobInterviewEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.PositionEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.ProposalEntity;

@Stateless
public class JobApplicationProxy implements IJobApplicationProxy, IEntityAware<JobApplicationEntity> {

	private JobApplicationEntity entity;

	public JobApplicationProxy() {

	}

	public JobApplicationProxy(String address, String city,
			String country, String phone, String diploma, String school, String letter,
			String cv, String source, ICandidateProxy candidateProxy, IPositionProxy positionProxy)  {

		this.entity = new JobApplicationEntity(address, city, country, phone, diploma, school, letter,
				cv, source, candidateCoverterProxyToEntity(candidateProxy),positionCoverterProxyToEntity(positionProxy) );
	}
	
	public JobApplicationProxy(String address, String city, String country, String phone, String diploma,
			String school, String letter, String cv, String source, ICandidateProxy candidate) {
		
		this.entity = new JobApplicationEntity(address, city, country, phone, diploma, school, letter,
				cv, source, candidateCoverterProxyToEntity(candidate));
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
	public String getPhone() {
		return entity.getPhone();
	}
	@Override
	public void setPhone(String phone) {
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
	public String getSource() {
		return entity.getJobPositionSource();
	}
	@Override
	public void setSource(String source) {
		entity.setJobPositionSource(source);
	}

	@Override
	public JobAppSituation getSituation() {
		return entity.getSituation();
	}
	@Override
	public void setSituation(JobAppSituation situation) {
		entity.setSituation(situation);
	}

	@Override
	public JobApplicationEntity getEntity() {
		return entity;
	}

	@Override
	public ICandidateProxy getCandidateEntity() {
		ICandidateProxy proxy = new CandidateProxy(entity.getCandidateEntity());
		return proxy;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setCandidateEntity(ICandidateProxy candidateJobApplication) {
		entity.setCandidateEntity(((IEntityAware<CandidateEntity>)candidateJobApplication).getEntity());

	}
	

	@Override
	public IPositionProxy getPositionEntity() {
		return new PositionProxy (entity.getPositionEntity());
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setPositionEntity(IPositionProxy positionJobApplication) {
		entity.setPositionEntity(((IEntityAware<PositionEntity>)positionJobApplication).getEntity());

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
	public long getId() {
		return entity.getId();
	}

	@Override
	public List<IJobInterviewProxy> getInterviews() {
		List<IJobInterviewProxy> proxy = new ArrayList<>();
		List<JobInterviewEntity> entityInterviews = entity.getInterviews();
		for(JobInterviewEntity jI: entityInterviews){
			proxy.add(new JobInterviewProxy(jI));
		}
		return proxy;
	}

	@Override
	public void setInterviews(List<IJobInterviewProxy> interviews) {
		entity.setInterviews(interviewConvertProxyToEntity(interviews));
	}
	
	@SuppressWarnings(value = "unchecked")
	private List<JobInterviewEntity> interviewConvertProxyToEntity (List<IJobInterviewProxy> interviews ){
		List <JobInterviewEntity> entity = new ArrayList<>();
		for(IJobInterviewProxy jI: interviews){
			entity.add(((IEntityAware<JobInterviewEntity>)jI).getEntity());
		}
		return entity;
	} 
	
	@Override
	public IProposalProxy getProposal() {
	if (entity.getProposal() == null) return null;
	return new ProposalProxy(entity.getProposal());
	}

	@Override
	public void setProposal(IProposalProxy proposal) {
		entity.setProposal(proposalConvertProxyToEntity(proposal));
	}
	
	@SuppressWarnings("unchecked")
	private ProposalEntity proposalConvertProxyToEntity (IProposalProxy proxy){
		ProposalEntity entityProposal = ((IEntityAware<ProposalEntity>)proxy).getEntity();
		return entityProposal;
	}

	@Override
	public boolean isJobappSpontaneous() {
		return entity.isJobappSpontaneous();
	}

	@Override
	public void setJobappSpontaneous(boolean jobappSpontaneous) {
		entity.setJobappSpontaneous(jobappSpontaneous);
	}

	@Override
	public Date getJobAppDate() {
		return entity.getJobAppDate();
	}

	@Override
	public Date getHiredDate() {
		return entity.getHiredDate();
	}

	@Override
	public void setHiredDate(Date hired) {
		entity.setHiredDate(hired);
	}

}

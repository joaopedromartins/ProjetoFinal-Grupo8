package pt.uc.dei.aor.g8.jobapp.business.model;


import java.util.Date;
import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.JobAppSituation;

public interface IJobApplicationProxy {

	public ICandidateProxy getCandidateEntity();
	public void setCandidateEntity(ICandidateProxy candidateJobApplication);
	
	public IPositionProxy getPositionEntity();
	public void setPositionEntity(IPositionProxy positionJobApplication);
	
	public String getAddress();
	public void setAddress(String address);
	
	public String getCity() ;
	public void setCity(String city);
	
	public String getCountry() ;
	public void setCountry(String country) ;
	
	public String getPhone();
	public void setPhone(String phone) ;
	
	public String getDiploma();
	public void setDiploma(String diploma);
	
	public String getSchool() ;
	public void setSchool(String school);
	
	public String getLetter() ;
	public void setLetter(String letter) ;
	
	public String getCv() ;
	public void setCv(String cv);
	
	public String getSource() ;
	public void setSource(String source);
	
	public JobAppSituation getSituation();
	public void setSituation(JobAppSituation situation);
	
	public long getId();
	
	public List<IJobInterviewProxy> getInterviews();
	public void setInterviews(List<IJobInterviewProxy> interviews);
	
	public IProposalProxy getProposal();
	public void setProposal(IProposalProxy proposal);
	
	public boolean isJobappSpontaneous();
	public void setJobappSpontaneous(boolean jobappSpontaneous);
	
	public Date getJobAppDate();
	
	public Date getHiredDate ();
	public void setHiredDate(Date hired);

}

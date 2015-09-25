package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.service.ICandidateFacade;
import pt.uc.dei.aor.g8.jobapp.business.service.IJobApplicationFacade;

@Named
@ViewScoped
public class CandidateBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ICandidateFacade facade;
	@EJB
	private IJobApplicationFacade jobAppFacade;
	@Inject
	private JobApplicationBean jobApplication;
	
	private long candidateId;
	private List <IJobApplicationProxy> jobAppsCandidate;
	private ICandidateProxy candidate;
	
	
	


	public long getCandidateId() {
		return candidateId;
	}
	
	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
	}

	public JobApplicationBean getJobApplication() {
		return jobApplication;
	}

	public void setJobApplication(JobApplicationBean jobApplication) {
		this.jobApplication = jobApplication;
	}

	public List<IJobApplicationProxy> getJobAppsCandidate() {
		return jobAppsCandidate;
	}

	public void setJobAppsCandidate(List<IJobApplicationProxy> jobAppsCandidate) {
		this.jobAppsCandidate = jobAppsCandidate;
	}
	
	public void findCandidateById (){
		this.candidate = facade.findCandidateById(candidateId);
		this.jobAppsCandidate = jobAppFacade.listOfJobApplicationByCandidate(candidate);
				
	}
	
	

}

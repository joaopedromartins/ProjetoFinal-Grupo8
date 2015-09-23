package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobInterviewProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.business.service.IJobInterviewFacade;
import pt.uc.dei.aor.g8.jobapp.business.service.IUserFacade;

@Named
@ViewScoped
public class JobInterviewBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IUserFacade userFacade;
	@EJB
	private IJobInterviewFacade interviewFacade;
	@Inject
	private UserBean currentInterviewer;
	
	private Date date;
	private IUserProxy userInterviwer;
	private List <IJobInterviewProxy> inteviews;
	private IPositionProxy position;
	private ICandidateProxy candidate;
	private IJobApplicationProxy jobApplication;
	
	
	
	
	public JobInterviewBean() {

	}

	public IUserProxy getUserInterviwer() {
		return userInterviwer;
	}
	
	public List <IUserProxy> getPossibleUserInterviwer(){
		return userFacade.findInterviewers();
	}

	public void setUserInterviwer(IUserProxy userInterviwer) {
		this.userInterviwer = userInterviwer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<IJobInterviewProxy> getInteviews() {
		return inteviews;
	}

	public void setInteviews(List<IJobInterviewProxy> inteviews) {
		this.inteviews = inteviews;
	}
	
	public IPositionProxy getPosition() {
		return position;
	}

	public void setPosition(IPositionProxy position) {
		this.position = position;
	}

	public ICandidateProxy getCandidate() {
		return candidate;
	}

	public void setCandidate(ICandidateProxy candidate) {
		this.candidate = candidate;
	}

	public IJobApplicationProxy getJobApplication() {
		return jobApplication;
	}

	public void setJobApplication(IJobApplicationProxy jobApplication) {
		this.jobApplication = jobApplication;
	}

	public List<IJobInterviewProxy> listOfAllInterviews (){
		return interviewFacade.listOfAllInterviews();
	}
	
	public List <IJobInterviewProxy> listInterviewsOfInterviewer (){
		return interviewFacade.listInterviewsOfInterviewer(currentInterviewer.getCurrentUser());
	}
	
	

}

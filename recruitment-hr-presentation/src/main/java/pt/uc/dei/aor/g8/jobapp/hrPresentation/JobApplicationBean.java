package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.JobAppSituation;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.StatusPosition;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobInterviewProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IScriptProxy;
import pt.uc.dei.aor.g8.jobapp.business.service.IJobApplicationFacade;
import pt.uc.dei.aor.g8.jobapp.business.service.IJobInterviewFacade;
import pt.uc.dei.aor.g8.jobapp.business.service.IPositionFacade;

@Named
@ViewScoped
public class JobApplicationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private IJobApplicationFacade facade;
	@EJB
	private IPositionFacade positionFacade;
	@EJB
	private IJobInterviewFacade facadeInterview;
	@Inject
	private JobInterviewBean interviewBean;
	private long id;
	private IJobApplicationProxy jobApplication;
	private IPositionProxy submitPosition;
	private JobAppSituation status;


	public JobApplicationBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public List<IJobApplicationProxy> listOfAllAppNOTSpontaneousSituation(){
		return facade.listOfAllAppNOTSpontaneousSituation();
	}

	public IJobApplicationProxy getJobApplication() {
		return jobApplication;
	}

	public void setJobApplication(IJobApplicationProxy jobApplication) {
		this.jobApplication = jobApplication;
	}

	public void findById (){
		this.jobApplication = facade.findId(id);
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public JobInterviewBean getInterviewBean() {
		return interviewBean;
	}

	public void setInterviewBean(JobInterviewBean interviewBean) {
		this.interviewBean = interviewBean;
	}

	public IPositionProxy getSubmitPosition() {
		return submitPosition;
	}

	public void setSubmitPosition(IPositionProxy submitPosition) {
		this.submitPosition = submitPosition;
	}

	public List<JobAppSituation> getPossibleStatus(){
		return Arrays.asList(JobAppSituation.values());
	}
	
	public JobAppSituation getStatus() {
		return status;
	}

	public void setStatus(JobAppSituation status) {
		this.status = status;
	}


	public void scheduleInterview (){
		System.out.println("date interview: "+interviewBean.getDate());
		
		IJobInterviewProxy interviewProxy = facadeInterview.newInterview(interviewBean.getDate(), interviewBean.getUserInterviwer(), jobApplication, interviewBean.getScriptInterview());
		if (interviewProxy != null){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Scheduled interview with succeed.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error on scheduled interview.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public List <IScriptProxy> listScripOfPosition (){	
		return positionFacade.listScriptOfPosition(jobApplication.getPositionEntity());
	}
	
	public List<IJobApplicationProxy> findALLSpontaneousSituation(){
		return facade.listOfAllSpontaneousSituation();
	}
	
	public List<IPositionProxy> allPositionOpen (){
		return positionFacade.listOfAllOpenPosition();
	}
	
	public void submitPosition(){
		this.jobApplication.setPositionEntity(submitPosition);
		String msg = facade.submitPositionOnSpontaneousApplication(jobApplication);
		if ( msg.equals("sucess")){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Submit position save with succeed.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message2 = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, "");
			FacesContext.getCurrentInstance().addMessage(null, message2);
		} 
	}



}

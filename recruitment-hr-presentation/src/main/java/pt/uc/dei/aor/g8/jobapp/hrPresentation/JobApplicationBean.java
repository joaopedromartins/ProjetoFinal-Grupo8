package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobInterviewProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IScriptProxy;
import pt.uc.dei.aor.g8.jobapp.business.service.IJobApplicationFacade;
import pt.uc.dei.aor.g8.jobapp.business.service.IJobInterviewFacade;
import pt.uc.dei.aor.g8.jobapp.business.service.IPositionFacade;
import pt.uc.dei.aor.g8.jobapp.business.service.IScriptFacade;
import pt.uc.dei.aor.g8.jobapp.business.service.IUserFacade;

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


	public JobApplicationBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List <IJobApplicationProxy> findALL(){
		return facade.listOfAll();
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



}

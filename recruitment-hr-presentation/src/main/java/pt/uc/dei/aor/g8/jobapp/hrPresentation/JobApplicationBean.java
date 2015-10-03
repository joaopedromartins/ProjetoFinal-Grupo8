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
	@Inject
	private ProposalBean proposal;
	private long id;
	private IJobApplicationProxy jobApplication;
	private IPositionProxy submitPosition;
	private JobAppSituation situation;
	private String statusString;
	@Inject
	private UserBean currentUser;
	


	private boolean addInterview = false;
	private boolean editProposal = false;
	private boolean saveProposal = false;
	





	public JobApplicationBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public List<IJobApplicationProxy> listOfAllAppNOTSpontaneousSituation(){
		return facade.listOfAllAppNOTSpontaneousSituation();
	}
	
	public List<IJobApplicationProxy> listOfAllAppNOTSpontaneousSituationManager(){
		return facade.listOfAllAppNOTSpontaneousSituationManager(currentUser.getCurrentUser());
	}

	public UserBean getCurrentUser() {
		return currentUser;
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
		return situation;
	}

	public void setStatus(JobAppSituation status) {
		this.situation = status;
	}
	
	
	public String getStatusString() {
		return statusString;
	}


	public void setStatusString(String statusString) {
		if(statusString.equals("Rejected")){
			this.situation = JobAppSituation.REJECTED;
		} else if (statusString.equals("Hired")){
			this.situation = JobAppSituation.HIRED;
		}
		this.statusString = statusString;
	}


	public void scheduleInterview (){
		System.out.println("date interview: "+interviewBean.getDate());

		IJobInterviewProxy interviewProxy = facadeInterview.newInterview(interviewBean.getDate(), interviewBean.getUserInterviwer(), jobApplication, interviewBean.getScriptInterview());
		if (interviewProxy != null){
			this.addInterview = false;
			this.jobApplication = facade.findId(id);
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

	public void changeStatusJobApp(){		
		IJobApplicationProxy proxy = facade.updateSituationJobApplication(situation,jobApplication);
		if(proxy != null){
			this.jobApplication = proxy;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Job Application status update with succeed.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message2 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error on update Job Application Status.", "");
			FacesContext.getCurrentInstance().addMessage(null, message2);
		}
	}


	public boolean isAddInterview() {
		return addInterview;
	}


	public void setAddInterview(boolean addInterview) {
		this.addInterview = addInterview;
	}
	
	public void showPanelAddInterview(){
		this.addInterview = true;
	}


	public ProposalBean getProposal() {
		return proposal;
	}


	public void setProposal(ProposalBean proposal) {
		this.proposal = proposal;
	}
	
	public void saveProposal (){
		this.jobApplication = facade.saveProposal(proposal.getStatus(), proposal.getObservation(), jobApplication );
		if (jobApplication != null){
			proposal.setAddProposal(false);
			this.saveProposal = false;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Proposal submitted to candidate.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error on submitted proposal.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	public void saveEditProposal (){
		this.jobApplication = facade.editProposal(proposal.getStatus(), proposal.getObservation(), jobApplication );
		if (jobApplication != null){
			proposal.setAddProposal(false);
			editProposal = false;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Proposal submitted to candidate.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error on submitted proposal.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public boolean isEditProposal() {
		return editProposal;
	}


	public void setEditProposal(boolean editProposal) {
		this.editProposal = editProposal;
	}
	
	public void showPanelAddProposal(){
		if(jobApplication.getProposal()==null){
			this.proposal.setAddProposal(true);
			this.editProposal = false;
			this.saveProposal = true;
		} else {
			this.editProposal = true;
			this.proposal.setAddProposal(true);
			this.saveProposal = false;
		}
	}


	public boolean isSaveProposal() {
		return saveProposal;
	}


	public void setSaveProposal(boolean saveProposal) {
		this.saveProposal = saveProposal;
	}
	
	


	
	


}

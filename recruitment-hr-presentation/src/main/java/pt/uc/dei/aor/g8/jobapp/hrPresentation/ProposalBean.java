package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.ProposalStatus;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.service.IJobApplicationFacade;

@Named
@ViewScoped
public class ProposalBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProposalStatus status;
	private String observation;
	private IJobApplicationProxy jobApplication;
	
	@EJB
	private IJobApplicationFacade facade;

	public ProposalBean() {
		
	}

	
	public ProposalStatus getStatus() {
		return status;
	}
	public void setStatus(ProposalStatus status) {
		this.status = status;
	}
	
	public List<ProposalStatus> possibleStatusProposal(){
		return Arrays.asList(ProposalStatus.values());
	}
	
	public String getObservation() {
		return observation;
	}
	public IJobApplicationProxy getJobApplication() {
		return jobApplication;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}
	
	public void setJobApplication(IJobApplicationProxy jobApplication) {
		this.jobApplication = jobApplication;
	}


	public void saveProposal (IJobApplicationProxy jobApplictaion){
		this.jobApplication = facade.saveProposal(status, observation, jobApplictaion );
		if (jobApplication != null){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Proposal submitted to candidate.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error on submitted proposal.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	
	
	

}
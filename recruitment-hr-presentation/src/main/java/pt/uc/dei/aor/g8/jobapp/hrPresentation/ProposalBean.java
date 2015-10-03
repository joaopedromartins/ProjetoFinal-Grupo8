package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
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
	private boolean addProposal = false;
	
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


	


	public boolean isAddProposal() {
		return addProposal;
	}


	public void setAddProposal(boolean addProposal) {
		this.addProposal = addProposal;
	}
	
	
	public void showPanelAddProposal(){
		this.addProposal = true;
	}

	
	
	

}

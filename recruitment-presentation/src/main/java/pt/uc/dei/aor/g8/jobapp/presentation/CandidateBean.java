package pt.uc.dei.aor.g8.jobapp.presentation;


import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.service.ICandidateFacade;
import pt.uc.dei.aor.g8.jobapp.business.service.IJobApplicationFacade;



@Named
@SessionScoped
public class CandidateBean implements Serializable {
	private static final long serialVersionUID = 1L;


	@EJB
	private IJobApplicationFacade jobApplicationFacade;
	
	@Inject
	private LoginBean loginBean;
	
	private List<IJobApplicationProxy> listJobApplication;
	

	//constructors
	public CandidateBean() {
	}

	//Getters e Setters
	public List<IJobApplicationProxy> getListJobApplication() {
		listOfCandidateJobApplication();
		return listJobApplication;
	}
	
	
	
	//methods
	public List<IJobApplicationProxy> listOfCandidateJobApplication(){
		this.listJobApplication = jobApplicationFacade.listOfJobApplicationByUsername(loginBean.getUsername());
		return this.listJobApplication;
	}
}	

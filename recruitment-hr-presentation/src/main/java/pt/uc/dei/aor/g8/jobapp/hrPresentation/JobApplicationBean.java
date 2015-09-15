package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.service.IJobApplicationFacade;

@Named
@ViewScoped
public class JobApplicationBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private IJobApplicationFacade facade;
	
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
	

}

package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.business.service.IJobApplicationFacade;
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
	private IUserFacade userFacade;
	
	private IJobApplicationProxy jobApplication;
	private Date date;
	private Date time;
	private long id;
	private IUserProxy userInterviwer;

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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	

}

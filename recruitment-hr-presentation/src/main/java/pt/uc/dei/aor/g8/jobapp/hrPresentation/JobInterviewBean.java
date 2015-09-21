package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
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
	
	private Date date;
	private IUserProxy userInterviwer;
	
	
	
	
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

}

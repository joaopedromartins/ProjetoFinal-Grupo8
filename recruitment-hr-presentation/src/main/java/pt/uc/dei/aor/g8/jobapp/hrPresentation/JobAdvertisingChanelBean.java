package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;
import pt.uc.dei.aor.g8.jobapp.business.service.IJobAdversitingChanelFacade;

@Named
@RequestScoped
public class JobAdvertisingChanelBean {

	@EJB
	private IJobAdversitingChanelFacade facade;
	
	public JobAdvertisingChanelBean() {

	}
	
	public void addChanel(String chanelName){	
		IJobAdvertisingChanelProxy proxy;
		proxy=facade.addChanel(chanelName);
		
		if(proxy!=null){
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_INFO,
					"Job Advertising Channel added successfully.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Error adding Job Advertising Channel.", "");
			FacesContext.getCurrentInstance().addMessage(null, message);	
		}
	}
	
	public List<IJobAdvertisingChanelProxy> findAllChannels (){
		return facade.listOfAllChanel();
	}

}

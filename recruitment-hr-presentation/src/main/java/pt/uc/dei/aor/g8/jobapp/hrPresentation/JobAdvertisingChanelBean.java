package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;
import pt.uc.dei.aor.g8.jobapp.business.service.IJobAdversitingChanelFacade;

@Named
@ViewScoped
public class JobAdvertisingChanelBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IJobAdversitingChanelFacade facade;
	
	private String channelName;
	
	private boolean add = false;
	
	public JobAdvertisingChanelBean() {

	}
	
	public void addChannel(){	
		IJobAdvertisingChanelProxy proxy;
		proxy=facade.addChanel(channelName);
		if(proxy!=null){
			this.add=false;
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
	
	public void showAddChanel(){
		this.add=true;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public boolean isAdd() {
		return add;
	}

	public void setAdd(boolean add) {
		this.add = add;
	}

	
}

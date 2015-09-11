package pt.uc.dei.aor.g8.jobapp.presentation;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
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
	
	public JobAdvertisingChanelBean() {
	}
	
	
	public List<IJobAdvertisingChanelProxy> findAllChannels (){
		return facade.listOfAllChanel();
	}
	
	
	public String getChannelName() {
		return channelName;
	}

}

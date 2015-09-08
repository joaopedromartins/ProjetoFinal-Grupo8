package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import pt.uc.dei.aor.g8.jobapp.business.service.INotificationFacade;

@Named
@RequestScoped
public class NotificationBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private INotificationFacade facade;

	public NotificationBean() {
		
	}
	
	
	
	

}

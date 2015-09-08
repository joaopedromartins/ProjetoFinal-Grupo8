package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pt.uc.dei.aor.g8.jobapp.business.model.INotificationProxy;
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
	
	@Inject
	private UserBean userReceiver;
	
	private INotificationProxy notificationProxy;
	
	

	public NotificationBean() {
		
	}
	
	public List<INotificationProxy> allNotificationByUser (){
		return facade.allNotificationByUser(userReceiver.getCurrentUser());
	}
	
	public List<INotificationProxy> viewNotificationByUser(){
		return facade.viewNotificationByUser(userReceiver.getCurrentUser());		
	}
	
	public List<INotificationProxy> notViewNotificationByUser(){
		return facade.notViewNotificationByUser(userReceiver.getCurrentUser());
	}
	

	public INotificationProxy getNotificationProxy() {
		return notificationProxy;
	}

	public void setNotificationProxy(INotificationProxy notificationProxy) {
		this.notificationProxy = notificationProxy;
	}
	
	public void viewTrue(){
		
	}


}

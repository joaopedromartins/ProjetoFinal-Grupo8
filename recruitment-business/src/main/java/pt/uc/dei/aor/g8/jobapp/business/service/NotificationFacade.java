package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.model.INotificationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IProxyFactory;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.INotificationPersistenceService;

@Stateless
public class NotificationFacade implements INotificationFacade {
	@EJB
	private IProxyFactory factory;
	
	@EJB
	private INotificationPersistenceService service;
	
	
	@Override
	public INotificationProxy createNotification(String title, Date dateNotification, String message, String signature,
			IUserProxy userReciver) {
		
		INotificationProxy newNotification = factory.notification(title,dateNotification, message, signature, userReciver);
		return service.creatNotification(newNotification);
	}

}

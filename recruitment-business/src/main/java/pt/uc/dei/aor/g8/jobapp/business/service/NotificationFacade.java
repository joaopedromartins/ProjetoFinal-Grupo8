package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.Date;
import java.util.List;

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
	public INotificationProxy createNotification(String title, String message, String signature,
			IUserProxy userReciver) {
		Date dateNotification = new Date();
		dateNotification.getTime();
		INotificationProxy newNotification = factory.notification(title,dateNotification, message, signature, userReciver);
		return service.creatNotification(newNotification);
	}


	@Override
	public List<INotificationProxy> allNotificationByUser(IUserProxy userReceiver) {	
		return service.allNotificationByUser(userReceiver);
	}


	@Override
	public List<INotificationProxy> viewNotificationByUser(IUserProxy userReceiver) {
		return service.notViewNotificationByUser(userReceiver);
	}


	@Override
	public List<INotificationProxy> notViewNotificationByUser(IUserProxy userReceiver) {
		return service.notViewNotificationByUser(userReceiver);
	}


	@Override
	public INotificationProxy viewTrue(INotificationProxy proxy) {
		proxy.setViewNotification(true);
		return service.updateNotification(proxy);
	}

}

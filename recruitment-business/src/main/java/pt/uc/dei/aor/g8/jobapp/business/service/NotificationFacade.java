package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.uc.dei.aor.g8.jobapp.business.model.INotificationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IProxyFactory;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.INotificationPersistenceService;

@Stateless
public class NotificationFacade implements INotificationFacade {
	private static final Logger log = LoggerFactory.getLogger(NotificationFacade.class);

	@EJB
	private IProxyFactory factory;

	@EJB
	private INotificationPersistenceService service;


	@Override
	public INotificationProxy createNotification(String title, String message, String signature,
			IUserProxy userReciver) {
		try{
			Date dateNotification = new Date();
			dateNotification.getTime();
			INotificationProxy newNotification = factory.notification(title,dateNotification, message, signature, userReciver);
			return service.creatNotification(newNotification);
		} catch (EJBTransactionRolledbackException e){
			log.error(e.getMessage());
			return null;
		}
	}


	@Override
	public List<INotificationProxy> allNotificationByUser(IUserProxy userReceiver) {	
		try{
			return service.allNotificationByUser(userReceiver);
		} catch (EJBTransactionRolledbackException e){
			log.error(e.getMessage());
			return null;
		}
	}


	@Override
	public List<INotificationProxy> viewNotificationByUser(IUserProxy userReceiver) {
		try{
			return service.notViewNotificationByUser(userReceiver);
		} catch (EJBTransactionRolledbackException e){
			log.error(e.getMessage());
			return null;
		}
	}


	@Override
	public List<INotificationProxy> notViewNotificationByUser(IUserProxy userReceiver) {
		try{
			return service.notViewNotificationByUser(userReceiver);
		} catch (EJBTransactionRolledbackException e){
			log.error(e.getMessage());
			return null;
		}
	}


	@Override
	public INotificationProxy viewTrue(INotificationProxy proxy) {
		try {
			proxy.setViewNotification(true);
			return service.updateNotification(proxy);
		} catch (EJBTransactionRolledbackException e){
			log.error(e.getMessage());
			return null;
		}
	}

	@Override
	public INotificationProxy deleteNotification (INotificationProxy proxy){
		try {
			return service.deleteNotification(proxy);
		} catch (EJBTransactionRolledbackException e){
			log.error(e.getMessage());
			return null;
		}
	}

}

package pt.uc.dei.aor.g8.jobapp.persistence.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pt.uc.dei.aor.g8.jobapp.business.model.INotificationProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.INotificationPersistenceService;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.NotificationEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.IEntityAware;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.NotificationProxy;

@Stateless
public class NotificationPersistenceService implements INotificationPersistenceService {

	@PersistenceContext (unitName="recruitment")
	private EntityManager em;
	
	@Override
	public INotificationProxy creatNotification(INotificationProxy newNotification) {
		NotificationEntity entity = getEntity(newNotification);
		em.persist(entity);
		return new NotificationProxy (entity);
	}
	

	@SuppressWarnings("unchecked")
	private NotificationEntity getEntity(INotificationProxy notificationProxy) {
		if (notificationProxy instanceof IEntityAware<?>) {
			return ((IEntityAware<NotificationEntity>) notificationProxy).getEntity();
		}
		throw new IllegalStateException();
	}

}

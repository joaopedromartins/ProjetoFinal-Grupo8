package pt.uc.dei.aor.g8.jobapp.persistence.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pt.uc.dei.aor.g8.jobapp.business.model.INotificationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.INotificationPersistenceService;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.NotificationEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.UserEntity;
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
	
	@SuppressWarnings("unchecked")
	private UserEntity getEntityUser(IUserProxy userProxy) {
		if (userProxy instanceof IEntityAware<?>) {
			return ((IEntityAware<UserEntity>) userProxy).getEntity();
		}
		throw new IllegalStateException();
	}


	@Override
	public List<INotificationProxy> allNotificationByUser(IUserProxy userReceiver) {
		TypedQuery<NotificationEntity> query = em.createNamedQuery(NotificationEntity.ALL_NOTIFICATIONS_BY_USER,
				NotificationEntity.class);
		query.setParameter("userReceiver", getEntityUser(userReceiver));
		List<NotificationEntity> entity = query.getResultList();
		
		List <INotificationProxy> proxy = new ArrayList<>();
		for (NotificationEntity n: entity){
			proxy.add(new NotificationProxy(n));
		}

		return proxy;
	}


	@Override
	public List<INotificationProxy> viewNotificationByUser(IUserProxy userReceiver) {
		TypedQuery<NotificationEntity> query = em.createNamedQuery(NotificationEntity.NOT_VIEW_NOTIFICATIONS_BY_USER,
				NotificationEntity.class);
		query.setParameter("userReceiver", getEntityUser(userReceiver));
		List<NotificationEntity> entity = query.getResultList();
		
		List<INotificationProxy> proxy = new ArrayList<>();
		for (NotificationEntity n: entity){
			proxy.add(new NotificationProxy(n));
		}
		return proxy;
	}


	@Override
	public List<INotificationProxy> notViewNotificationByUser(IUserProxy userReceiver) {
		TypedQuery<NotificationEntity> query = em.createNamedQuery(NotificationEntity.VIEW_NOTIFICATIONS_BY_USER,
				NotificationEntity.class);
		query.setParameter("userReceiver", getEntityUser(userReceiver));
		List<NotificationEntity> entity = query.getResultList();
		
		List<INotificationProxy> proxy = new ArrayList<>();
		for (NotificationEntity n: entity){
			proxy.add(new NotificationProxy(n));
		}
		return proxy;
	}
	
	@Override
	public INotificationProxy updateNotification(INotificationProxy notificationProxy) {
		NotificationEntity entity = getEntity(notificationProxy);
		entity=em.merge(entity);
		return new NotificationProxy(entity);
	}

	@Override
	public INotificationProxy deleteNotification(INotificationProxy newNotification) {
		NotificationEntity entity = getEntity(newNotification);
		entity = em.merge(entity);
		em.remove(entity);
		return new NotificationProxy (entity);
	}
	
	

}

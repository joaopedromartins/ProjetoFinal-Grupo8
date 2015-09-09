package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import java.util.Date;

import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.model.INotificationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.NotificationEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.UserEntity;

@Stateless
public class NotificationProxy implements INotificationProxy, IEntityAware<NotificationEntity> {

	private NotificationEntity entity;
	
	
	public NotificationProxy() {
		
	}

	public NotificationProxy(String title, Date notificationDate, String message, String signature, IUserProxy userReceiver) {
		this.entity = new NotificationEntity(title,notificationDate,message,signature,userConverterProxyToEntity(userReceiver));
	}

	public NotificationProxy (NotificationEntity notification){
		if (notification==null){
			this.entity = new NotificationEntity();
		} else {
			this.entity = notification;
		}
	}


	@Override
	public NotificationEntity getEntity() {
		return entity;
	}
	
	

	@Override
	public String getTitle() {
		return entity.getTitle();
	}

	@Override
	public void setTitle(String title) {
		entity.setTitle(title);
	}

	@Override
	public Date getNotificationDate() {
		return entity.getNotificationDate();
	}

	@Override
	public void setNotificationDate(Date notificationDate) {
		entity.setNotificationDate(notificationDate);		
	}

	@Override
	public String getMessage() {
		return entity.getMessage();
	}

	@Override
	public void setMessage(String message) {
		entity.setMessage(message);
	}

	@Override
	public String getSignature() {
		return entity.getSignature();
	}

	@Override
	public void setSignature(String signature) {
		entity.setSignature(signature);
	}

	@Override
	public IUserProxy getUserReciver() {
		IUserProxy proxy = new UserProxy(entity.getUserReciver());
		return proxy;
	}

	@Override
	public void setUserReciver(IUserProxy userReciver) {
		entity.setUserReciver(userConverterProxyToEntity(userReciver));
		
	}
	
	@SuppressWarnings( "unchecked" )
	private UserEntity userConverterProxyToEntity (IUserProxy proxy){
		UserEntity entityUser= ((IEntityAware<UserEntity>)proxy).getEntity();
		return entityUser;
	}

	@Override
	public boolean isViewNotification() {
		return entity.isViewNotification();
	}

	@Override
	public void setViewNotification(boolean viewNotification) {
		entity.setViewNotification(viewNotification);
	}

}

package pt.uc.dei.aor.g8.jobapp.business.persistence;

import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.model.INotificationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;

public interface INotificationPersistenceService {

	public INotificationProxy creatNotification(INotificationProxy newNotification);
	public List <INotificationProxy> allNotificationByUser (IUserProxy userReceiver);
	public List <INotificationProxy> viewNotificationByUser (IUserProxy userReceiver);
	public List <INotificationProxy> notViewNotificationByUser (IUserProxy userReceiver);
	
}

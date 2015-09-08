package pt.uc.dei.aor.g8.jobapp.business.persistence;

import pt.uc.dei.aor.g8.jobapp.business.model.INotificationProxy;

public interface INotificationPersistenceService {

	public INotificationProxy creatNotification(INotificationProxy newNotification);
	
}

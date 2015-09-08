package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.model.INotificationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;

public interface INotificationFacade {
	
	public INotificationProxy createNotification (String title, String message, String signature, IUserProxy userReceiver );
	public List<INotificationProxy>	allNotificationByUser(IUserProxy userReceiver);
	public List<INotificationProxy>	viewNotificationByUser(IUserProxy userReceiver);
	public List<INotificationProxy>	notViewNotificationByUser(IUserProxy userReceiver);
	public INotificationProxy viewTrue(INotificationProxy proxy);
	
}

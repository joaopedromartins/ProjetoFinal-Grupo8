package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.Date;

import pt.uc.dei.aor.g8.jobapp.business.model.INotificationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;

public interface INotificationFacade {
	
	public INotificationProxy createNotification (String title, Date dateNotification, String message, String signature, IUserProxy userReciver );
		
}

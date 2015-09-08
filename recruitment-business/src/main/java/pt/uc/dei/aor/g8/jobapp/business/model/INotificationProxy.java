package pt.uc.dei.aor.g8.jobapp.business.model;

import java.util.Date;

public interface INotificationProxy {
	
	public String getTitle();
	public void setTitle(String title);

	public Date getNotificationDate();
	public void setNotificationDate(Date notificationDate);

	public String getMessage();
	public void setMessage(String message);

	public String getSignature();
	public void setSignature(String signature);

	public IUserProxy getUserReciver();
	public void setUserReciver(IUserProxy userReciver);
	
	public boolean isViewNotification();
	public void setViewNotification(boolean viewNotification);

}

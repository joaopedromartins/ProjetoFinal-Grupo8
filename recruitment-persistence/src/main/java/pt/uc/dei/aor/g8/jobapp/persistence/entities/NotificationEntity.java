package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Notification")
@NamedQueries({
	@NamedQuery(name = "NotificationEntity.allNotificationsByUser", query = "SELECT n FROM NotificationEntity n WHERE n.userReceiver=:userReceiver"),
	@NamedQuery(name = "NotificationEntity.viewNotificationsByUser", query = "SELECT n FROM NotificationEntity n WHERE n.userReceiver=:userReceiver AND n.viewNotification IS TRUE "),
	@NamedQuery(name = "NotificationEntity.notViewNotificationsByUser", query = "SELECT n FROM NotificationEntity n WHERE n.userReceiver=:userReceiver AND n.viewNotification IS FALSE "),
})
public class NotificationEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String ALL_NOTIFICATIONS_BY_USER = "NotificationEntity.allNotificationsByUser";
	public static final String VIEW_NOTIFICATIONS_BY_USER = "NotificationEntity.viewNotificationsByUser";
	public static final String NOT_VIEW_NOTIFICATIONS_BY_USER = "NotificationEntity.notViewNotificationsByUser";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String title;

	@Temporal(TemporalType.DATE)
	@Column
	private Date notificationDate;

	@Column
	private String message;
	
	
	
	@Column 
	private String signature;
	
	@Column
	private boolean viewNotification;
	
	@ManyToOne
	private UserEntity userReceiver;

	public NotificationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotificationEntity(String title, Date notificationDate, String message, String signature,
			UserEntity userReceiver) {
		super();
		this.title = title;
		this.notificationDate = notificationDate;
		this.message = message;
		this.signature = signature;
		this.userReceiver = userReceiver;
		this.viewNotification = false;
	}
	
	

	public boolean isViewNotification() {
		return viewNotification;
	}

	public void setViewNotification(boolean viewNotification) {
		this.viewNotification = viewNotification;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getNotificationDate() {
		return notificationDate;
	}

	public void setNotificationDate(Date notificationDate) {
		this.notificationDate = notificationDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public UserEntity getUserReciver() {
		return userReceiver;
	}

	public void setUserReciver(UserEntity userReceiver) {
		this.userReceiver = userReceiver;
	}
	
	

}

package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Notification")
public class NotificationEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	@ManyToOne
	private UserEntity userReciver;

	public NotificationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotificationEntity(String title, Date notificationDate, String message, String signature,
			UserEntity userReciver) {
		super();
		this.title = title;
		this.notificationDate = notificationDate;
		this.message = message;
		this.signature = signature;
		this.userReciver = userReciver;
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
		return userReciver;
	}

	public void setUserReciver(UserEntity userReciver) {
		this.userReciver = userReciver;
	}
	
	

}

package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.RoleType;


@Entity
@NamedQueries({
	@NamedQuery(name = "UserEntity.findUserByUsername", query = "SELECT u FROM UserEntity u WHERE u.username=:username"),
	@NamedQuery(name = "UserEntity.findUserByEmail", query = "SELECT u FROM UserEntity u WHERE u.email=:email"),
	@NamedQuery(name = "UserEntity.findManager", query = "SELECT u FROM UserEntity u WHERE 'MANAGER' member of u.roles"),
	@NamedQuery(name = "UserEntity.findInterviewer", query = "SELECT u FROM UserEntity u WHERE 'INTERVIEWER' member of u.roles"),
	@NamedQuery(name = "UserEntity.verifyPassworOfUser", query = "SELECT u FROM UserEntity u Where u.username=:username AND u.password=:password")
})
public class UserEntity {
	//private static final long serialVersionUID = 1L;

	public static final String FIND_USER_BY_USERNAME = "UserEntity.findUserByUsername";
	public static final String FIND_USER_BY_EMAIL = "UserEntity.findUserByEmail";
	public static final String FIND_MANAGER = "UserEntity.findManager";
	public static final String FIND_INTERVIEWER = "UserEntity.findInterviewer";
	public static final String VERIFY_PASSWORD_OF_USER = "UserEntity.verifyPassworOfUser";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true)
	private long id;

	@Column(length = 255, nullable = false, unique = true)
	private String username;

	@Column(length = 255, nullable = false)
	private String password;

	@Column(length = 60, nullable = false)
	private String lastname;

	@Column(length = 60, nullable = false)
	private String firstname;

	@Column(length = 255, nullable = false, unique = true)
	private String email;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="role")
	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private List<RoleType> roles;

	@OneToMany ( cascade=CascadeType.ALL , mappedBy="managerPosition")
	private List <PositionEntity> position;

	@OneToMany ( cascade=CascadeType.ALL , mappedBy="userReceiver")
	private List <NotificationEntity> notification;

	@ManyToMany ( cascade=CascadeType.ALL , mappedBy="interviewers" )
	private List <JobInterviewEntity> interview;


	//Constructors
	public UserEntity() {
	}

	public UserEntity(String login, String password, String lastname, String firstname, String email, List<RoleType> roles) {
		this.username = login;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;

		this.roles = new ArrayList<>();
		this.roles.addAll(roles);
	}


	//Getters and Setters

	public List<RoleType> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleType> roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public List<PositionEntity> getPosition() {
		return position;
	}

	public void setPosition(List<PositionEntity> position) {
		this.position = position;
	}

	public List<NotificationEntity> getNotification() {
		return notification;
	}

	public void setNotification(List<NotificationEntity> notification) {
		this.notification = notification;
	}

	public List<JobInterviewEntity> getInterview() {
		return interview;
	}

	public void setInterview(List<JobInterviewEntity> interview) {
		this.interview = interview;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserEntity [lastname=" + lastname + ", firstname=" + firstname + "]";
	}

}

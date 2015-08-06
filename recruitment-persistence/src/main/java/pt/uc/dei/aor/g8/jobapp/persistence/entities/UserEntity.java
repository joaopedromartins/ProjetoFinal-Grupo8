package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(length = 255, nullable = false)
    private String login;
	
	@Column(length = 255, nullable = false)
    private String password;
	
	@Column(length = 60, nullable = false)
    private String lastname;

	@Column(length = 60, nullable = false)
    private String firstname;
	
	@Column(length = 255, nullable = false)
    private String email;
	
	@Column
	private RoleType role;
	
	
	
	
	//Constructors
	public UserEntity() {
	}
	
	public UserEntity(String login, String password, String lastname, String firstname, String email) {
		this.login = login;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
	}
	
	//Getters and Setters
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
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
	
	public long getId() {
		return id;
	}
}

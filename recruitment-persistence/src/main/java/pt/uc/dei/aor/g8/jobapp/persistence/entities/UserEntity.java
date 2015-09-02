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
import javax.persistence.OneToMany;

import pt.uc.dei.aor.g8.business.enumeration.RoleType;


@Entity
public class UserEntity {
	//private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true)
	private long id;

	@Column(length = 255, nullable = false)
	private String username;

	@Column(length = 255, nullable = false)
	private String password;

	@Column(length = 60, nullable = false)
	private String lastname;

	@Column(length = 60, nullable = false)
	private String firstname;

	@Column(length = 255, nullable = false)
	private String email;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="role")
	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private List<RoleType> roles;


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
	
	
	
	
	@OneToMany ( cascade=CascadeType.ALL , mappedBy="managerPosition")
	private List<PositionEntity> position;
	


	//Getters and Setters

	public List<RoleType> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleType> roles) {
		this.roles = roles;
	}

	public String getLogin() {
		return username;
	}
	public void setLogin(String login) {
		this.username = login;
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

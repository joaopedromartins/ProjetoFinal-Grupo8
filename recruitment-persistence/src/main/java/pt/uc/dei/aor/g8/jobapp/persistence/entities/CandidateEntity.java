package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity@NamedQueries({
	@NamedQuery(name = "CandidateEntity.findCandidateByUsername", query = "SELECT c FROM CandidateEntity c WHERE c.username=:username"),
	@NamedQuery(name = "CandidateEntity.findCandidateByEmail", query = "SELECT c FROM CandidateEntity c WHERE c.email=:email"),
})
@Table(name = "Candidate")
public class CandidateEntity {
	
	public static final String FIND_CANDIDATE_BY_USERNAME = "UserEntity.findCandidateByUsername";
	public static final String FIND_CANDIDATE_BY_EMAIL = "UserEntity.findCandidateByEmail";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
		
	@Column(length = 15)
    private BigInteger mobile;
	
	@Column
    private String role;
	
	
	//Constructors
	public CandidateEntity() {
		super();
	}


	public CandidateEntity(String username, String password, String lastname, String firstname, String email, BigInteger mobile) {
		super();
		this.username = username;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
		this.mobile = mobile;
		this.role = "CANDIDATE";
	}
	
	
	
	//Getters and setters
	
	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String login) {
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

	public BigInteger getMobile() {
		return mobile;
	}
	public void setMobile(BigInteger mobile) {
		this.mobile = mobile;
	}

}


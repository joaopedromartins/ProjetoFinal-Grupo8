package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Candidate")
@PrimaryKeyJoinColumn(name = "id")
public class CandidateEntity {
	
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
	
	@Column(length = 255, nullable = false)
    private String address;
	
	@Column(length = 30, nullable = false)
    private String city;
	
	@Column(length = 30, nullable = false)
    private String country;
	
	@Column(length = 15)
    private BigInteger phone;
	
	@Column(length = 15)
    private BigInteger mobile;
	
	@Column(length = 60, nullable = false)
    private String diploma;
	
	@Column(length = 60, nullable = false)
    private String school;
	
	@Column
    private String letter;
	
	@Column
    private String cv;
	
	public CandidateEntity() {
		super();
	}

	public CandidateEntity(String login, String password, String lastname, String firstname, String email) {
		this.login = login;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
	}

}

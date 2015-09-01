package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Candidate")
public class CandidateEntity {
	
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
	
	@Column
    private String role;
	
	
	//Constructors
	public CandidateEntity() {
		super();
	}


	public CandidateEntity(String login, String password, String lastname, String firstname, String email) {
		this.username = login;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
		this.role = "CANDIDATE";
	}
	
	
	
	//Getters and setters
	
	public long getId() {
		return id;
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

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public BigInteger getPhone() {
		return phone;
	}
	public void setPhone(BigInteger phone) {
		this.phone = phone;
	}

	public BigInteger getMobile() {
		return mobile;
	}
	public void setMobile(BigInteger mobile) {
		this.mobile = mobile;
	}

	public String getDiploma() {
		return diploma;
	}
	public void setDiploma(String diploma) {
		this.diploma = diploma;
	}

	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}

	public String getLetter() {
		return letter;
	}
	public void setLetter(String letter) {
		this.letter = letter;
	}

	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}

	

}


package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class JobApplicationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true)
	private long id;
		
	@Column(length = 60, nullable = false)
    private String firstname;
	
	@Column(length = 60, nullable = false)
    private String lastname;

	@Column(length = 255, nullable = false)
    private String email;
	
	@Column(length = 255, nullable = false)
    private String address;
	
	@Column(length = 255, nullable = false)
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
    private JobAdvertisingChanelEntity source;

	@Column
	private CandidateEntity candidateEntity;
	
	@Column
	private PositionEntity positionEntity;
	
	@Column
	private UserEntity userEntity;

	
	//Getters and Setters
	@ManyToOne
	@JoinColumn(name = "id")
	public CandidateEntity getCandidateEntity() {
		return candidateEntity;
	}
	
	@ManyToMany
	@JoinColumn(name = "id")
	public PositionEntity getPositionEntity() {
		return positionEntity;
	}
	
	@ManyToOne
	@JoinColumn(name = "id")
	public UserEntity getUserEntity() {
		return userEntity;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public JobAdvertisingChanelEntity getSource() {
		return source;
	}
	public void setSource(JobAdvertisingChanelEntity source) {
		this.source = source;
	}

	public long getId() {
		return id;
	}
	
	//Constructors
	public JobApplicationEntity(){
		super();
	}

	public JobApplicationEntity(String firstname, String lastname, String email, String address, String city,
			String country, BigInteger phone, BigInteger mobile, String diploma, String school, String letter,
			String cv, JobAdvertisingChanelEntity source) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.mobile = mobile;
		this.diploma = diploma;
		this.school = school;
		this.letter = letter;
		this.cv = cv;
		this.source = source;
	}
	
	
}

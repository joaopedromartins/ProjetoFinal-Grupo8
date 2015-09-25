package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.JobAppSituation;

@Entity
@Table(name = "JobApplication")
@NamedQueries({
	@NamedQuery(name = "JobApplication.listOfAllCandidateJobApplication", 
		query = "SELECT j FROM JobApplicationEntity j inner join j.candidateEntity c " +
				" where c.username like :login ") ,
	@NamedQuery(name = "JobApplication.listOfAllJobApplicationToPositionCodeAndUsername", 
		query = "SELECT j FROM JobApplicationEntity j inner join j.candidateEntity c " + 
				" inner join j.positionEntity p where c.username like :username and p.code like :code "),
	@NamedQuery(name = "JobApplication.listOfAll", query = "SELECT jA FROM JobApplicationEntity jA "),
	@NamedQuery(name = "JobApplication.listOfJobApplicationByCandidate", query = "SELECT jA FROM JobApplicationEntity jA WHERE jA.candidateEntity=:candidate"),
	@NamedQuery(name = "JobApplication.listOfAllSpontaneousJobApplication", query = "SELECT jA FROM JobApplicationEntity jA WHERE jA.jobappSpontaneous = TRUE"),
	@NamedQuery(name = "JobApplication.findJobAppSpontaneousByCandidate", query = "SELECT jA FROM JobApplicationEntity jA WHERE jA.candidateEntity=:candidateEntity AND jA.jobappSpontaneous = TRUE"),
})
public class JobApplicationEntity {

	public static final String LIST_OF_ALL_CANDIDATE_JOB_APPLICATION = "JobApplication.listOfAllCandidateJobApplication";	
	public static final String LIST_OF_ALL_JOB_APPLICATION_TO_POSITION_CODE_AND_USERNAME = "JobApplication.listOfAllJobApplicationToPositionCodeAndUsername";
	public static final String LIST_OF_ALL = "JobApplication.listOfAll";
	public static final String LIST_OF_JOBAPPLICATION_BY_CANDIDATE = "JobApplication.listOfJobApplicationByCandidate";
	public static final String LIST_OF_ALL_SPONTANEOUS_JOBAPPLICATION = "JobApplication.listOfAllSpontaneousJobApplication";
	public static final String FIND_SPONTANEOUS_JOBAPP_BY_CANDIDATE = "JobApplication.findJobAppSpontaneousByCandidate";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date jobAppDate;

	@Column(length = 255, nullable = false)
	private String address;

	@Column(length = 255, nullable = false)
	private String city;

	@Column(length = 30, nullable = false)
	private String country;

	@Column(length = 15)
	private String phone;

	@Column(length = 60, nullable = false)
	private String diploma;

	@Column(length = 60, nullable = false)
	private String school;

	@Column
	private String letter;

	@Column
	private String cv;

	@Enumerated(EnumType.STRING)
	@Column
	private JobAppSituation situation;

	@Column
	private String jobPositionSource;

	@ManyToOne
	private CandidateEntity candidateEntity;

	@ManyToOne
	private PositionEntity positionEntity;

	@OneToMany (cascade=CascadeType.ALL , mappedBy="jobapplication",fetch = FetchType.EAGER)
	private List <JobInterviewEntity> interviews;
	
	@OneToOne (cascade=CascadeType.ALL)
	private ProposalEntity proposal;

	@Column
	private boolean jobappSpontaneous = false;


	//Constructors
	public JobApplicationEntity(){
		super();
	}

	public JobApplicationEntity(
			String address, String city, String country, String phone, String diploma,
			String school, String letter, String cv, String source, CandidateEntity candidateEntity, PositionEntity positionEntity)  {
		super();
		this.jobAppDate = new Date();
		this.address = address;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.diploma = diploma;
		this.school = school;
		this.letter = letter;
		this.cv = cv;
		this.jobPositionSource = source;
		this.situation = JobAppSituation.SUBMITTED;
		this.candidateEntity = candidateEntity;
		this.positionEntity = positionEntity;
		this.jobappSpontaneous = false;
	}
	
	public JobApplicationEntity(
			String address, String city, String country, String phone, String diploma,
			String school, String letter, String cv, String source, CandidateEntity candidateEntity)  {

		this.jobAppDate = new Date();
		this.address = address;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.diploma = diploma;
		this.school = school;
		this.letter = letter;
		this.cv = cv;
		this.jobPositionSource = source;
		this.candidateEntity = candidateEntity;
		this.situation = JobAppSituation.SPONTANEOUS;	
		this.positionEntity = null;
		this.jobappSpontaneous = true;
	}


	//Getters and Setters
	
	public Date getJobAppDate() {
		return jobAppDate;
	}

	public void setJobAppDate(Date jobAppDate) {
		this.jobAppDate = jobAppDate;
	}

	public CandidateEntity getCandidateEntity() {
		return candidateEntity;
	}

	public PositionEntity getPositionEntity() {
		return positionEntity;
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

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getJobPositionSource() {
		return jobPositionSource;
	}

	public void setJobPositionSource(String jobPositionSource) {
		this.jobPositionSource = jobPositionSource;
	}

	public JobAppSituation getSituation() {
		return situation;
	}
	public void setSituation(JobAppSituation situation) {
		this.situation = situation;
	}

	public void setCandidateEntity(CandidateEntity candidateEntity) {
		this.candidateEntity = candidateEntity;
	}
	public void setPositionEntity(PositionEntity positionEntity) {
		this.positionEntity = positionEntity;
	}

	public long getId() {
		return id;
	}


	public List<JobInterviewEntity> getInterviews() {
		return interviews;
	}

	public void setInterviews(List<JobInterviewEntity> interviewers) {
		this.interviews = interviewers;
	}

	public ProposalEntity getProposal() {
		return proposal;
	}

	public void setProposal(ProposalEntity proposal) {
		this.proposal = proposal;
	}

	public boolean isJobappSpontaneous() {
		return jobappSpontaneous;
	}

	public void setJobappSpontaneous(boolean jobappSpontaneous) {
		this.jobappSpontaneous = jobappSpontaneous;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((candidateEntity == null) ? 0 : candidateEntity.hashCode());
		result = prime * result + ((positionEntity == null) ? 0 : positionEntity.hashCode());
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
		JobApplicationEntity other = (JobApplicationEntity) obj;
		if (candidateEntity == null) {
			if (other.candidateEntity != null)
				return false;
		} else if (!candidateEntity.equals(other.candidateEntity))
			return false;
		if (positionEntity == null) {
			if (other.positionEntity != null)
				return false;
		} else if (!positionEntity.equals(other.positionEntity))
			return false;
		return true;
	}


}

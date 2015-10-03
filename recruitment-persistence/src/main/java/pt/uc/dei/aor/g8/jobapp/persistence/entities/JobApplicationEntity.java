package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
				" where c.username like :login " + 
				" and j.situation NOT LIKE 'SPONTANEOUS' and j.situation NOT LIKE 'DELETE_BY_CANDIDATE' ") ,
	@NamedQuery(name = "JobApplication.listOfAllCandidateSpontaneousJobApplication", 
		query = "SELECT j FROM JobApplicationEntity j inner join j.candidateEntity c " +
				" where c.username like :login and j.jobappSpontaneous = TRUE and " +
				" j.situation NOT LIKE 'DELETE_BY_CANDIDATE'") ,
	@NamedQuery(name = "JobApplication.listOfAllJobApplicationToPositionCodeAndUsername", 
		query = "SELECT j FROM JobApplicationEntity j inner join j.candidateEntity c " + 
				" inner join j.positionEntity p where c.username like :username and p.code like :code "),
	@NamedQuery(name = "JobApplication.listOfJobApplicationByCandidate", query = "SELECT jA FROM JobApplicationEntity jA WHERE jA.candidateEntity=:candidate AND jA.situation NOT LIKE 'SPONTANEOUS'"),
	@NamedQuery(name = "JobApplication.listOfAllSpontaneousJobApplication", query = "SELECT jA FROM JobApplicationEntity jA WHERE jA.jobappSpontaneous = TRUE"),
	@NamedQuery(name = "JobApplications.listOfAllSpontaneousSituation", query = "SELECT jA FROM JobApplicationEntity jA WHERE jA.situation LIKE 'SPONTANEOUS'"),
	@NamedQuery(name = "JobApplication.findJobAppSpontaneousSituationByCandidate", query = "SELECT jA FROM JobApplicationEntity jA WHERE jA.candidateEntity=:candidateEntity AND jA.situation LIKE 'SPONTANEOUS'"),
	@NamedQuery(name = "JobApplication.listOfJobApplicationByCandidateAndPosition", query = "SELECT jA FROM JobApplicationEntity jA WHERE jA.candidateEntity=:candidate AND jA.positionEntity=:position"),
	@NamedQuery(name = "JobApplication.listOfAllApplicationNotSituationSpontaneous", query = "SELECT jA FROM JobApplicationEntity jA Where jA.situation NOT LIKE 'SPONTANEOUS'"),
	@NamedQuery(name = "JobApplication.listOfAllAppBetweenDates", query = "SELECT jA FROM JobApplicationEntity jA Where jA.jobAppDate >= :startDate AND jA.jobAppDate < :endDate"),
	@NamedQuery(name = "JobApplication.listOfAllAppSpontaneousBetweenDates", query = "SELECT jA FROM JobApplicationEntity jA Where jA.jobappSpontaneous = TRUE AND jA.jobAppDate >= :startDate AND jA.jobAppDate < :endDate"),
	@NamedQuery(name = "JobApplication.listOfAllAppByPosition", query = "SELECT jA FROM JobApplicationEntity jA WHERE jA.positionEntity=:position"),
	@NamedQuery(name = "JobApplication.reportAverageTimeForFirstInterview", 
		query = "SELECT (i.interviewDate - j.jobAppDate)  " +
				" FROM JobApplicationEntity j INNER JOIN j.interviews i  WHERE " +
				" j.jobAppDate <= i.interviewDate AND " +
				" i.interviewDate >= :startdate AND i.interviewDate < :enddate "),
//		query = "SELECT 1.0*count ( i.interviewDate) AS DAYS FROM JobApplicationEntity j INNER JOIN j.interviews i WHERE j.jobAppDate <= i.interviewDate AND i.interviewDate >= :startdate AND i.interviewDate < :enddate " ),
	@NamedQuery(name = "JobApplication.reportAverageTimeForHiring", 
		query = "SELECT AVG ( j.hiredDate - j.jobAppDate) AS days " +
				" FROM JobApplicationEntity j WHERE j.situation like 'HIRE%' and" +
				" j.jobAppDate <= j.hiredDate AND " +
				" j.hiredDate >= :startdate AND j.hiredDate < :enddate "),
	@NamedQuery(name = "JobApplication.listOfAllAppRejectedBetweenDates", query = "SELECT jA FROM JobApplicationEntity jA WHERE jA.situation LIKE 'REJECTED' AND jA.jobAppDate >= :startDate AND jA.jobAppDate < :endDate"),
	@NamedQuery(name = "JobApplication.listOfAllAppWithInterviewBetweenDates", query = "SELECT jA FROM JobApplicationEntity jA WHERE size(jA.interviews) > 0 AND jA.jobAppDate >= :start AND jA.jobAppDate < :end"),
})
public class JobApplicationEntity {

	public static final String LIST_OF_ALL_CANDIDATE_JOB_APPLICATION = "JobApplication.listOfAllCandidateJobApplication";	
	public static final String LIST_SPONTANEOUS_JOB_APPLICATION_BY_USERNAME = "JobApplication.listOfAllCandidateSpontaneousJobApplication";
	public static final String LIST_OF_ALL_JOB_APPLICATION_TO_POSITION_CODE_AND_USERNAME = "JobApplication.listOfAllJobApplicationToPositionCodeAndUsername";
	public static final String LIST_OF_JOBAPPLICATION_BY_CANDIDATE = "JobApplication.listOfJobApplicationByCandidate";
	public static final String LIST_OF_ALL_SPONTANEOUS_JOBAPPLICATION = "JobApplication.listOfAllSpontaneousJobApplication";
	public static final String LIST_OF_ALL_SPONTANEOUS_SITUATION = "JobApplications.listOfAllSpontaneousSituation";
	public static final String FIND_SPONTANEOUS_JOBAPP_BY_CANDIDATE = "JobApplication.findJobAppSpontaneousSituationByCandidate";
	public static final String LIST_OF_JOBAPPLICATION_BY_CANDIDATE_AND_POSITION = "JobApplication.listOfJobApplicationByCandidateAndPosition";
	public static final String LIST_OF_ALL_APPLICATION_NOT_SITUATION_SPONTANEOUS ="JobApplication.listOfAllApplicationNotSituationSpontaneous" ;
	public static final String LIST_OF_ALL_APP_BETWEEN_DATES = "JobApplication.listOfAllAppBetweenDates";
	public static final String LIST_OF_ALL_APP_SPONTANEOUS_BETWEEN_DATES = "JobApplication.listOfAllAppSpontaneousBetweenDates";
	public static final String LIST_OF_ALL_APP_BY_POSITION = "JobApplication.listOfAllAppByPosition";
	public static final String AVERAGE_TIME_FOR_FIRST_INTERVIEW = "JobApplication.reportAverageTimeForFirstInterview";
	public static final String AVERAGE_TIME_TO_HIRING = "JobApplication.reportAverageTimeForHiring";
	public static final String LIST_OF_ALL_APP_REJECTED_BETWEEN_DATES = "JobApplication.listOfAllAppRejectedBetweenDates"; 
	public static final String LIST_OF_ALL_APP_WITH_INTERVIEW_BETWEEN_DATES = "JobApplication.listOfAllAppWithInterviewBetweenDates";

	
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

	@Column (length = 1000)
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
	private Set <JobInterviewEntity> interviews;
	
	@OneToOne (cascade=CascadeType.ALL)
	private ProposalEntity proposal;

	@Column
	private boolean jobappSpontaneous = false;

	@Temporal(TemporalType.DATE)
	@Column
	private Date hiredDate;

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
		return new ArrayList<>(interviews);
	}

	public void setInterviews(List<JobInterviewEntity> interviewers) {
		this.interviews = new HashSet<>();
		this.interviews.addAll(interviews);
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

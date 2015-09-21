package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Interview")
public class JobInterviewEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date interviewDate;
	
	@ManyToOne
	private UserEntity interviewer;
	
	@ManyToOne
	private JobApplicationEntity jobapplication;
	
	@OneToMany
	private List<AnswerInterviewEntity> answer;
	

	public JobInterviewEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	public JobInterviewEntity(Date interviewDate, UserEntity interviewer,
			JobApplicationEntity jobapplication ) {
		super();
		this.interviewDate = interviewDate;
		this.interviewer = interviewer;
		this.jobapplication = jobapplication;
		
	}




	public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	public UserEntity getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(UserEntity interviewer) {
		this.interviewer = interviewer;
	}


	public JobApplicationEntity getJobapplication() {
		return jobapplication;
	}

	public void setJobapplication(JobApplicationEntity jobapplication) {
		this.jobapplication = jobapplication;
	}

	public List<AnswerInterviewEntity> getAnswer() {
		return answer;
	}

	public void setAnswer(List<AnswerInterviewEntity> answer) {
		this.answer = answer;
	}
		
	
}

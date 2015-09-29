package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Interview")
@NamedQueries({
	@NamedQuery(name = "Interview.listOfAllInterviews", query = "SELECT i FROM JobInterviewEntity i"), 
	@NamedQuery(name = "Interview.listInterviewsOfInterviewer", query = "SELECT i FROM JobInterviewEntity i where :interviewer member of i.interviewers"),
})
public class JobInterviewEntity implements Serializable{ 
	
	public static final String LIST_OF_ALL_INTERVIEWS = "Interview.listOfAllInterviews";
	public static final String LIST_INTERVIEWS_OF_INTERVIEWER = "Interview.listInterviewsOfInterviewer";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date interviewDate;
	
	@ManyToOne
	private ScriptEntity scriptInterview;

	@ManyToMany (fetch = FetchType.EAGER)
	private Set<UserEntity> interviewers;

	@ManyToOne
	private JobApplicationEntity jobapplication;

	@OneToMany (cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<AnswerInterviewEntity> answer;
	
	@Column
	private boolean finished = false;


	public JobInterviewEntity() {
		super();
		// TODO Auto-generated constructor stub
	}



	public JobInterviewEntity(Date interviewDate, List<UserEntity> interviewers,
			JobApplicationEntity jobapplication,ScriptEntity script ) {
		super();
		this.interviewDate = interviewDate;
		this.interviewers = new HashSet<>();
		this.interviewers.addAll(interviewers);
		this.jobapplication = jobapplication;
		this.scriptInterview = script;
		this.finished = false;
	}



	public long getId() {
		return id;
	}


	public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	public List<UserEntity> getInterviewers() {
		return  new ArrayList<>(interviewers);
	}

	public void setInterviewers(List<UserEntity> interviewers) {
		this.interviewers = new HashSet<>();
		this.interviewers.addAll(interviewers);
	}


	public JobApplicationEntity getJobapplication() {
		return jobapplication;
	}

	public void setJobapplication(JobApplicationEntity jobapplication) {
		this.jobapplication = jobapplication;
	}

	public Set<AnswerInterviewEntity> getAnswer() {
		return answer;
	}

	public void setAnswer(List<AnswerInterviewEntity> answer) {
		this.answer = new HashSet<>();
		this.answer.addAll(answer);
	}

	public ScriptEntity getScriptInterview() {
		return scriptInterview;
	}

	public void setScriptInterview(ScriptEntity scriptInterview) {
		this.scriptInterview = scriptInterview;
	}


	public boolean isFinished() {
		return finished;
	}


	public void setFinished(boolean finished) {
		this.finished = finished;
	}


}

package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Interviewer")
@PrimaryKeyJoinColumn(name = "interviewer_id", referencedColumnName = "user_id")
public class InterviewerEntity extends UserEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InterviewerEntity() {
		// TODO Auto-generated constructor stub
	}

	public InterviewerEntity(String login, String password, String lastname, String firstname, String email) {
		super(login, password, lastname, firstname, email);
		this.role=RoleType.RECRUITER;
	}

	
}

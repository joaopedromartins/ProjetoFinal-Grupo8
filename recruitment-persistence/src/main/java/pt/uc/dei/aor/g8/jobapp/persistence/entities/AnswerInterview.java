package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="Answer")
public class AnswerInterview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne
	private QuestionEntity question;
	
	@Column
	private String answer;

	
	
	
	public AnswerInterview() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnswerInterview(QuestionEntity question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
	}

	public QuestionEntity getQuestion() {
		return question;
	}

	public void setQuestion(QuestionEntity question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}

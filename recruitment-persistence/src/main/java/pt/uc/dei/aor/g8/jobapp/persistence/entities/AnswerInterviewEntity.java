package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Answer")
public class AnswerInterviewEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String question;
	
	@Column
	private String questionType;
	
	@Column
	@ElementCollection
	private List<String> answer;
	

	
	public AnswerInterviewEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnswerInterviewEntity(String question, String questionType) {
		super();
		this.question = question;
		this.questionType = questionType;
	}

	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public List<String> getAnswer() {
		return answer;
	}

	public void setAnswer(List<String> answer) {
		this.answer = answer;
	}

}

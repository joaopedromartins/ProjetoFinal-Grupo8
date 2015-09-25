package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@ElementCollection (fetch = FetchType.EAGER)
	private Set<String> answer;
	
	@Column
	private String individualAnswer;
	
	
	public String getIndividualAnswer() {
		return individualAnswer;
	}

	public void setIndividualAnswer(String individualAnswer) {
		this.individualAnswer = individualAnswer;
	}

	public AnswerInterviewEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnswerInterviewEntity(String question, String questionType) {
		super();
		this.question = question;
		this.questionType = questionType;
		this.answer = new HashSet<>();
		answer.add("");
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

	public Set<String> getAnswer() {
		return answer ;
	}

	public void setAnswer(List<String> answer) {
		this.answer = new HashSet<>();
		this.answer.addAll(answer);
	}

}

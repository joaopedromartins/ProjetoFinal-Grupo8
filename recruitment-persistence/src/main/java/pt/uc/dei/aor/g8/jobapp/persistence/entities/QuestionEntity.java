package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import pt.uc.dei.aor.g8.business.enumeration.QuestionType;

@Entity
@Table(name = "Question")
public class QuestionEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String question;
	
	@Enumerated(EnumType.STRING)
	@Column(name="QuestionType")
	private  QuestionType questiontype;

	

	public QuestionEntity() {
		
	}

	public QuestionEntity(String question, QuestionType questiontype) {
		super();
		this.question = question;
		this.questiontype = questiontype;
	}



	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public QuestionType getQuestiontype() {
		return questiontype;
	}

	public void setQuestiontype(QuestionType questiontype) {
		this.questiontype = questiontype;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + ((questiontype == null) ? 0 : questiontype.hashCode());
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
		QuestionEntity other = (QuestionEntity) obj;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (questiontype != other.questiontype)
			return false;
		return true;
	}
	
	

}

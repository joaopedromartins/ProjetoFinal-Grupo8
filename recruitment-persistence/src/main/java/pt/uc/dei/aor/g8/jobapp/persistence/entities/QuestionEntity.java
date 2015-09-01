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

}

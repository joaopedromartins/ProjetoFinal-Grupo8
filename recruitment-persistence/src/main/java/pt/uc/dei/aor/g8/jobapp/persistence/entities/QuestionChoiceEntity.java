package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QuestionOptionChoice")
public class QuestionChoiceEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String option;

	public QuestionChoiceEntity() {
	
	}

	public QuestionChoiceEntity(String option) {
		super();
		this.option = option;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}
	
	
}

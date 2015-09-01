package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Script")
public class ScriptEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String scriptTitle;
	
	@ManyToMany
	private List<QuestionEntity> questions;
	
	public ScriptEntity() {
		// TODO Auto-generated constructor stub
	}
	
	

	public ScriptEntity(String scriptTitle, List<QuestionEntity> questions) {
		super();
		this.scriptTitle = scriptTitle;
		this.questions = questions;
	}



	public String getScriptTitle() {
		return scriptTitle;
	}

	public void setScriptTitle(String scriptTitle) {
		this.scriptTitle = scriptTitle;
	}

	public List<QuestionEntity> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionEntity> questions) {
		this.questions = questions;
	}
	

}

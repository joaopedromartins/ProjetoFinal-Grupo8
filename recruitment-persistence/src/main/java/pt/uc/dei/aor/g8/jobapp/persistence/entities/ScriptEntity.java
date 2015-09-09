package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Script")
@NamedQuery(name = "Script.listOfAllScripts", query = "SELECT s FROM ScriptEntity s")
public class ScriptEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String LIST_OF_ALL_SCRIPTS = "Script.listOfAllScripts";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String scriptTitle;
	
	@OneToMany (cascade=CascadeType.ALL, mappedBy = "script", fetch=FetchType.EAGER)
	private List<QuestionEntity> questions;
	
	
	
	public ScriptEntity() {
		this.questions = new ArrayList<>();
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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((questions == null) ? 0 : questions.hashCode());
		result = prime * result + ((scriptTitle == null) ? 0 : scriptTitle.hashCode());
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
		ScriptEntity other = (ScriptEntity) obj;
		if (questions == null) {
			if (other.questions != null)
				return false;
		} else if (!questions.equals(other.questions))
			return false;
		if (scriptTitle == null) {
			if (other.scriptTitle != null)
				return false;
		} else if (!scriptTitle.equals(other.scriptTitle))
			return false;
		return true;
	}
	
	
	

}

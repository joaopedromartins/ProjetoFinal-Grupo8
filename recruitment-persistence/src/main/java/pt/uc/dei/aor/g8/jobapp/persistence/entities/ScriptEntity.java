package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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

	@Column ( unique = true)
	private String scriptTitle;

	@OrderBy("orderNumber ASC")
	@OneToMany (cascade=CascadeType.ALL, mappedBy = "script", fetch=FetchType.EAGER)
	private SortedSet<QuestionEntity> questions;



	public ScriptEntity() {
		this.questions = new TreeSet<>();
	}

	public ScriptEntity(String scriptTitle, List<QuestionEntity> questions) {
		super();
		this.scriptTitle = scriptTitle;
		this.questions = new TreeSet<>();
		this.questions.addAll(questions);
	}



	public String getScriptTitle() {
		return scriptTitle;
	}

	public void setScriptTitle(String scriptTitle) {
		this.scriptTitle = scriptTitle;
	}

	public void addQuestionToListQuestion (QuestionEntity question){
		int  sizeListQuestion = questions.size();
		question.setOrderNumber(sizeListQuestion + 1);
		question.setScript(this);
		this.questions.add(question);
	}
	
	public void addQuestionWithOrderToListQuestion (QuestionEntity question){
		question.setScript(this);
		this.questions.add(question);
	}

	public void deleteQuestionOfListQuestion (QuestionEntity questionDelete){

		if (questions.remove(questionDelete)){
			int orderNumber = questionDelete.getOrderNumber();
			for (QuestionEntity q:questions){
				if (q.getOrderNumber() > orderNumber) {
					q.setOrderNumber(q.getOrderNumber()-1);
				}
			}
			questionDelete.setScript(null);
		}
	}
	
	private QuestionEntity removeTheFirstOfSortedSet (){
		QuestionEntity firstQuestion= questions.first();
		questions.remove(firstQuestion);
		return firstQuestion;
	}
	
	public List <QuestionEntity> removeALLQuestion (){
		List <QuestionEntity> questionList = new ArrayList<>();
		while (questions.size() > 0){
			questionList.add(removeTheFirstOfSortedSet());
		}
		return questionList;
	}

	public Set<QuestionEntity> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionEntity> questions) {
		this.questions.addAll(questions);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		if (id != other.id)
			return false;
		if (scriptTitle == null) {
			if (other.scriptTitle != null)
				return false;
		} else if (!scriptTitle.equals(other.scriptTitle))
			return false;
		return true;
	}


}

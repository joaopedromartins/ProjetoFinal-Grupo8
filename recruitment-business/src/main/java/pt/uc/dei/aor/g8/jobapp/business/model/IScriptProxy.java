package pt.uc.dei.aor.g8.jobapp.business.model;

import java.util.List;



public interface IScriptProxy {

	
	public String getScriptTitle();

	public void setScriptTitle(String scriptTitle);

	public List<IQuestionProxy> getQuestions();

	public void setQuestions(List<IQuestionProxy> questions);
	
	public void addQuestionToListQuestion (IQuestionProxy question);
	
	public void deleteQuestionOfListQuestion (IQuestionProxy questionDelete);
}

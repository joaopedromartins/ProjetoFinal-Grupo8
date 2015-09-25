package pt.uc.dei.aor.g8.jobapp.business.model;

import java.util.List;

public interface IAnswerInterviewProxy {

	public String getQuestion();
	public void setQuestion(String question);
	
	public String getQuestionType();
	public void setQuestionType(String questionType);

	public List<String> getAnswer();
	public void setAnswer(List<String> answer);
	
	public String getAnswerToString();
	void setIndividualAnswer(String answer);
	String getIndividualAnswer();
}

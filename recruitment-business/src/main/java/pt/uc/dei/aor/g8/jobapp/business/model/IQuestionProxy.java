package pt.uc.dei.aor.g8.jobapp.business.model;

import pt.uc.dei.aor.g8.business.enumeration.QuestionType;

public interface IQuestionProxy {
	
	public String getQuestion();
	public void setQuestion(String question);

	public QuestionType getQuestiontype();
	public void setQuestiontype(QuestionType questiontype);
	
	public int getOrderNumber();
	public void setOrderNumber(int orderNumber);

}

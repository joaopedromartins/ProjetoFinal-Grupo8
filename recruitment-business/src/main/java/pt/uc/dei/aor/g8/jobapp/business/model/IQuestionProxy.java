package pt.uc.dei.aor.g8.jobapp.business.model;

import java.util.List;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.QuestionType;

public interface IQuestionProxy {
	
	public String getQuestion();
	public void setQuestion(String question);

	public QuestionType getQuestiontype();
	public void setQuestiontype(QuestionType questiontype);
	
	public int getOrderNumber();
	public void setOrderNumber(int orderNumber);
	
	public IQuestionScaleProxy getScale();
	public void setScale(IQuestionScaleProxy scale);

	public List<IQuestionChoiceProxy> getOptions();
	public void setOptions(List<IQuestionChoiceProxy> options);

}

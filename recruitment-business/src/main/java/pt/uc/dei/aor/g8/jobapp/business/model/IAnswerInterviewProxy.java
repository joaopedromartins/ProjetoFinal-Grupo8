package pt.uc.dei.aor.g8.jobapp.business.model;

public interface IAnswerInterviewProxy {

	public String getQuestion();
	public void setQuestion(String question);
	
	public String getQuestionType();
	public void setQuestionType(String questionType);

	public String getAnswer();
	public void setAnswer(String answer);
}

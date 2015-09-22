package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.model.IAnswerInterviewProxy;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.AnswerInterviewEntity;

@Stateless
public class AnswerInterviewProxy implements IAnswerInterviewProxy, IEntityAware<AnswerInterviewEntity> {

	private AnswerInterviewEntity entity; 



	public AnswerInterviewProxy() {
		this (null);
	}

	public AnswerInterviewProxy(AnswerInterviewEntity answerInterview) {
		if (answerInterview == null){
			this.entity = new AnswerInterviewEntity();
		} else {
			this.entity = answerInterview;
		}		
	}


	@Override
	public AnswerInterviewEntity getEntity() {
		return entity;
	}

	@Override
	public String getQuestion() {
		return entity.getQuestion();
	}

	@Override
	public void setQuestion(String question) {
		entity.setQuestion(question);
	}

	@Override
	public String getQuestionType() {
		return entity.getQuestionType();
	}

	@Override
	public void setQuestionType(String questionType) {
		entity.setQuestionType(questionType);
	}

	@Override
	public String getAnswer() {
		return entity.getAnswer();
	}

	@Override
	public void setAnswer(String answer) {
		entity.setAnswer(answer);
	}
	
	

}

package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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




	public AnswerInterviewProxy(String question, String questionType) {
		this.entity = new AnswerInterviewEntity(question, questionType);
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
	public List<String> getAnswer() {
		List<String> answer = new ArrayList<>();
		answer.addAll(entity.getAnswer());
		return answer;
	}

	@Override
	public void setAnswer(List<String> answer) {
		entity.setAnswer(answer);
	}

	@Override
	public String getAnswerToString() {
		Set<String> answers = entity.getAnswer();
		String answerList = "";
		for (String a: answers) {
			if ( !answerList.equals("")){
				answerList = answerList +", " + a.toString() ;
			} else {
				answerList = answerList + a.toString() ;
			}

		}
		return answerList;
	}



}

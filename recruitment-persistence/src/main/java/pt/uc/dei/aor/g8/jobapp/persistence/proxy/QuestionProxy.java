package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.business.enumeration.QuestionType;
import pt.uc.dei.aor.g8.jobapp.business.model.IQuestionProxy;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.JobAdvertisingChanelEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.QuestionEntity;

@Stateless
public class QuestionProxy implements IQuestionProxy, IEntityAware<QuestionEntity> {

	private QuestionEntity entity;

	public QuestionProxy() {

	}

	public QuestionProxy(QuestionEntity question) {
		if (question == null){
			this.entity = new QuestionEntity();
		}else{
			this.entity = question;
		}
	}



	public QuestionProxy(String question, QuestionType questionType) {
			this.entity= new QuestionEntity(question, questionType);
	}

	@Override
	public QuestionEntity getEntity() {
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
	public QuestionType getQuestiontype() {
		return entity.getQuestiontype();
	}

	@Override
	public void setQuestiontype(QuestionType questiontype) {
		entity.setQuestiontype(questiontype);
	}

	@Override
	public int getOrderNumber() {
		return entity.getOrderNumber();
	}

	@Override
	public void setOrderNumber(int orderNumber) {
		entity.setOrderNumber(orderNumber);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		return entity.equals(((IEntityAware<QuestionEntity>)o).getEntity());
	}
	
	@Override
	public int hashCode() {
		return entity.hashCode();
	}
	
	@Override
	public String toString() {
		return entity.toString();
	}

}

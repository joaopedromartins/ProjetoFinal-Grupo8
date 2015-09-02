package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.model.IQuestionProxy;
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



	@Override
	public QuestionEntity getEntity() {
		return entity;
	}

}

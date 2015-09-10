package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.model.IQuestionChoiceProxy;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.QuestionChoiceEntity;

@Stateless
public class QuestionChoiceProxy implements IQuestionChoiceProxy, IEntityAware<QuestionChoiceEntity> {

	private QuestionChoiceEntity entity;
	
	public QuestionChoiceProxy() {
	
	}
	
	public QuestionChoiceProxy (QuestionChoiceEntity optionEntity){
		if ( optionEntity == null){
			this.entity = new QuestionChoiceEntity();
		} else {
			this.entity = optionEntity;
		}
	}
	
	public QuestionChoiceProxy (String option){
		this.entity = new QuestionChoiceEntity(option);
	}
	
	

	@Override
	public String getOption() {
		return entity.getOption();
	}

	@Override
	public void setOption(String option) {
		entity.setOption(option);
	}

	@Override
	public QuestionChoiceEntity getEntity() {
		return entity;
	}

}

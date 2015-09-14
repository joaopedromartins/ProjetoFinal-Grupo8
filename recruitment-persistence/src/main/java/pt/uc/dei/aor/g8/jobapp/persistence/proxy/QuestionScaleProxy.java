package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.model.IQuestionScaleProxy;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.QuestionScaleEntity;

@Stateless
public class QuestionScaleProxy implements IQuestionScaleProxy, IEntityAware<QuestionScaleEntity> {

	private QuestionScaleEntity entity;
	
	
	public QuestionScaleProxy() {
		this(null);
	}
	
	public QuestionScaleProxy (QuestionScaleEntity scale){
		if ( scale == null){
			this.entity = new QuestionScaleEntity();
		} else {
			this.entity = scale;
		}
	}
	
	public QuestionScaleProxy (int minimum, int maximum, String minLabel, String maxLabel){
		this.entity = new QuestionScaleEntity(minimum, maximum, minLabel, maxLabel);
	}

	@Override
	public QuestionScaleEntity getEntity() {
		return entity;
	}
	
	@Override
	public int getMinimum() {
		return entity.getMinimum();
	}

	@Override
	public void setMinimum(int minimum) {
		entity.setMinimum(minimum);
	}

	@Override
	public int getMaximum() {
		return entity.getMaximum();
	}

	@Override
	public void setMaximum(int maximum) {
		entity.setMaximum(maximum);
	}

	@Override
	public String getMinLabel() {
		return entity.getMinLabel();
	}

	@Override
	public void setMinLabel(String minLabel) {
		entity.setMinLabel(minLabel);
	}

	@Override
	public String getMaxLabel() {
		return entity.getMaxLabel();
	}

	@Override
	public void setMaxLabel(String maxLabel) {
		entity.setMaxLabel(maxLabel);
	}

}

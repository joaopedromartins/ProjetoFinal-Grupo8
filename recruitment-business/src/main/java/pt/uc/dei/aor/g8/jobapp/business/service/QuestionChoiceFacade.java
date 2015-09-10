package pt.uc.dei.aor.g8.jobapp.business.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.model.IProxyFactory;
import pt.uc.dei.aor.g8.jobapp.business.model.IQuestionChoiceProxy;

@Stateless
public class QuestionChoiceFacade implements IQuestionChoiceFacade {

	@EJB
	private IProxyFactory factory;

	@Override
	public IQuestionChoiceProxy newChoice(String option) {	
		return factory.choise(option);
	}
	
	
	
	
	
}

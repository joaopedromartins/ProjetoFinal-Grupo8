package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.QuestionType;
import pt.uc.dei.aor.g8.jobapp.business.model.IProxyFactory;
import pt.uc.dei.aor.g8.jobapp.business.model.IQuestionChoiceProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IQuestionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IQuestionScaleProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IScriptProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IScriptPersistenceService;

@Stateless
public class ScripFacade implements IScriptFacade {

	@EJB
	private IProxyFactory factory;

	@EJB
	private IScriptPersistenceService service;




	@Override
	public List<IScriptProxy> listOfAllScripts() {

		return service.listOfAllScripts();
	}




	@Override
	public IScriptProxy initialNewScript() {

		IScriptProxy newScript = factory.script();

		//return service.saveScript(newScript);
		return newScript;
	}




	@Override
	public IScriptProxy addQuestionToScript(IScriptProxy script, String question, QuestionType questionType) {
		IQuestionProxy newQuestion = factory.question(question, questionType);
		script.addQuestionToListQuestion(newQuestion);
		return service.updateScript(script);
	}




	@Override
	public IScriptProxy addQuestionToScript(IScriptProxy script, String question, QuestionType questionType, int min,
			int max, String minLabel, String maxLabel) {
		IQuestionScaleProxy newScale = factory.scale(min, max, minLabel, maxLabel);
		IQuestionProxy newQuestion = factory.question(question, questionType, newScale );
		script.addQuestionToListQuestion(newQuestion);
		return service.updateScript(script);
	}




	@Override
	public IScriptProxy addQuestionToScript(IScriptProxy script, String question, QuestionType questionType,
			List<IQuestionChoiceProxy> options) {
		//List<IQuestionChoiceProxy> newOptions= factory.choice(options);
		IQuestionProxy newQuestion = factory.question(question, questionType, options);
		script.addQuestionToListQuestion(newQuestion);
		return service.updateScript(script);
	}




	@Override
	public IScriptProxy deleteQuestion(IScriptProxy script, IQuestionProxy questionDelete) {
		script.deleteQuestionOfListQuestion(questionDelete);
		return service.updateScript(script);
	}




	@Override
	public IScriptProxy changeOrderOfQuestion(IScriptProxy script, int fromRow, int toRow) {
		List <IQuestionProxy> listQuestion = new ArrayList<>();
		listQuestion.addAll(script.getQuestions());
		for (IQuestionProxy q: listQuestion){
			if(q.getOrderNumber() == fromRow){
				script.changeOrderOfQuestion(fromRow,toRow);
			}
		}
		
		
		return service.updateScript(script);
	}

}

package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.QuestionType;
import pt.uc.dei.aor.g8.jobapp.business.model.IQuestionChoiceProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IScriptProxy;

public interface IScriptFacade {

	public List<IScriptProxy> listOfAllScripts();

	public IScriptProxy initialNewScript();

	public IScriptProxy addQuestionToScript(IScriptProxy script, String question, QuestionType questionType);

	public IScriptProxy addQuestionToScript(IScriptProxy script, String question, QuestionType questionType,
			int min, int max, String minLabel, String maxLabel);

	public IScriptProxy addQuestionToScript(IScriptProxy script, String question, QuestionType questionType,
			List <IQuestionChoiceProxy> options);

}

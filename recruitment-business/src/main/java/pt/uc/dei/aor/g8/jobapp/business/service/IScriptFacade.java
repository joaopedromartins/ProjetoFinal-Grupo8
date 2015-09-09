package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.List;

import pt.uc.dei.aor.g8.business.enumeration.QuestionType;
import pt.uc.dei.aor.g8.jobapp.business.model.IScriptProxy;

public interface IScriptFacade {

	public List<IScriptProxy> listOfAllScripts();

	public IScriptProxy initialNewScript();

	public IScriptProxy addQuestionToScript(IScriptProxy script, String question, QuestionType questionType);

}

package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.model.IQuestionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IScriptProxy;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.QuestionEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.ScriptEntity;

@Stateless
public class ScriptProxy implements IScriptProxy, IEntityAware<ScriptEntity> {

	private ScriptEntity entity;
	
	public ScriptProxy() {
		this(null);
	}
	
	public ScriptProxy (ScriptEntity script){
		if (script == null){
			this.entity = new ScriptEntity();
		} else {
			this.entity = script;
		}
	}



	@Override
	public ScriptEntity getEntity() {
		return entity;
	}

	@Override
	public String getScriptTitle() {
		return entity.getScriptTitle();
	}

	@Override
	public void setScriptTitle(String scriptTitle) {
		entity.setScriptTitle(scriptTitle);
		
	}

	@Override
	public List<IQuestionProxy> getQuestions() {
		List<IQuestionProxy> proxy = new ArrayList<>();
		
		List<QuestionEntity> entityQuestion = entity.getQuestions();
		
		for (QuestionEntity q:entityQuestion){
			proxy.add(new QuestionProxy(q));
		}
		return proxy;
	}

	@Override
	public void setQuestions(List<IQuestionProxy> questions) {
		entity.setQuestions(questionsConverterProxyToEntity(questions));
		
	}
	
	@SuppressWarnings( "unchecked" )
	private List<QuestionEntity> questionsConverterProxyToEntity (List<IQuestionProxy> proxy){
		List<QuestionEntity> questionsEntity = new ArrayList<>();

		for(IQuestionProxy qP : proxy){
			questionsEntity.add(((IEntityAware<QuestionEntity>)qP).getEntity());
		}

		return questionsEntity;
	}

	@Override
	public void addQuestionToListQuestion(IQuestionProxy question) {
		entity.addQuestionToListQuestion(questionConverterProxyToEntity(question));
		
	}
	
	@SuppressWarnings("unchecked")
	private QuestionEntity questionConverterProxyToEntity (IQuestionProxy proxy){
		QuestionEntity questionEntity = ((IEntityAware<QuestionEntity>)proxy).getEntity(); 
		return questionEntity;
		
	}

}

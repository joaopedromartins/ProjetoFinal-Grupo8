package pt.uc.dei.aor.g8.jobapp.hrPresentation;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import pt.uc.dei.aor.g8.jobapp.business.model.IQuestionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IScriptProxy;
import pt.uc.dei.aor.g8.jobapp.business.service.IScriptFacade;

@Named
@RequestScoped
public class ScriptBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IScriptFacade facade;
	
	private String title;
	private List<IQuestionProxy> questions;
	
	private List<IScriptProxy> scripts;
	private IScriptProxy   script;
	

	
	public ScriptBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String initialNewScript (){
		this.script = facade.initialNewScript();
		return "/administrator/addScript?faces-redirect=true";
	}
	
	
	
	public List<IScriptProxy> getScripts() {
		return facade.listOfAllScripts();
	}
	
	public void setScripts(List<IScriptProxy> scripts) {
		this.scripts = scripts;
	}
	
	
	
	public IScriptProxy getScript() {
		return script;
	}
	public void setScript(IScriptProxy script) {
		this.script = script;
	}

}

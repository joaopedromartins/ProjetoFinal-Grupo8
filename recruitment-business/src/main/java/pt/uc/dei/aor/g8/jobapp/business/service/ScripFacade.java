package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.model.IProxyFactory;
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
		
		return newScript;
	}
	
	

}

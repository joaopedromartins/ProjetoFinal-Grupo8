package pt.uc.dei.aor.g8.jobapp.business.persistence;

import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.model.IScriptProxy;

public interface IScriptPersistenceService {

	public List<IScriptProxy> listOfAllScripts();

	public IScriptProxy saveScript(IScriptProxy newScript);
	
	public IScriptProxy updateScript(IScriptProxy updateScript);

}

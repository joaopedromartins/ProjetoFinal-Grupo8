package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.model.IScriptProxy;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.ScriptEntity;

@Stateless
public class ScriptProxy implements IScriptProxy, IEntityAware<ScriptEntity> {

	private ScriptEntity entity;
	
	public ScriptProxy() {
		
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

}

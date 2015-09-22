package pt.uc.dei.aor.g8.jobapp.persistence.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pt.uc.dei.aor.g8.jobapp.business.model.IScriptProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IScriptPersistenceService;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.ScriptEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.IEntityAware;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.ScriptProxy;


@Stateless
public class ScriptPersistenceService implements IScriptPersistenceService {

	@PersistenceContext (unitName="recruitment")
	private EntityManager em;

	public ScriptPersistenceService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<IScriptProxy> listOfAllScripts() {
		TypedQuery<ScriptEntity> query = em.createNamedQuery(ScriptEntity.LIST_OF_ALL_SCRIPTS,
				ScriptEntity.class);
		List <ScriptEntity> entity = query.getResultList();

		List <IScriptProxy> proxy = new ArrayList<>();
		for (ScriptEntity s: entity){
			proxy.add(new ScriptProxy(s));
		}
		return proxy;
	}

	@Override
	public IScriptProxy saveScript(IScriptProxy newScript) {
		ScriptEntity entity = getEntity(newScript);
		em.persist(entity);
		return new ScriptProxy(entity);
	}

	@SuppressWarnings("unchecked")
	private ScriptEntity getEntity(IScriptProxy scriptProxy) {
		if (scriptProxy instanceof IEntityAware<?>) {
			return ((IEntityAware<ScriptEntity>) scriptProxy).getEntity();
		}
		throw new IllegalStateException();
	}

	@Override
	public IScriptProxy updateScript(IScriptProxy updateScript) {
		ScriptEntity entity = getEntity(updateScript);
		entity = em.merge(entity);
		return new ScriptProxy(entity);
	}

	@Override
	public IScriptProxy findTitleOfScript(String scriptTitle) {
		TypedQuery<ScriptEntity> query = em.createNamedQuery(ScriptEntity.FIND_TITLE,
				ScriptEntity.class); 
		query.setParameter("scriptTitle",scriptTitle);
		List <ScriptEntity> entityScript = query.getResultList();

		IScriptProxy proxyScript;
		if( entityScript.size() == 1){
			proxyScript = new ScriptProxy(entityScript.get(0));
		} else {
			proxyScript=null;
		}
		return proxyScript;
	}

	@Override
	public IScriptProxy deleteScript(IScriptProxy script) {
		ScriptEntity entity = getEntity(script);
		entity = em.merge(entity);
		em.remove(entity);	
		return new ScriptProxy(entity);
	}



}

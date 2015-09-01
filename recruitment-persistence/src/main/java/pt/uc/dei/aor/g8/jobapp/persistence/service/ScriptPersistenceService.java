package pt.uc.dei.aor.g8.jobapp.persistence.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pt.uc.dei.aor.g8.jobapp.business.persistence.IScriptPersistenceService;


@Stateless
public class ScriptPersistenceService implements IScriptPersistenceService {

	@PersistenceContext (unitName="recruitment")
	private EntityManager em;

	public ScriptPersistenceService() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}

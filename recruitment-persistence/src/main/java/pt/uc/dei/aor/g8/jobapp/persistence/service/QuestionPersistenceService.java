package pt.uc.dei.aor.g8.jobapp.persistence.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pt.uc.dei.aor.g8.jobapp.business.persistence.IQuestionPersistenceService;

@Stateless
public class QuestionPersistenceService implements IQuestionPersistenceService {

	@PersistenceContext (unitName="recruitment")
	private EntityManager em;

	public QuestionPersistenceService() {
	}
	
	
}

package pt.uc.dei.aor.g8.jobapp.business.service;

import java.math.BigInteger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IProxyFactory;
import pt.uc.dei.aor.g8.jobapp.business.persistence.ICandidatePersistenceService;

@Stateless
public class CandidateFacade implements ICandidateFacade {

	@EJB
	private IProxyFactory factory;
	
	@EJB
	private ICandidatePersistenceService service;
	
	@Inject
	private EncryptEJB crypt;

	public CandidateFacade() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ICandidateProxy createNewCandidate(String username, String password, String lastname, String firstname, String email, BigInteger mobile) {
		//Encript password
    	if (crypt != null) {
    		ICandidateProxy newCandidate = factory.candidate(username, crypt.encrypt(password, username), lastname, firstname, email, mobile);
    		return service.saveCandidate(newCandidate);
    	}
    	return null;
	}

	@Override
	public ICandidateProxy editCandidate(ICandidateProxy candidateProxy) {
		return service.editCandidate(candidateProxy);
	}

}

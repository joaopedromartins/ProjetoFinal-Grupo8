package pt.uc.dei.aor.g8.jobapp.business.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IProxyFactory;
import pt.uc.dei.aor.g8.jobapp.business.persistence.ICandidatePersistenceService;

@Stateless
public class CandidateFacade implements ICandidateFacade {

	@EJB
	private IProxyFactory factory;
	
	@EJB
	private ICandidatePersistenceService service;

	public CandidateFacade() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ICandidateProxy createNewCandidate(String username, String password, String lastname, String firstname, String email, BigInteger mobile) {

		ICandidateProxy newCandidate = factory.candidate(username, password, lastname, firstname, email, mobile);
		
		
		return service.saveCandidate(newCandidate);
	}


	public ICandidateProxy editCandidate(ICandidateProxy candidateProxy) {
		
		return service.editCandidate(candidateProxy);
		
	}

}

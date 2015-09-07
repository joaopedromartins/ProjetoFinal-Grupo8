package pt.uc.dei.aor.g8.jobapp.business.service;

import java.math.BigInteger;

import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;

public interface ICandidateFacade {
	public ICandidateProxy createNewCandidate(String username, String password, String lastname, String firstname, String email, BigInteger mobile);
	

}

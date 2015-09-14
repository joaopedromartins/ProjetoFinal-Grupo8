package pt.uc.dei.aor.g8.jobapp.business.service;

import java.math.BigInteger;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IProxyFactory;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.ICandidatePersistenceService;

@Stateless
public class CandidateFacade implements ICandidateFacade {

	@EJB
	private IProxyFactory factory;
	
	@EJB
	private ICandidatePersistenceService service;
	
	public CandidateFacade() {
	}

	@Override
	public ICandidateProxy createNewCandidate(String username, String password, String lastname, String firstname, String email, BigInteger mobile) {
		
		try {
			//Encript password
			ICandidateProxy newCandidate = factory.candidate(username, encryptPass(password), lastname, firstname, email, mobile);
			return service.saveCandidate(newCandidate);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			//Encrypt password failed
			//Abort candidate creation
			return null;
		}
		
	}

	@Override
	public ICandidateProxy editCandidate(ICandidateProxy candidateProxy) {
		return service.editCandidate(candidateProxy);
	}
	
	/**
	 * Encrypt password SHA256 Base64
	 * 
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public String encryptPass(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(password.getBytes("UTF-8"));
		return new String(Base64.getEncoder().encode(hash));
	}
	
	@Override
	public ICandidateProxy findCandidateByUsername(String username) {
		ICandidateProxy candidate = service.findCandidateByUsername(username);
		if(candidate != null){
			return candidate;
		}
		return null;
	}
	
	@Override
	public ICandidateProxy findCandidateByEmail(String email) {
		ICandidateProxy candidate = service.findCandidateByEmail(email);
		if(candidate != null){
			return candidate;
		}
		return null;
	}

}

package pt.uc.dei.aor.g8.jobapp.business.service;

import java.math.BigInteger;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IProxyFactory;
import pt.uc.dei.aor.g8.jobapp.business.persistence.ICandidatePersistenceService;
import pt.uc.dei.aor.g8.jobapp.business.util.AutoGeneratePasswor;
import pt.uc.dei.aor.g8.jobapp.business.util.EncryptPassword;
import pt.uc.dei.aor.g8.jobapp.business.util.GmailMessage;

@Stateless
public class CandidateFacade implements ICandidateFacade {

	@EJB
	private IProxyFactory factory;
	
	@EJB
	private ICandidatePersistenceService service;
	
	@EJB
	private EncryptPassword passEncript;
	
	@EJB
	private AutoGeneratePasswor passwordGenrate;
	
	@EJB
	private GmailMessage mail;
	//@EJB
	//private INotificationFacade notification;



	public CandidateFacade() {
	}

	@Override
	public String createNewCandidate(String username, String password, String lastname, String firstname, String email, BigInteger mobile) {
		ICandidateProxy candidateUsername = findCandidateByUsername(username);
		ICandidateProxy candidateEmail = findCandidateByEmail(email);
		String passwordEncript = passEncript.encriptarPass(password);
		if (candidateUsername == null && candidateEmail == null && passwordEncript != null){
			ICandidateProxy newCandidate = factory.candidate(username, passwordEncript , lastname, firstname, email, mobile);
			service.saveCandidate(newCandidate);
			return "sucess"; 
		} else if (candidateUsername == null && candidateEmail != null ) {
			return "Email already exists!!";	
		} else if (candidateUsername != null && candidateEmail == null ){
			return "Username already exists!!";
		} else if (candidateUsername != null && candidateEmail != null){
			return "Username and email already exists!!";
		}
		return null;
	}

	@Override
	public ICandidateProxy editCandidate(ICandidateProxy candidateProxy) {
		return service.editCandidate(candidateProxy);
	}


	@Override
	public ICandidateProxy findCandidateByUsername(String username) {
		ICandidateProxy candidate = service.findCandidateByUsername(username);
		System.out.println("facade find by username"+ username);
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

	@Override
	public String sendRecoverMessageToEmail(String email) {
		ICandidateProxy candidate = service.findCandidateByEmail(email);
		if (candidate==null) {
			return "There isn't an existing account associated with this email address";
		} else {
			String password=passwordGenrate.autoGeneratePassword();
			ICandidateProxy candidateProxy=findCandidateByEmail(email);
			candidateProxy.setPassword( passEncript.encriptarPass(password) );
			editCandidate(candidateProxy);
			
			//Notify Candidate by email
			mail.sendEmail(email, 
				"jobappmailtest@gmail.com", 
				"Recover Account",
				"Dear " +  candidate.getFirstname() + ",\n" +
				"There is an existing account associated with this email address.\n" +
						"\nFor security resons your Password has been reset to a new one.\n" +
						"\tUsername: " + candidate.getUsername() + "\n" +
						"\tPassword: " + password +
						"\n\nRegards," +
						"\nAdministration Team"
				);
			
			return "recover email to "+email+" has been sent with success.";
		}
	}

	@Override
	public String sendRegistrationCode(String registrationCode, String email) {

		ICandidateProxy candidateProxy=findCandidateByEmail(email);
		if(candidateProxy != null){
			return "There is an existing account associated with this email address. Recover account.";
		} else {
			//Notify Candidate by email
			mail.sendEmail(email, 
				"jobappmailtest@gmail.com", 
				"Recover Account",
				"Dear Candidate,\n" +
				"Use de following code to compleet your registration:\n" +
				"There is an existing account associated with this email address.\n" +
						"\tValidation Code: " + registrationCode + "\n" +
						"\n\nRegards," +
						"\nAdministration Team"
				);
			
			return "recover email to "+email+" has been sent with success.";
			
		}
	}

}

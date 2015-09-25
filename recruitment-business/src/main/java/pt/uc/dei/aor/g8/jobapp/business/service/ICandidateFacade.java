package pt.uc.dei.aor.g8.jobapp.business.service;


import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;

public interface ICandidateFacade {
	public String createNewCandidate(String username, String password, String lastname, String firstname, String email, String mobile, String linkedinAddress);

	public ICandidateProxy editCandidate(ICandidateProxy candidateProxy);

	public ICandidateProxy findCandidateByUsername(String username);
	
	public ICandidateProxy findCandidateByEmail(String email);
	
	public String sendRecoverMessageToEmail(String email);
	
	public String sendRegistrationCode(String registrationCode, String email);
	
	public ICandidateProxy findCandidateById (long candidateId);
}

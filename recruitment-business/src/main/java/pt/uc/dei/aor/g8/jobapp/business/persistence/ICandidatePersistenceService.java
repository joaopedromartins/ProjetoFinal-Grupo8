package pt.uc.dei.aor.g8.jobapp.business.persistence;

import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;

public interface ICandidatePersistenceService {
	public ICandidateProxy saveCandidate(ICandidateProxy newCandidate);
	public ICandidateProxy editCandidate(ICandidateProxy CandidateProxy);
	public ICandidateProxy findCandidateByUsername(String username);
	public ICandidateProxy findCandidateByEmail(String email);
	public ICandidateProxy findById(long id);
	public List<ICandidateProxy> allCandidate();
	public ICandidateProxy verifyPasswordOfCandidate(String username, String password);
}

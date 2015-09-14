package pt.uc.dei.aor.g8.jobapp.business.persistence;

import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;

public interface ICandidatePersistenceService {
	public ICandidateProxy saveCandidate(ICandidateProxy newCandidate);
	public ICandidateProxy editCandidate(ICandidateProxy CandidateProxy);
	public ICandidateProxy findCandidateByUsername(String username);
	public ICandidateProxy findCandidateByEmail(String email);
}

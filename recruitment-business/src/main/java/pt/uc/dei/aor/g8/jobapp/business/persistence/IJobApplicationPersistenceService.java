package pt.uc.dei.aor.g8.jobapp.business.persistence;

import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;

public interface IJobApplicationPersistenceService {
	
	public IJobApplicationProxy saveJobApplication(IJobApplicationProxy newJobApplication);

	public List<IJobApplicationProxy> listOfAllCandidateJobApplication(String username);
	
	public List<IJobApplicationProxy> listOfJobApplicationByCandidate(ICandidateProxy candidate);

	public IJobApplicationProxy editJobApplication(IJobApplicationProxy jobApplicationProxy);

	public boolean existsJobApplicationToPositionCodeAndUsername(String code, String username);
	
	public IJobApplicationProxy spontaneousJobApllicationByCandidate(ICandidateProxy candidate);
	
	public List <IJobApplicationProxy> findAllJobApplication ();
	
	public IJobApplicationProxy findById (long id);

	public List<IJobApplicationProxy> listOfAllSpontaneous();
	
}

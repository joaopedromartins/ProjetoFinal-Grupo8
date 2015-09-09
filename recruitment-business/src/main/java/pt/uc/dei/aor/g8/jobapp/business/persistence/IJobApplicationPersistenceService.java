package pt.uc.dei.aor.g8.jobapp.business.persistence;

import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;

public interface IJobApplicationPersistenceService {
	
	public IJobApplicationProxy saveJobApplication(IJobApplicationProxy newJobApplication);

	public List<IJobApplicationProxy> listOfAllJobApplication(String username);

	public IJobApplicationProxy editJobApplication(IJobApplicationProxy jobApplicationProxy);

	public List<IJobApplicationProxy> listOfAllOpenJobApplication();
	
}

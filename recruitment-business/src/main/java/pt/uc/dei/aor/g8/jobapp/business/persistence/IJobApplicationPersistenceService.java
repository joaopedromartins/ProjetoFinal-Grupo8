package pt.uc.dei.aor.g8.jobapp.business.persistence;

import java.util.Date;
import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;

public interface IJobApplicationPersistenceService {
	
	public IJobApplicationProxy saveJobApplication(IJobApplicationProxy newJobApplication);

	public List<IJobApplicationProxy> listOfAllCandidateJobApplication(String username);
	
	public List<IJobApplicationProxy> listOfJobApplicationByCandidate(ICandidateProxy candidate);

	public IJobApplicationProxy editJobApplication(IJobApplicationProxy jobApplicationProxy);

	public boolean existsJobApplicationToPositionCodeAndUsername(String code, String username);
	
	public IJobApplicationProxy spontaneousJobApllicationByCandidate(ICandidateProxy candidate);
	
	public IJobApplicationProxy findById (long id);

	public List<IJobApplicationProxy> listOfAllSpontaneous();
	
	public List<IJobApplicationProxy> listOfAllSpontaneousSituation();

	public IJobApplicationProxy findJobApplicationByCandidateAndPosition(ICandidateProxy candidate,
			IPositionProxy position);

	public List <IJobApplicationProxy> listOfAllAppNotSituationSpontaneous();
	
	public List <IJobApplicationProxy> listOfAllAppNotSituationSpontaneousManager(IUserProxy manager);
	
	public List <IJobApplicationProxy> listOfAllAppBetweenDates(Date startDate, Date endDate);
	
	public List <IJobApplicationProxy> listOfAllAppSpontaneousBetweenDates (Date startDate, Date endDate);


	public IJobApplicationProxy candidateSpontaneousJobApplication(String username);

	public List <IJobApplicationProxy> listOfAllAppByPosition(IPositionProxy p);

	

	public double averageTimeToHiring(Date startDate, Date endDate);

	//public void deleteJobApplication(IJobApplicationProxy jobApplicationProxy);

	public List<IJobApplicationProxy> listOfAllApplicationRejectedBetweenDates (Date startDate, Date endDate);

	public List<IJobApplicationProxy> listOfAllAppWidhInterviewBetweenDates(Date start, Date end);

	
	
}

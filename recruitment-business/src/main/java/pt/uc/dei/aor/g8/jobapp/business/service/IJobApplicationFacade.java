package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.ProposalStatus;
import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;

public interface IJobApplicationFacade {

	public IJobApplicationProxy createNewJobApplication(
			String address, String city, String country, String phone, String diploma,
			String school, String letter, String cv, String source, ICandidateProxy candidate,
			IPositionProxy position) ;
	public IJobApplicationProxy creatSpontaneousJobApplication(String address, String city, String country, String phone,
			String diploma, String school, String letter, String cv, String source,
			ICandidateProxy candidate);

	public IJobApplicationProxy editJobApplication(IJobApplicationProxy jobApplicationProxy);

	public List<IJobApplicationProxy> listOfJobApplicationByUsername(String username);
	
	public IJobApplicationProxy spontaneousJobApplicationByUsername(String username);

	public IJobApplicationProxy findId (long id);
	
	public List<IJobApplicationProxy> listOfJobApplicationByCandidate (ICandidateProxy candidate);
	
	public IJobApplicationProxy saveProposal(ProposalStatus status, String observation, IJobApplicationProxy jobApp);
	
	public List<IJobApplicationProxy> listOfAllSpontaneous();
	
	public List<IJobApplicationProxy> listOfAllSpontaneousSituation();
	
	public String submitPositionOnSpontaneousApplication(IJobApplicationProxy jobApplication);
	
	public List <IJobApplicationProxy> listOfAllAppNOTSpontaneousSituation ();
	
	public void deleteJobApplicationByCandidate(IJobApplicationProxy jobApplicationProxy);
	
	
}
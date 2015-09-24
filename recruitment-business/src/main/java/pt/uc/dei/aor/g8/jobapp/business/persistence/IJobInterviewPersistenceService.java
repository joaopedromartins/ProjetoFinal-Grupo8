package pt.uc.dei.aor.g8.jobapp.business.persistence;

import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.model.IJobInterviewProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;

public interface IJobInterviewPersistenceService {

	
	public IJobInterviewProxy newInterview (IJobInterviewProxy proxyInterview);
	
	public List<IJobInterviewProxy> listOfAllInterviews ();
	
	public List <IJobInterviewProxy> listInterviewsOfInterview (IUserProxy interviewer);
	
	public IJobInterviewProxy findById(long id);

	public IJobInterviewProxy updateInterview(IJobInterviewProxy interview);
}

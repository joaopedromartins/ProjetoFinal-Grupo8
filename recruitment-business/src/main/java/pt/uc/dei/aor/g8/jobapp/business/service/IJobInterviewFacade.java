package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.Date;
import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobInterviewProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;

public interface IJobInterviewFacade {

	public IJobInterviewProxy newInterview (Date interviewDate, IUserProxy userInterview, IJobApplicationProxy jobapplication);
	
	public List <IJobInterviewProxy> listOfAllInterviews ();
	
	public List <IJobInterviewProxy> listInterviewsOfInterviewer (IUserProxy interviewer);
}

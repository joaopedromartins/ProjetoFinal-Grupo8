package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.Date;
import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.model.IAnswerInterviewProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobInterviewProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IScriptProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;

public interface IJobInterviewFacade {

	public IJobInterviewProxy newInterview (Date interviewDate, IUserProxy userInterview, IJobApplicationProxy jobapplication, IScriptProxy script);
	
	public List <IJobInterviewProxy> listOfAllInterviews ();
	
	public List <IJobInterviewProxy> listInterviewsOfInterviewer (IUserProxy interviewer);
	
	public IJobInterviewProxy findById(long id);

	public List<IAnswerInterviewProxy> getListAnswers(IScriptProxy scriptInterview);
}

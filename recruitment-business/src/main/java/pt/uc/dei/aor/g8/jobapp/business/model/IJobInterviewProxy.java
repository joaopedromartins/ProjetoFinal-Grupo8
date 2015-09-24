package pt.uc.dei.aor.g8.jobapp.business.model;

import java.util.Date;
import java.util.List;

public interface IJobInterviewProxy {

	public Date getInterviewDate();
	public void setInterviewDate(Date interviewDate);

	public IUserProxy getInterviewer();
	public void setInterviewer(IUserProxy interviewer);


	public IJobApplicationProxy getJobapplication();
	public void setJobapplication(IJobApplicationProxy jobapplication);
	
	public List<IAnswerInterviewProxy> getAnswer();
	public void setAnswer(List<IAnswerInterviewProxy> answer);
	
	public IScriptProxy getScriptInterview();
	public void setScriptInterview(IScriptProxy scriptInterview);
	
	public long getId();
}

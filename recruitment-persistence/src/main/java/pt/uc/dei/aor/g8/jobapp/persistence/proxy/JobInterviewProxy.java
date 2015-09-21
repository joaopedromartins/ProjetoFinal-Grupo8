package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.model.IAnswerInterviewProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobInterviewProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.AnswerInterviewEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.JobApplicationEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.JobInterviewEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.UserEntity;

@Stateless
public class JobInterviewProxy implements IJobInterviewProxy, IEntityAware<JobInterviewEntity> {

	private JobInterviewEntity entity;
	
	public JobInterviewProxy() {
		this(null);
	}
	public JobInterviewProxy ( JobInterviewEntity jobInterview) {
		if (jobInterview == null){
			this.entity = new JobInterviewEntity();
		} else {
			this.entity = jobInterview;
		}
	}
	
	public JobInterviewProxy(Date interviewDate, IUserProxy interviewer, IJobApplicationProxy jobapplication) {
		this.entity = new JobInterviewEntity(interviewDate,userConverterProxyToEntity(interviewer),jobApplicationProxyToEntity(jobapplication));
	}
	
	
	@Override
	public JobInterviewEntity getEntity() {
		return entity;
	}
	@Override
	public Date getInterviewDate() {
		return entity.getInterviewDate();
	}
	@Override
	public void setInterviewDate(Date interviewDate) {
		entity.setInterviewDate(interviewDate);
	}
	@Override
	public IUserProxy getInterviewer() {
		return new UserProxy(entity.getInterviewer());
	}
	@Override
	public void setInterviewer(IUserProxy interviewer) {
		entity.setInterviewer(userConverterProxyToEntity(interviewer));
	}
	@Override
	public IJobApplicationProxy getJobapplication() {
		return new JobApplicationProxy(entity.getJobapplication());
	}
	@Override
	public void setJobapplication(IJobApplicationProxy jobapplication) {
		entity.setJobapplication(jobApplicationProxyToEntity(jobapplication));
	}
	@Override
	public List<IAnswerInterviewProxy> getAnswer() {
		List <IAnswerInterviewProxy> proxy = new ArrayList<>();
		
		List <AnswerInterviewEntity> entityAnswer = entity.getAnswer();
		for (AnswerInterviewEntity a: entityAnswer){
			proxy.add(new AnswerInterviewProxy(a));
		}
		return proxy;
	}
	@Override
	public void setAnswer(List<IAnswerInterviewProxy> answer) {
		entity.setAnswer(answerInterviewerProxyToEntity(answer));
	}
	
	@SuppressWarnings( "unchecked" )
	private UserEntity userConverterProxyToEntity ( IUserProxy proxy){
		UserEntity entityUser = ((IEntityAware<UserEntity>)proxy).getEntity();
		return entityUser;
	}
	
	@SuppressWarnings("unchecked")
	private JobApplicationEntity jobApplicationProxyToEntity (IJobApplicationProxy proxy){
		JobApplicationEntity entityJobApplication = ((IEntityAware<JobApplicationEntity>) proxy).getEntity();
		return entityJobApplication;
	}
	
	@SuppressWarnings("unchecked")
	private List <AnswerInterviewEntity> answerInterviewerProxyToEntity (List <IAnswerInterviewProxy> answerInterviewer){
		List <AnswerInterviewEntity> entityAnswer = new ArrayList<>();
		
		for (IAnswerInterviewProxy a: answerInterviewer){
			entityAnswer.add(((IEntityAware<AnswerInterviewEntity>) a).getEntity());
		}
		return entityAnswer;
	}

}

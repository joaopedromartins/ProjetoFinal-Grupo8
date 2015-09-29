package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.model.IAnswerInterviewProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobInterviewProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IScriptProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.AnswerInterviewEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.JobApplicationEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.JobInterviewEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.ScriptEntity;
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
	
	public JobInterviewProxy(Date interviewDate, List<IUserProxy> interviewers, IJobApplicationProxy jobapplication, IScriptProxy script) {
		this.entity = new JobInterviewEntity(interviewDate,userConverterProxyToEntity(interviewers),jobApplicationProxyToEntity(jobapplication), scriptConvertProxyToEntity(script));
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
	public List<IUserProxy> getInterviewers() {
		List <IUserProxy> proxyUser = new ArrayList<>();
		
		List <UserEntity> entityUser = entity.getInterviewers();
		for (UserEntity i: entityUser){
			proxyUser.add(new UserProxy(i));
		}
		return proxyUser;
	}
	
	@Override
	public String getInterviewersAsString (){
		List<IUserProxy> interviwers= getInterviewers();
		if (interviwers.size() < 1) {
			return " ";
		} else {
			String listInterviwers="";
			for (IUserProxy uI: interviwers){
				if(listInterviwers.equals("")){
					listInterviwers = "" + uI.getFullName();
				} else {
					listInterviwers=listInterviwers + ", " + uI.getFullName();
				}
			}
			return listInterviwers; 
		}
	}
	@Override
	public void setInterviewers(List<IUserProxy> interviewers) {
		entity.setInterviewers(userConverterProxyToEntity(interviewers));
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
		
		Set <AnswerInterviewEntity> entityAnswer = entity.getAnswer();
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
	private List<UserEntity> userConverterProxyToEntity ( List<IUserProxy> proxyUsers){
		List <UserEntity> entityUser = new ArrayList<>();
		
		for (IUserProxy i: proxyUsers){
			entityUser.add(((IEntityAware<UserEntity>)i).getEntity());
		}
		
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
	
	
	@SuppressWarnings("unchecked")
	private ScriptEntity scriptConvertProxyToEntity(IScriptProxy script) {
		ScriptEntity entityScript =((IEntityAware<ScriptEntity>)script).getEntity();	
		return entityScript;
	}
	
	@Override
	public IScriptProxy getScriptInterview() {	
		return new ScriptProxy(entity.getScriptInterview());
	}
	
	@Override
	public void setScriptInterview(IScriptProxy scriptInterview) {	
		entity.setScriptInterview(scriptConvertProxyToEntity(scriptInterview));
	}
	@Override
	public long getId() {
		
		return entity.getId();
	}
	@Override
	public boolean getFinished() {
		return entity.isFinished();
	}
	@Override
	public void setFinhished(boolean finished) {
		entity.setFinished(finished);		
	}

}

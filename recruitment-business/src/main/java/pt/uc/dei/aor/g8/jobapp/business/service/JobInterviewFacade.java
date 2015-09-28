package pt.uc.dei.aor.g8.jobapp.business.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.JobAppSituation;
import pt.uc.dei.aor.g8.jobapp.business.model.IAnswerInterviewProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobInterviewProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IProxyFactory;
import pt.uc.dei.aor.g8.jobapp.business.model.IQuestionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IScriptProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IJobApplicationPersistenceService;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IJobInterviewPersistenceService;
import pt.uc.dei.aor.g8.jobapp.business.util.GmailMessage;

@Stateless
public class JobInterviewFacade implements IJobInterviewFacade {

	private static final Logger log = LoggerFactory.getLogger(JobInterviewFacade.class);
	
	@EJB
	private IProxyFactory factory;
	@EJB
	private IJobInterviewPersistenceService service;
	@EJB
	private IJobApplicationPersistenceService applicationService;
	@EJB
	private INotificationFacade notification;
	@EJB
	private GmailMessage mail;
	
	@Override
	public IJobInterviewProxy newInterview(Date interviewDate, IUserProxy userInterviewer,
			IJobApplicationProxy jobapplication, IScriptProxy script) {
		
		IJobInterviewProxy newInterview = factory.jobInterview(interviewDate, userInterviewer, jobapplication, script);
			
		try {
			newInterview = service.newInterview(newInterview);
			jobapplication.setSituation(JobAppSituation.INTERVIEWING);
			applicationService.editJobApplication(jobapplication);
		} catch (EJBTransactionRolledbackException e) {
			log.error(e.getMessage());
			return null;
		}
		SimpleDateFormat date = new SimpleDateFormat( "dd/MM/yyyy - HH:mm " );
		String dateFormat = date.format(interviewDate);
		
	/*	//Interviewer
		notification.createNotification("Schedule Interview"," You have a interview, on " 
				+ dateFormat + ", with  candidate , " + jobapplication.getCandidateEntity().getFullName() + ".\n You can see candidate information ", "", userInterviewer);*/
		
		String msgEmail ="<p>Interview for position "+
				jobapplication.getPositionEntity().getTitle()+" was created and assigned you as interviewer.</p>"+
				"<p>Date: "+dateFormat+"</p>"+
				"<p>Candidate: "+jobapplication.getCandidateEntity().getFullName()+"</p>"+
				"<p>Interviewers: "+userInterviewer.getFullName()+
				"<p><a href='http://localhost:8080/CriticalJobApplicationHR/interviewer/detailCandidate.xhtml?candidateId="+
				jobapplication.getCandidateEntity().getId()+"'>Details</a></p>";
		mail.sendEmailHTML(userInterviewer.getEmail(), "jobappmailtest@gmail.com","Shedule Interview" ,msgEmail);
		
		/*//Candidate
		mail.sendEmail(jobapplication.getCandidateEntity().getEmail(), "jobappmailtest@gmail.com", "Interview schedules", "You have interview on " + dateFormat	+ "\nPassword - " + passwordGenerate + "");*/
			
	
		
		return newInterview;
	}

	@Override
	public List<IJobInterviewProxy> listOfAllInterviews() {
		
		return service.listOfAllInterviews();
	}

	@Override
	public List<IJobInterviewProxy> listInterviewsOfInterviewer(IUserProxy interviewer) {
	
		return service.listInterviewsOfInterview(interviewer);
	}

	@Override
	public IJobInterviewProxy findById(long id) {
		return service.findById(id);
	}

	@Override
	public List<IAnswerInterviewProxy> getListAnswers(IScriptProxy scriptInterview) {
		int sizeListQuestions = scriptInterview.getQuestions().size();
		List<IAnswerInterviewProxy> answers = new ArrayList<>();
		List<IQuestionProxy> questions = scriptInterview.getQuestions();
		
		for (int i = 0; i<sizeListQuestions ; i++){
			answers.add(factory.answerInterview((questions.get(i).getQuestion()),(questions.get(i).getQuestiontype().getDescription())));
		}
		return answers;
	}

	@Override
	public IJobInterviewProxy saveAnswersOfScript(List<IAnswerInterviewProxy> answers, IJobInterviewProxy interview) {
		try{
			interview.setAnswer(answers);
			interview.setFinhished(true);
			return service.updateInterview(interview);
			
		}catch (EJBTransactionRolledbackException e){
			log.error(e.getMessage());
			return null;
		}	
	}

}

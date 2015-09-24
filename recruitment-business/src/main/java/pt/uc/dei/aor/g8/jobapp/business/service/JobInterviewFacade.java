package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.model.IAnswerInterviewProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobInterviewProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IProxyFactory;
import pt.uc.dei.aor.g8.jobapp.business.model.IQuestionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IScriptProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IJobInterviewPersistenceService;

@Stateless
public class JobInterviewFacade implements IJobInterviewFacade {

	@EJB
	private IProxyFactory factory;
	@EJB
	private IJobInterviewPersistenceService service;
	
	@Override
	public IJobInterviewProxy newInterview(Date interviewDate, IUserProxy userInterviewer,
			IJobApplicationProxy jobapplication, IScriptProxy script) {
		IJobInterviewProxy newInterview = factory.jobInterview(interviewDate, userInterviewer, jobapplication, script);
		return service.newInterview(newInterview);
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

}

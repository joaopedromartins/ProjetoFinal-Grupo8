package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.Localization;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.QuestionType;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.RoleType;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.StatusPosition;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.TechnicalArea;
import pt.uc.dei.aor.g8.jobapp.business.model.IAnswerInterviewProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobInterviewProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.INotificationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IProposalProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IProxyFactory;
import pt.uc.dei.aor.g8.jobapp.business.model.IQuestionChoiceProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IQuestionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IQuestionScaleProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IScriptProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;


@Stateless
public class ProxyFactory implements IProxyFactory {

	public ProxyFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IPositionProxy position(Date openDate, String code, String title,
			List<Localization> localization, StatusPosition status, int numberOfposition, Date sLA, IUserProxy managerPosition,
			IUserProxy adminPosition, String company, TechnicalArea technicalArea, String descriptionPosition, List<IJobAdvertisingChanelProxy> jobAdvertisingChanel,
			List<IScriptProxy> script) {

		return new PositionProxy (openDate,code,title,localization,status,numberOfposition,sLA, managerPosition,adminPosition,company,technicalArea,descriptionPosition, jobAdvertisingChanel,script);
	}

	@Override
	public IJobAdvertisingChanelProxy jobAdvertisingChanel(String chanelName) {
		return new JobAdvertisingChanelProxy(chanelName);
	}

	@Override
	public IUserProxy user(String username, String password, String lastname, String firstname, String email,
			List<RoleType> roles) {

		return new UserProxy(username,password,lastname,firstname,email,roles);
	}

	@Override
	public ICandidateProxy candidate(String username, String password, String lastname, String firstname, String email, String mobile, String linkedinAddress) {
		return new CandidateProxy (username, password, lastname, firstname, email, mobile, linkedinAddress);
	}

	@Override
	public INotificationProxy notification(String title, Date notificationDate, String message, String signature,
			IUserProxy userReceiver) {
		return new NotificationProxy (title,notificationDate,message,signature,userReceiver);
	}

	public IScriptProxy script() {
		return new ScriptProxy();
	}

	@Override
	public IQuestionProxy question(String question, QuestionType questionType) {
		return new QuestionProxy(question,questionType);
	}

	@Override
	public IQuestionProxy question(String question, QuestionType questionType, IQuestionScaleProxy newScale) {
		return new QuestionProxy(question,questionType,newScale);
	}

	@Override
	public IQuestionProxy question(String question, QuestionType questionType, List<IQuestionChoiceProxy> options) {
		return new QuestionProxy(question,questionType,options);
	}


	@Override
	public IQuestionScaleProxy scale(int min, int max, String minLabel, String maxLabel) {
		return new QuestionScaleProxy(min,max,minLabel,maxLabel);
	}

	@Override
	public IQuestionChoiceProxy choise(String option) {
		return new QuestionChoiceProxy (option) ;
	}

	@Override
	public IJobApplicationProxy jobApplication(String address, String city, String country, String phone,
			String diploma, String school, String letter, String cv, String source,
			ICandidateProxy candidate, IPositionProxy position) {
		return new JobApplicationProxy( address,  city,  country,  phone,
				diploma,  school,  letter,  cv, source, candidate, position);
	}

	@Override
	public IJobApplicationProxy spontaneousJobApplication(String address, String city, String country, String phone,
			String diploma, String school, String letter, String cv, String source, ICandidateProxy candidate) {

		return new JobApplicationProxy(address,  city,  country,  phone, diploma,  school,  letter,  cv, source, candidate);
	}

	@Override
	public IJobInterviewProxy jobInterview(Date interviewDate, List<IUserProxy> interviewers,
			IJobApplicationProxy jobapplication, IScriptProxy script) {

		return new JobInterviewProxy(interviewDate, interviewers,jobapplication,script);
	}

	@Override
	public IAnswerInterviewProxy answerInterview(String question, String questionType) {
		return new AnswerInterviewProxy(question,questionType);
	}

	@Override
	public IProposalProxy proposalJobApplication(Date proposalDate, String proposal) {
		return new ProposalProxy(proposalDate, proposal);
	}



}

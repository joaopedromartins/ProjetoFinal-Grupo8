package pt.uc.dei.aor.g8.jobapp.business.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.Localization;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.QuestionType;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.RoleType;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.Status;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.TechnicalArea;


public interface IProxyFactory {

	public IPositionProxy position(Date openDate, String code, String title,
			List<Localization> localization, Status status, int numberOfposition, Date sLA, IUserProxy managerPosition,
			String company, TechnicalArea technicalArea, String descriptionPosition, List<IJobAdvertisingChanelProxy> jobAdvertisingChanel,
			List<IScriptProxy> script);

	public IJobApplicationProxy jobApplication(String address, String city, String country, BigInteger phone,
			String diploma, String school, String letter, String cv, String source, String status, 
			ICandidateProxy candidate, IPositionProxy position);

	public IJobAdvertisingChanelProxy jobAdvertisingChanel(String chanelName);


	public ICandidateProxy candidate(String username, String password, String lastname, String firstname, String email, BigInteger mobile);

	public IUserProxy user(String username, String password, String lastname, String firstname, String email,
			List<RoleType> roles);

	public INotificationProxy notification (String title, Date notificationDate, String message, String signature, IUserProxy userReceiver);

	public IScriptProxy script ();

	public IQuestionProxy question (String question, QuestionType questionType);

	public IQuestionScaleProxy scale (int min,int max, String minLabel, String maxLabel);

	public IQuestionProxy question(String question, QuestionType questionType, IQuestionScaleProxy newScale);

	public IQuestionChoiceProxy choise (String option);

	public IQuestionProxy question (String question, QuestionType questionType, List<IQuestionChoiceProxy> options);

	public IJobInterviewProxy jobInterview (Date interviewDate, IUserProxy interviewer, IJobApplicationProxy jobapplication , IScriptProxy script);
}

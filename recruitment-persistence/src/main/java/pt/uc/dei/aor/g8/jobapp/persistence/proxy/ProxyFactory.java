package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.business.enumeration.Localization;
import pt.uc.dei.aor.g8.business.enumeration.QuestionType;
import pt.uc.dei.aor.g8.business.enumeration.RoleType;
import pt.uc.dei.aor.g8.business.enumeration.Status;
import pt.uc.dei.aor.g8.business.enumeration.TechnicalArea;
import pt.uc.dei.aor.g8.jobapp.business.model.ICandidateProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobApplicationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.INotificationProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
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
	public IPositionProxy position(Date openDate, Date closeDate, String code, String title,
			List<Localization> localization, Status status, int numberOfposition, Date sLA, String userPosition,
			String company, TechnicalArea technicalArea, String descriptionPosition, List<IJobAdvertisingChanelProxy> jobAdvertisingChanel,
			List<String> script) {
		
		return new PositionProxy (openDate,closeDate,code,title,localization,status,numberOfposition,sLA, userPosition,company,technicalArea,descriptionPosition, jobAdvertisingChanel,script);
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
	public ICandidateProxy candidate(String username, String password, String lastname, String firstname, String email, BigInteger mobile) {
		return new CandidateProxy (username, password, lastname, firstname, email, mobile);
	}

	@Override
	public INotificationProxy notification(String title, Date notificationDate, String message, String signature,
			IUserProxy userReceiver) {
		return new NotificationProxy (title,notificationDate,message,signature,userReceiver);
	}

	@Override
	public IJobApplicationProxy jobApplication(String address, String city, String country, BigInteger phone,
			String diploma, String school, String letter, String cv, IJobAdvertisingChanelProxy source, String status) {
		// TODO Auto-generated method stub
		return null;
		//return new IJobApplicationProxy( address,  city,  country,  phone,
		//		 diploma,  school,  letter,  cv, source.getChanelName(),  status);
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
	public IQuestionScaleProxy scale(int min, int max, String minLabel, String maxLabel) {
		return new QuestionScaleProxy(min,max,minLabel,maxLabel);
	}

	@Override
	public IQuestionChoiceProxy choise(String option) {
		
		return new QuestionChoiceProxy (option) ;
	}

	@Override
	public IQuestionProxy question(String question, QuestionType questionType, List<IQuestionChoiceProxy> options) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

package pt.uc.dei.aor.g8.jobapp.business.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import pt.uc.dei.aor.g8.business.enumeration.Localization;
import pt.uc.dei.aor.g8.business.enumeration.RoleType;
import pt.uc.dei.aor.g8.business.enumeration.Status;
import pt.uc.dei.aor.g8.business.enumeration.TechnicalArea;

public interface IProxyFactory {
	
	public IPositionProxy position(Date openDate, Date closeDate, String code, String title,
			List<Localization> localization, Status status, int numberOfposition, Date sLA, String userPosition,
			String company, TechnicalArea technicalArea, String descriptionPosition, List<IJobAdvertisingChanelProxy> jobAdvertisingChanel,
			List<String> script);
	
	public IJobAdvertisingChanelProxy jobAdvertisingChanel(String chanelName);
	

	public ICandidateProxy candidate(String username, String password, String lastname, String firstname, String email, BigInteger mobile);

	public IUserProxy user(String username, String password, String lastname, String firstname, String email,
			List<RoleType> roles);

	public INotificationProxy notification (String title, Date notificationDate, String message, String signature, IUserProxy userReceiver);
	
	public IScriptProxy script ();
	
}

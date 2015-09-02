package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.business.enumeration.Localization;
import pt.uc.dei.aor.g8.business.enumeration.RoleType;
import pt.uc.dei.aor.g8.business.enumeration.Status;
import pt.uc.dei.aor.g8.business.enumeration.TechnicalArea;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IProxyFactory;
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
	
	

}

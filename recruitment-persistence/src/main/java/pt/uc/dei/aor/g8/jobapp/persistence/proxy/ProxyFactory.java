package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.business.enumeration.Localization;
import pt.uc.dei.aor.g8.business.enumeration.Status;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IProxyFactory;


@Stateless
public class ProxyFactory implements IProxyFactory {

	public ProxyFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IPositionProxy position(Date openDate, Date closeDate, String code, String title,
			List<Localization> localization, Status status, int numberOfposition, String sLA, String userPosition,
			String company, String technicalArea, String descriptionPosition, List<String> jobAdvertisingChanel,
			List<String> script) {
		
		return new PositionProxy (openDate,closeDate,code,title,localization,status,numberOfposition,sLA, userPosition,company,technicalArea,descriptionPosition, jobAdvertisingChanel,script);
	}

}

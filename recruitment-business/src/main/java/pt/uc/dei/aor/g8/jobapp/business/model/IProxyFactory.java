package pt.uc.dei.aor.g8.jobapp.business.model;

import java.util.Date;
import java.util.List;

import pt.uc.dei.aor.g8.business.enumeration.Localization;
import pt.uc.dei.aor.g8.business.enumeration.Status;
import pt.uc.dei.aor.g8.business.enumeration.TechnicalArea;

public interface IProxyFactory {
	
	public IPositionProxy position(Date openDate, Date closeDate, String code, String title,
			List<Localization> localization, Status status, int numberOfposition, String sLA, String userPosition,
			String company, TechnicalArea technicalArea, String descriptionPosition, List<IJobAdvertisingChanelProxy> jobAdvertisingChanel,
			List<String> script);
	
	public IJobAdvertisingChanelProxy jobAdvertisingChanel(String chanelName);
	
}

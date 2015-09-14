package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.Date;
import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.Localization;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.Status;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.TechnicalArea;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;


public interface IPositionFacade {

	public IPositionProxy creatNewPosition(Date openDate, Date closeDate, String code, String title, List<Localization> localization, Status status,
			int numberOfposition, Date sLA, String userPosition, String company, TechnicalArea technicalArea,
			String descriptionPosition, List<IJobAdvertisingChanelProxy> jobAdvertisingChanel, List<String> script);

	public List<IPositionProxy> listOfAllPosition();

	public IPositionProxy editPosition(IPositionProxy positionProxy);

	public List<IPositionProxy> listOfAllOpenPosition();
}

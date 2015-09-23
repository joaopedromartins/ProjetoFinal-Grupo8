package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.Date;
import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.Localization;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.Status;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.TechnicalArea;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IScriptProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;


public interface IPositionFacade {

	public IPositionProxy creatNewPosition(Date openDate, String title, List<Localization> localization, Status status,
			int numberOfposition, Date sLA, IUserProxy managerPosition, String company, TechnicalArea technicalArea,
			String descriptionPosition, List<IJobAdvertisingChanelProxy> jobAdvertisingChanel, List<IScriptProxy> script);

	public List<IPositionProxy> listOfAllPosition();

	public IPositionProxy editPosition(IPositionProxy positionProxy);

	public List<IPositionProxy> listOfAllOpenPosition();
}

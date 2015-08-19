package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.Date;
import java.util.List;

import pt.uc.dei.aor.g8.business.enumeration.Localization;
import pt.uc.dei.aor.g8.business.enumeration.Status;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;


public interface IPositionFacade {

	public IPositionProxy creatNewPosition(Date openDate, Date closeDate, String code, String title, List<Localization> localization, Status status,
			int numberOfposition, String sLA, String userPosition, String company, String technicalArea,
			String descriptionPosition, List<String> jobAdvertisingChanel, List<String> script);

	public List<IPositionProxy> listOfAllPosition();
}

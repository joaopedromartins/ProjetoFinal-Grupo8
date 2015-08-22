package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.business.enumeration.Localization;
import pt.uc.dei.aor.g8.business.enumeration.Status;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IProxyFactory;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IPositionPersistenceService;

@Stateless
public class PositionFacade implements IPositionFacade {

	@EJB
	private IProxyFactory factory;
	
	@EJB
	private IPositionPersistenceService service;

	public PositionFacade() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IPositionProxy creatNewPosition(Date openDate, Date closeDate, String code, String title,
			List<Localization> localization, Status status, int numberOfposition, String sLA, String userPosition,
			String company, String technicalArea, String descriptionPosition, List<String> jobAdvertisingChanel,
			List<String> script) {

		IPositionProxy newPosition= factory.position(openDate, closeDate, code, title, localization, status, 
				numberOfposition, sLA, userPosition, company, technicalArea, descriptionPosition,
				jobAdvertisingChanel, script);
		
		
		return service.savePosition(newPosition);
	}

	@Override
	public List<IPositionProxy> listOfAllPosition() {
		
		return service.listOfAllPosition();
	}

}
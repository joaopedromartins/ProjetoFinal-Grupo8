package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.Localization;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.Status;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.TechnicalArea;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IProxyFactory;
import pt.uc.dei.aor.g8.jobapp.business.model.IScriptProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
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
	public IPositionProxy creatNewPosition(Date openDate, String title,
			List<Localization> localization, Status status, int numberOfposition, Date sLA, IUserProxy managerPosition,
			String company, TechnicalArea technicalArea, String descriptionPosition, List<IJobAdvertisingChanelProxy> jobAdvertisingChanel,
			List<IScriptProxy> script) {
		
		IPositionProxy lastPosition = service.lasPositionOfListPosition();
		String code;
		if(lastPosition == null){
			code =""+1 ;
		} else {
			code = String.valueOf(Integer.parseInt( lastPosition.getCode()) + 1);
		}

		IPositionProxy newPosition= factory.position(openDate, code, title, localization, status, 
				numberOfposition, sLA, managerPosition, company, technicalArea, descriptionPosition,
				jobAdvertisingChanel, script);
		
		
		return service.savePosition(newPosition);
	}

	@Override
	public List<IPositionProxy> listOfAllPosition() {
		
		return service.listOfAllPosition();
	}

	@Override
	public IPositionProxy editPosition(IPositionProxy positionProxy) {
		return service.editPosition(positionProxy);
	}

	@Override
	public List<IPositionProxy> listOfAllOpenPosition() {
		return service.listOfAllOpenPosition();
	}

	@Override
	public List<IPositionProxy> listOfAllPositionManager(IUserProxy currentUser) {
		
		return service.listOfAllPositionManager(currentUser);
	}

	@Override
	public List<IScriptProxy> listScriptOfPosition(IPositionProxy positionProxy) {
		
		return service.listScriptOfPosition(positionProxy);
	}
	
	

}

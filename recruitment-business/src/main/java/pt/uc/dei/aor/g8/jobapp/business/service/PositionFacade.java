package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.Localization;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.StatusPosition;
import pt.uc.dei.aor.g8.jobapp.business.enumeration.TechnicalArea;
import pt.uc.dei.aor.g8.jobapp.business.model.IJobAdvertisingChanelProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IProxyFactory;
import pt.uc.dei.aor.g8.jobapp.business.model.IScriptProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IPositionPersistenceService;

@Stateless
public class PositionFacade implements IPositionFacade {

	private static final Logger log = LoggerFactory.getLogger(PositionFacade.class);

	@EJB
	private IProxyFactory factory;

	@EJB
	private IPositionPersistenceService service;

	public PositionFacade() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IPositionProxy creatNewPosition(Date openDate, String title,
			List<Localization> localization, StatusPosition status, int numberOfposition, Date sLA, IUserProxy managerPosition,
			IUserProxy adminPosition,String company, TechnicalArea technicalArea, String descriptionPosition, List<IJobAdvertisingChanelProxy> jobAdvertisingChanel,
			List<IScriptProxy> script) {

		IPositionProxy lastPosition = service.lasPositionOfListPosition();
		String code;
		if(lastPosition == null){
			code =""+1 ;
		} else {
			code = String.valueOf(Integer.parseInt( lastPosition.getCode()) + 1);
		}

		IPositionProxy newPosition= factory.position(openDate, code, title, localization, status, 
				numberOfposition, sLA, managerPosition, adminPosition, company, technicalArea, descriptionPosition,
				jobAdvertisingChanel, script);


		return service.savePosition(newPosition);
	}

	@Override
	public List<IPositionProxy> listOfAllPosition() {
		try{
			return service.listOfAllPosition();
		}catch (EJBTransactionRolledbackException e){
			log.error(e.getMessage());
			return null;
		}

	}

	@Override
	public IPositionProxy editPosition(IPositionProxy positionProxy) {
		if( positionProxy.getStatus()== StatusPosition.CLOSE){
			positionProxy.setCloseDate(new Date());
		}
		return service.editPosition(positionProxy);
	}

	@Override
	public List<IPositionProxy> listOfAllOpenPosition() {
		try{
			return service.listOfAllOpenPosition();
		}catch (EJBTransactionRolledbackException e){
			log.error(e.getMessage());
			return null;
		}
	}

	@Override
	public List<IPositionProxy> listOfAllPositionManager(IUserProxy currentUser) {
		try{
			return service.listOfAllPositionManager(currentUser);
		}catch (EJBTransactionRolledbackException e){
			log.error(e.getMessage());
			return null;
		}
	}

	@Override
	public List<IScriptProxy> listScriptOfPosition(IPositionProxy positionProxy) {
		try{
			return service.listScriptOfPosition(positionProxy);
		}catch (EJBTransactionRolledbackException e){
			log.error(e.getMessage());
			return null;
		}
	}



}

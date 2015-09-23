package pt.uc.dei.aor.g8.jobapp.business.persistence;

import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IScriptProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;

public interface IPositionPersistenceService {

	public IPositionProxy savePosition(IPositionProxy newPosition);

	public List<IPositionProxy> listOfAllPosition();

	public IPositionProxy editPosition(IPositionProxy positionProxy);

	public List<IPositionProxy> listOfAllOpenPosition();
	
	public IPositionProxy lasPositionOfListPosition();
	
	public List<IPositionProxy> listOfAllPositionManager (IUserProxy manager);

	public List<IScriptProxy> listScriptOfPosition(IPositionProxy positionProxy);
}

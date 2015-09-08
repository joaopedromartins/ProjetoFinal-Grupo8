package pt.uc.dei.aor.g8.jobapp.business.persistence;

import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;

public interface IPositionPersistenceService {

	public IPositionProxy savePosition(IPositionProxy newPosition);

	public List<IPositionProxy> listOfAllPosition();

	public IPositionProxy editPosition(IPositionProxy positionProxy);

	public List<IPositionProxy> listOfAllOpenPosition();
}

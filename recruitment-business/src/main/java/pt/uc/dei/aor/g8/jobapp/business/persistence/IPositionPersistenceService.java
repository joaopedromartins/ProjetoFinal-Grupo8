package pt.uc.dei.aor.g8.jobapp.business.persistence;

import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;

public interface IPositionPersistenceService {

	public IPositionProxy savePosition(IPositionProxy newPosition);
	
}

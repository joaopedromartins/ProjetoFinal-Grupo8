package pt.uc.dei.aor.g8.jobapp.persistence.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IPositionPersistenceService;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.PositionEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.IEntityAware;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.PositionProxy;


@Stateless
public class PositionPersistenceService implements IPositionPersistenceService {

	@PersistenceContext (unitName="recruitment")
	private EntityManager em;
	
	public PositionPersistenceService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IPositionProxy savePosition(IPositionProxy newPosition) {
		PositionEntity entity = getEntity(newPosition);
		em.persist(entity);
		return new PositionProxy(entity);
	}


	@SuppressWarnings("unchecked")
	private PositionEntity getEntity(IPositionProxy positionProxy) {
		if (positionProxy instanceof IEntityAware<?>) {
			return ((IEntityAware<PositionEntity>) positionProxy).getEntity();
		}
		throw new IllegalStateException();
	}
}

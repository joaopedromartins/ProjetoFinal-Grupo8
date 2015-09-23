package pt.uc.dei.aor.g8.jobapp.persistence.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pt.uc.dei.aor.g8.jobapp.business.model.IPositionProxy;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IPositionPersistenceService;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.PositionEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.UserEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.IEntityAware;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.PositionProxy;


@Stateless
public class PositionPersistenceService implements IPositionPersistenceService {

	@PersistenceContext (unitName="recruitment")
	private EntityManager em;
	
	public PositionPersistenceService() {
		
	}

	@Override
	public IPositionProxy savePosition(IPositionProxy newPosition) {
		PositionEntity entity = getEntity(newPosition);
		em.persist(entity);
		return new PositionProxy(entity);
	}
	
	@Override
	public IPositionProxy editPosition(IPositionProxy positionProxy) {
		PositionEntity entity = getEntity(positionProxy);
		entity=em.merge(entity);
		return new PositionProxy(entity);
	}
	
	


	@SuppressWarnings("unchecked")
	private PositionEntity getEntity(IPositionProxy positionProxy) {
		if (positionProxy instanceof IEntityAware<?>) {
			return ((IEntityAware<PositionEntity>) positionProxy).getEntity();
		}
		throw new IllegalStateException();
	}

	@Override
	public List<IPositionProxy> listOfAllPosition() {
		TypedQuery<PositionEntity> query = em.createNamedQuery(PositionEntity.LIST_OF_ALL_POSITION, PositionEntity.class);
		List<PositionEntity> entity= query.getResultList();
		
		List<IPositionProxy> proxy= new ArrayList<>();
		for(PositionEntity p: entity){
			proxy.add(new PositionProxy(p));
		}
		
		return proxy;
	}



	@Override
	public List<IPositionProxy> listOfAllOpenPosition() {
		TypedQuery<PositionEntity> query = em.createNamedQuery(PositionEntity.LIST_OF_ALL_OPEN_POSITION, PositionEntity.class); 
		List<PositionEntity> entity = query.getResultList();
		
		List<IPositionProxy> proxy = new ArrayList<>();
		for(PositionEntity p: entity){
			proxy.add(new PositionProxy(p));
		}
		
		return proxy;
	}
	

	@Override
	public IPositionProxy lasPositionOfListPosition() {
		TypedQuery <PositionEntity> query = em.createNamedQuery(PositionEntity.LAST_POSITION_OF_LIST_POSITION,PositionEntity.class);
		List <PositionEntity> entity = query.getResultList();
		
		IPositionProxy proxy;
		if( entity.size() == 1){
			proxy = new PositionProxy(entity.get(0));
		} else {
			proxy=null;
		}
		return proxy;
	}

	@SuppressWarnings("unchecked")
	private UserEntity getUserEntity(IUserProxy userProxy) {
		if (userProxy instanceof IEntityAware<?>) {
			return ((IEntityAware<UserEntity>) userProxy).getEntity();
		}
		throw new IllegalStateException();
	}
	
	@Override
	public List<IPositionProxy> listOfAllPositionManager(IUserProxy manager) {
		TypedQuery<PositionEntity> query = em.createNamedQuery(PositionEntity.LIST_OF_ALL_POSITION_MANAGER, PositionEntity.class); 
		query.setParameter("manager",getUserEntity(manager));
		List<PositionEntity> entity = query.getResultList();
		
		List<IPositionProxy> proxy = new ArrayList<>();
		for(PositionEntity p: entity){
			proxy.add(new PositionProxy(p));
		}
		
		return proxy;
	}
	
	
}

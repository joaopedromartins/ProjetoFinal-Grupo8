package pt.uc.dei.aor.g8.jobapp.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IUserPersistenceService;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.UserEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.IEntityAware;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.UserProxy;

@Stateless
public class UserPersistenceService implements IUserPersistenceService {

	@PersistenceContext (unitName="recruitment")
	private EntityManager em;
	
	
	public UserPersistenceService() {
	}

	@Override
	public IUserProxy createUser(IUserProxy proxy) {
		UserEntity entity = getEntity(proxy);
		em.persist(entity);
		
		return new UserProxy(entity);
	}
	
	@SuppressWarnings("unchecked")
	private UserEntity getEntity(IUserProxy userProxy) {
		if (userProxy instanceof IEntityAware<?>) {
			return ((IEntityAware<UserEntity>) userProxy).getEntity();
		}
		throw new IllegalStateException();
	}

	@Override
	public IUserProxy findUserByUsername(String username) {
		TypedQuery <UserEntity> query = em.createNamedQuery(UserEntity.FIND_USER_BY_USERNAME, UserEntity.class);
		query.setParameter("username",username);
		List <UserEntity> entity = query.getResultList();
		
		IUserProxy proxy;
		if( entity.size() == 1){
			proxy = new UserProxy(entity.get(0));
		} else {
			proxy=null;
		}
		
		return proxy;
	}

	@Override
	public IUserProxy findUserByEmail(String email) {
		TypedQuery <UserEntity> query = em.createNamedQuery(UserEntity.FIND_USER_BY_EMAIL, UserEntity.class);
		query.setParameter("email",email);
		List <UserEntity> entity = query.getResultList();
		
		IUserProxy proxy;
		if( entity.size() == 1){
			proxy = new UserProxy(entity.get(0));
		} else {
			proxy=null;
		}
		
		return proxy;
	}

}

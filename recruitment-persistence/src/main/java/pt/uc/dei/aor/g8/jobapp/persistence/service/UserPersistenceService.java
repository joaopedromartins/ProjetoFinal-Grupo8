package pt.uc.dei.aor.g8.jobapp.persistence.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IUserPersistenceService;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.UserEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.IEntityAware;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.ScriptProxy;
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

	@Override
	public List<IUserProxy> findManagers() {
		TypedQuery <UserEntity> query = em.createNamedQuery(UserEntity.FIND_MANAGER, UserEntity.class);
		List <UserEntity> entity = query.getResultList();

		List <IUserProxy> proxy = new ArrayList<>();
		for (UserEntity u: entity){
			proxy.add(new UserProxy(u));
		}
		return proxy;
	}

	@Override
	public List<IUserProxy> findInterviewers() {
		TypedQuery <UserEntity> query = em.createNamedQuery(UserEntity.FIND_INTERVIEWER, UserEntity.class);
		List <UserEntity> entity = query.getResultList();

		List <IUserProxy> proxy = new ArrayList<>();
		for (UserEntity u: entity){
			proxy.add(new UserProxy(u));
		}
		return proxy;
	}

	@Override
	public IUserProxy editUser(IUserProxy currentUser) {
		UserEntity entity = getEntity(currentUser);
		entity = em.merge(entity);
		return new UserProxy(entity);
	}

	@Override
	public IUserProxy verifyPasswordOfUser(String username, String password) {
		TypedQuery <UserEntity> query = em.createNamedQuery(UserEntity.VERIFY_PASSWORD_OF_USER,UserEntity.class);
		query.setParameter("username",username);
		query.setParameter("password",password);
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
	public List<IUserProxy> allUser() {
		TypedQuery <UserEntity> query = em.createNamedQuery(UserEntity.ALL_USER, UserEntity.class);
		List <UserEntity> entity = query.getResultList();

		List <IUserProxy> proxy = new ArrayList<>();
		for (UserEntity u: entity){
			proxy.add(new UserProxy(u));
		}
		return proxy;
	}

	@Override
	public IUserProxy deleteUser(IUserProxy user) {
		UserEntity entity = getEntity(user);
		entity = em.merge(entity);
		em.remove(entity);
		return new UserProxy(entity);
	}

}

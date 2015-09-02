package pt.uc.dei.aor.g8.jobapp.persistence.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IUserPersistenceService;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.UserEntity;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.IEntityAware;
import pt.uc.dei.aor.g8.jobapp.persistence.proxy.UserProxy;

@Stateless
public class UserPersistenceService implements IUserPersistenceService {

	@PersistenceContext (unitName="recruitment")
	private EntityManager em;
	
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

}

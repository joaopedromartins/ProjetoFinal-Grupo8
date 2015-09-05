package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.business.enumeration.RoleType;
import pt.uc.dei.aor.g8.jobapp.business.model.IProxyFactory;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IUserPersistenceService;

@Stateless
public class UserFacade implements IUserFacade {

	@EJB
	private IProxyFactory factory;

	@EJB
	private IUserPersistenceService service;

	public UserFacade(){
		// TODO Auto-generated constructor stub
	}

	@Override
	public IUserProxy createUser(String username, String password, String lastname, String firstname, String email,
			List<RoleType> roles) {
		IUserProxy userUsername = service.findUserByUsername(username);
		IUserProxy userEmail = service.findUserByEmail(email);

		if ( userUsername == null && userEmail == null ){
			IUserProxy newUser = factory.user(username, password, lastname, firstname, email, roles);
			return service.createUser(newUser);
		} else if (userUsername == null && userEmail != null ){
			return null;

		} else if (userUsername != null && userEmail == null ){
			return null;
		}
		return null;
	}

	@Override
	public IUserProxy findUserByUsername(String username) {
		IUserProxy user = service.findUserByUsername(username);
		if(user != null){
			return user;
		}
		return null;
	}

}

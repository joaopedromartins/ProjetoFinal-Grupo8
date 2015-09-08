package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pt.uc.dei.aor.g8.business.enumeration.RoleType;
import pt.uc.dei.aor.g8.jobapp.business.model.IProxyFactory;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.business.persistence.IUserPersistenceService;
import pt.uc.dei.aor.g8.jobapp.business.util.AutoGeneratePasswor;
import pt.uc.dei.aor.g8.jobapp.business.util.EncryptPassword;

@Stateless
public class UserFacade implements IUserFacade {

	@EJB
	private IProxyFactory factory;

	@EJB
	private IUserPersistenceService service;
	@EJB
	private EncryptPassword passwordEncript;
	@EJB
	private AutoGeneratePasswor passwordGenrate;

	public UserFacade(){
		// TODO Auto-generated constructor stub
	}

	@Override
	public String createUserWithOutPassword(String username, String lastname, String firstname, String email,
			RoleType role) {
		
		IUserProxy userUsername = service.findUserByUsername(username);
		IUserProxy userEmail = service.findUserByEmail(email);

		if ( userUsername == null && userEmail == null ){
			String password = passwordGenrate.autoGeneratePassword();
			System.out.println( "Username, " + username + ", with password, " + password + ".");
			password = passwordEncript.encriptarPass(password);
			
			IUserProxy newUser = factory.user(username, password, lastname, firstname, email, rolesList(role));
			service.createUser(newUser);
			
			return "sucess";  
			
		} else if (userUsername == null && userEmail != null ){
			return "Email already exists!!";

		} else if (userUsername != null && userEmail == null ){
			return "Username already exists!!";
		} else if (userUsername != null && userEmail != null){
			return "Username and email already exists!!";
		}
		return null;
	}
	
	private List<RoleType> rolesList(RoleType role){
		List<RoleType> listroles = new ArrayList<>();
		if(role == RoleType.ADMINISTRATOR){
			listroles.add(RoleType.ADMINISTRATOR);
			listroles.add(RoleType.MANAGER);
			listroles.add(RoleType.INTERVIEWER);
		} else if (role == RoleType.MANAGER){
			listroles.add(RoleType.MANAGER);
			listroles.add(RoleType.INTERVIEWER);
		} else {
			listroles.add(RoleType.INTERVIEWER);
		}
		return listroles;
	}
	
	

	@Override
	public IUserProxy findUserByUsername(String username) {
		IUserProxy user = service.findUserByUsername(username);
		if(user != null){
			return user;
		}
		return null;
	}

	@Override
	public String createUser(String username, String password, String lastname, String firstname, String email,
			List<RoleType> roles) {
		IUserProxy userUsername = service.findUserByUsername(username);
		IUserProxy userEmail = service.findUserByEmail(email);

		if ( userUsername == null && userEmail == null ){
			IUserProxy newUser = factory.user(username, password, lastname, firstname, email, roles);
			service.createUser(newUser);
			return "User, " + username + ", registered successfully.";  
		} else if (userUsername == null && userEmail != null ){
			return "Email already exists!!";
		} else if (userUsername != null && userEmail == null ){
			return "Username already exists!!";
		} else if (userUsername != null && userEmail != null){
			return "Username and email already exists!!";
		}
		return null;
	}

}

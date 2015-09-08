package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.List;

import pt.uc.dei.aor.g8.business.enumeration.RoleType;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;

public interface IUserFacade {
	
	public String createUserWithOutPassword(String username, String lastname, String firstname, String email, RoleType roles);
	public String createUser(String username, String password, String lastname, String firstname, String email, List<RoleType> roles);
	public IUserProxy findUserByUsername(String username);

}

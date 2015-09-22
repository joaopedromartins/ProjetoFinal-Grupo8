package pt.uc.dei.aor.g8.jobapp.business.service;

import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.RoleType;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;

public interface IUserFacade {
	
	public String createUserWithOutPassword(String username, String lastname, String firstname, String email, RoleType roles);
	public String createUser(String username, String password, String lastname, String firstname, String email, List<RoleType> roles);
	public IUserProxy findUserByUsername(String username);
	public IUserProxy findUserByEmail(String email);
	public List <IUserProxy> findManagers();
	public List <IUserProxy> findInterviewers();
	public IUserProxy updateUser(IUserProxy currentUser);

}

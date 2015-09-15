package pt.uc.dei.aor.g8.jobapp.business.model;

import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.RoleType;

public interface IUserProxy {
	
	public List<RoleType> getRoles();

	public String getUsername();
	public void setUsername(String username);

	
	public void setPassword(String password);

	public String getLastname();
	
	public void setLastname(String lastname);

	public String getFirstname();
	public void setFirstname(String firstname);

	public String getEmail();
	public void setEmail(String email);

	public String getFullName ();
}

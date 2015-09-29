package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import java.util.List;

import pt.uc.dei.aor.g8.jobapp.business.enumeration.RoleType;
import pt.uc.dei.aor.g8.jobapp.business.model.IUserProxy;
import pt.uc.dei.aor.g8.jobapp.persistence.entities.UserEntity;

public class UserProxy implements IUserProxy, IEntityAware<UserEntity> {
	
	private UserEntity entity;

	
	public UserProxy(){
		this(null);
	}
	
	public UserProxy(String login, String password, String lastname, String firstname, String email,List<RoleType> roles) {
		this.entity= new UserEntity(login,password,lastname,firstname,email,roles);
	}
	
	public UserProxy(UserEntity user) {
		if(user == null){
			this.entity = new UserEntity();
		} else {
			this.entity = user;
		}
	}


	@Override
	public UserEntity getEntity() {
		return entity;
	}


	
	@Override
	public String toString(){
		return entity.toString();
	}

	@Override
	public List<RoleType> getRoles() {	
		return entity.getRoles();
	}

	@Override
	public void setRoles(List<RoleType> roles) {
		entity.setRoles(roles);
	}
	
	@Override
	public String getUsername() {
		return entity.getUsername();
	}

	@Override
	public void setUsername(String username) {
		entity.setUsername(username);
		
	}

	@Override
	public void setPassword(String password) {
		entity.setPassword(password);	
	}

	@Override
	public String getLastname() {
		return entity.getLastname();
	}

	@Override
	public void setLastname(String lastname) {
		entity.setLastname(lastname);
	}

	@Override
	public String getFirstname() {
		return entity.getFirstname();
	}

	@Override
	public void setFirstname(String firstname) {
		entity.setFirstname(firstname);
	}

	@Override
	public String getEmail() {
		return entity.getEmail();
	}

	@Override
	public void setEmail(String email) {
		entity.setEmail(email);
	}

	@Override
	public String getFullName() {
		String fullName = getFirstname()+ " " + getLastname();
		return fullName;
	}
	
	
	@Override
	public int hashCode() {
		return entity.hashCode();
	}


	@Override
	public boolean equals(Object obj) {	
		return entity.equals(userConverterProxyToEntity((UserProxy)obj));
	}
	
	@SuppressWarnings( "unchecked" )
	private UserEntity userConverterProxyToEntity ( IUserProxy proxy){
		UserEntity entityUser = ((IEntityAware<UserEntity>)proxy).getEntity();
		return entityUser;
	}

	
	
	

}

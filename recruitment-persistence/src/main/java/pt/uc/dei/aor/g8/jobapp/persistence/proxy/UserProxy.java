package pt.uc.dei.aor.g8.jobapp.persistence.proxy;

import java.util.List;

import pt.uc.dei.aor.g8.business.enumeration.RoleType;
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
	public int hashCode() {
		return entity.hashCode();
	}


	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		return entity.equals(((IEntityAware<UserEntity>)obj).getEntity());
	}
	
	@Override
	public String toString(){
		return entity.toString();
	}
	

}

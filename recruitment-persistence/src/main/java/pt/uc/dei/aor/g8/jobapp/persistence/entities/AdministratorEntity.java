package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
//@Table(name = "Administrator")
//@PrimaryKeyJoinColumn(name = "administrator_id", referencedColumnName = "user_id")
public class AdministratorEntity extends UserEntity implements Serializable  {
	
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdministratorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdministratorEntity(String login, String password, String lastname, String firstname, String email) {
		super(login, password, lastname, firstname, email);
		roles=new ArrayList<RoleType>();
		roles.add(RoleType.ADMINISTRATOR);
	}

	

}

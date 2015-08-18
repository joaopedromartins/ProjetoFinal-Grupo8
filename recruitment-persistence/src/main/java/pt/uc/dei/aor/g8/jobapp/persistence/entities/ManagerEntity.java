package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("M")
@Table(name = "Manager")
//@PrimaryKeyJoinColumn(name = "manager_id", referencedColumnName = "user_id")
public class ManagerEntity extends UserEntity  {
	
	@OneToMany (mappedBy="userPosition")
	private List<PositionEntity> position;

	public ManagerEntity() {
		// TODO Auto-generated constructor stub
	}
	

	public ManagerEntity(String login, String password, String lastname, String firstname, String email) {
		super(login, password, lastname, firstname, email);
		roles=new ArrayList<RoleType>();
		roles.add(RoleType.MANAGER);
	}

}

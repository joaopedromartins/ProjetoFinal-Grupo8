package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Manager")
@PrimaryKeyJoinColumn(name = "manager_id", referencedColumnName = "user_id")
public class ManagerEntity extends UserEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ManagerEntity() {
		// TODO Auto-generated constructor stub
	}
	

	public ManagerEntity(String login, String password, String lastname, String firstname, String email) {
		super(login, password, lastname, firstname, email);
		this.role=RoleType.MANAGER;
	}

}

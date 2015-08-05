package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "worker")
@PrimaryKeyJoinColumn(name = "id")
public class WorkerEntity extends UserEntity {
	private static final long serialVersionUID = 1L;
	
	// TODO passar a Lista de Roles
	@Column
	private RoleType role;
	

	public WorkerEntity() {
		super();
	}
	
	public WorkerEntity(String login, String password, String lastname, String firstname, String email, RoleType role) {
		super(login, password, lastname, firstname, email);
		this.role = role;
	}

}

package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: WorkerRoleEntity
 *
 */
/*@Entity
@Table(name = "Role")*/
public class RoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	/*
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "role_name", nullable = false, unique = false)
	private RoleType role;
	
	@ManyToOne
	//@JoinColumn(name = "id", nullable = false, unique = false)
	private UserEntity user;
	
	
	//Constructors
	public RoleEntity() {
		super();
	}
	
	public RoleEntity(RoleType role, UserEntity user) {
		super();
		this.user = user;
		this.role = role;
	}

	//Getters and Setters
	public RoleType getRole() {
		return role;
	}
	public void setRole(RoleType role) {
		this.role = role;
	}

	
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}
   */
	
	
}

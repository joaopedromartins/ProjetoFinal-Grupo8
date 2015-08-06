package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Administrator")
//@PrimaryKeyJoinColumn(name = "user_id")
public class AdministratorEntity extends UserEntity {
	private static final long serialVersionUID = 1L;

	public AdministratorEntity() {
		super();
	}

}

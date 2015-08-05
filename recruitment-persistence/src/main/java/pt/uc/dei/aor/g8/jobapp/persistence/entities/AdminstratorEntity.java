package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "WORKER")
@PrimaryKeyJoinColumn(name = "user_id")
public class AdminstratorEntity extends UserEntity {
	private static final long serialVersionUID = 1L;

	public AdminstratorEntity() {
		super();
	}

}

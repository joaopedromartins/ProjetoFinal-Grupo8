package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name = "Adminstrator")
public class AdminstratorEntity extends UserEntity {

	public AdminstratorEntity() {
		super();
	}

}

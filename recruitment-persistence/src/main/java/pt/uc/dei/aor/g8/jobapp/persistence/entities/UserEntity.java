package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class UserEntity {

	@Id
	private int id;
	
	public UserEntity() {
		
	}

}

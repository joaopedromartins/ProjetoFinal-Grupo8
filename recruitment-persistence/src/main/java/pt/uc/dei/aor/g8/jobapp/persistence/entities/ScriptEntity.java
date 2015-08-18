package pt.uc.dei.aor.g8.jobapp.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Script")
public class ScriptEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public ScriptEntity() {
		// TODO Auto-generated constructor stub
	}

}

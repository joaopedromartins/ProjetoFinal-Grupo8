package pt.uc.dei.aor.g8.jobapp.persistence.entities;

public enum RoleType {
	ADMINISTRATOR ("Administrador"),
	MANAGER ("Gestor"),
	RECRUITER ("Entrevistador");
	
	private String description;
	
	RoleType (String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}

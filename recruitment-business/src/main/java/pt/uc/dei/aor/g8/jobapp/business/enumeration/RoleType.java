package pt.uc.dei.aor.g8.jobapp.business.enumeration;

public enum RoleType {
	ADMINISTRATOR ("Administrator"),
	MANAGER ("Manager"),
	INTERVIEWER ("Interviewer");
	
	private String description;
	
	private RoleType (String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}

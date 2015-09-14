package pt.uc.dei.aor.g8.jobapp.business.enumeration;

public enum Status {
	OPEN ("Open"),
	CLOSE ("Close"),
	ONHOLD ("On Hold");
	
	private String description;

	private Status (String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}

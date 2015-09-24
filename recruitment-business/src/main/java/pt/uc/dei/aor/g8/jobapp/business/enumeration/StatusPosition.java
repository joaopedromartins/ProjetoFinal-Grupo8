package pt.uc.dei.aor.g8.jobapp.business.enumeration;

public enum StatusPosition {
	OPEN ("Open"),
	CLOSE ("Close"),
	ONHOLD ("On Hold");
	
	private String description;

	private StatusPosition (String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}

package pt.uc.dei.aor.g8.jobapp.business.enumeration;

public enum Localization {
	COIMBRA ("Coimbra"),
	LISBON ("Lisbon"),
	OPORTO ("Oporto") ,
	CLIENT ("Client");
	
	private String description;

	private Localization (String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}

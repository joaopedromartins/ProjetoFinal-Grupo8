package pt.uc.dei.aor.g8.business.enumeration;

public enum TechnicalArea {
	
	SSPA ("SSPA"),
	NETDEVELOPMENT (".Net Development"),
	JAVADEVELOPMENT ("Java Development"),
	SAFETYCRITICAL ("Safety Critical"),
	PROJECTMANAGEMENT ("Project Management"),
	INTEGRATION ("Integration");
	
	private String description;

	private TechnicalArea (String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}

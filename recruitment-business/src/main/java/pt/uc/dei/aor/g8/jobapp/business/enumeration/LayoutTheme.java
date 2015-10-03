package pt.uc.dei.aor.g8.jobapp.business.enumeration;

public enum LayoutTheme {
	afternoon ("afternoon", "Afternoon"), 
	afterwork ("afterwork", "Afterwork"), 
	aristo ("aristo", "Aristo"), 
	bluesky ("bluesky", "Bluesky"), 
	bootstrap ("bootstrap", "Bootstrap"), 
	casablanca ("casablanca", "Casablanca"), 
	cupertino ("cupertino", "Cupertino"), 
	delta ("delta", "Delta"), 
	excite_bike ("excite-bike", "Excite-Bike"), 
	flick ("flick", "Flick"), 
	glass_x ("glass-x", "Glass-X"), 
	le_frog ("le-frog", "Le-Frog"), 
	overcast ("overcast", "Overcast"), 
	pepper_grinder ("pepper-grinder", "Pepper-Grinder"), 
	sam ("sam", "Sam"), 
	smoothness ("smoothness", "Smoothness"), 
	south_street ("south-street", "South-Street");

	private String name;
	private String description;

	private LayoutTheme(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

}

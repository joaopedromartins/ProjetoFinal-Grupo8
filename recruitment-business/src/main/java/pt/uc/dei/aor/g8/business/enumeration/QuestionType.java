package pt.uc.dei.aor.g8.business.enumeration;

public enum QuestionType {
	TEXT ("Text"),
	PARAGRAPH ("Paragragh Text"),
	MULTIPLECHOICE ("Multiple Choice"),
	CHECKBOXES ("Check boxes"),
	CHOOSEFROMLIST ("Choose from a list"),
	SCALE ("Scale"),
	DATE ("Date"),
	TIME ("Time"),
	NUMBER ("Number"),
	CURRENCY ("Currency");
	
	private String description;

	private QuestionType (String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}

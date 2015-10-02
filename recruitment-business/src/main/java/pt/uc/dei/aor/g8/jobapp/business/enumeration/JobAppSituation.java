package pt.uc.dei.aor.g8.jobapp.business.enumeration;

public enum JobAppSituation {
	DELETE_BY_CANDIDATE ("Deleted by Candidate"),
	SPONTANEOUS ("Spontaneous"),
	SUBMITTED ("Submitted"),
	INTERVIEWING ("Interviewing"),
	OFFER_PROCESS ("Negotiation"),
	REJECTED ("Rejected"),
	HIRED ("Hired");

	private String description;

	private JobAppSituation (String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}


package pt.uc.dei.aor.g8.jobapp.business.enumeration;

public enum ProposalStatus {
	SUBMITTED ("Submitted"),
	REJECTED ("Rejected"),
	ACCEPTED ("Accepted");

	private String description;

	private ProposalStatus (String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}

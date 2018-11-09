package domain;

public enum Role {
	BIB("bibliothekaris"), LID("lid"), ADMIN("admin");

	private String description;

	Role(String description) {
		this.description = description;
	}
	
	Role() {
		
	}

	public String getDescription() {
		return description;
	}
}

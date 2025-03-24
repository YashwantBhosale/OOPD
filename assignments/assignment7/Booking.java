public class Booking {
	private User user; // user associated with the booking
	private String venueType; // booking for which venue
	private String slot;
	private String status;

	Booking(User user, String venueType, String slot, String status) {
		this.user = user;
		this.venueType = venueType;
		this.slot = slot;
		this.status = status;
	}

	public User getUser() {
		return this.user;
	}

	public String getVenueType() {
		return this.venueType;
	}

	public String getSlot() {
		return this.slot;
	}

	public String getStatus() {
		return this.status;
	}

	public void getDetails() {
		System.out.println("==========================================================");
		System.out.println("Name: " + this.user.getName());
		System.out.println("Venue Type: " + this.venueType);
		System.out.println("Slot: " + this.slot);
		System.out.println("Status: " + this.status);
		System.out.println("==========================================================");
	}
}

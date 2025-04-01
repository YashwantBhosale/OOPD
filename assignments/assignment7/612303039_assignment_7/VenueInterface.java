public interface VenueInterface {
	String getDetails();
	
	void viewSlots();
	boolean isAvailable(String slot);
	boolean book(String slot, User user);
	void cancelBooking(String slot);

	void joinQueue(String slot, User user);
	void viewQueue();
}

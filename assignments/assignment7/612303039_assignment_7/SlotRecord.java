import java.util.Vector;

public class SlotRecord {
	private Slot slot;
	private User bookedUser;
	private Vector<User> waitingQueue;
	
	public SlotRecord(Slot slot){
		this.slot = slot;
		this.bookedUser = null;
		this.waitingQueue = new Vector<>();
	}

	public Slot getSlot() {
		return this.slot;
	}

	public User getBookedUser() {
		return this.bookedUser;
	}

	public void setBookedUser(User user) {
		this.bookedUser = user;
	}

	public void addUserToQueue(User user) {
		this.waitingQueue.add(user);
	}
	
	public Vector<User> getWaitingQueue() {
		return waitingQueue;
	}
}

import java.util.Vector;

public abstract class Venue implements VenueInterface {
    protected String venueName;
    protected int capacity;
    protected Vector<SlotRecord> slotRecords;

    Venue(String venueName, int capacity, Vector<Slot> slots) {
        this.venueName = venueName;
        this.capacity = capacity;
        this.slotRecords = new Vector<>();
        
        for(int i = 0; i < slots.size(); i++) {
            slotRecords.add(new SlotRecord(slots.get(i)));
        }
    }

    @Override
    public String getDetails() {
        return "Venue: " + this.venueName + ", capacity: " + this.capacity + "\n";
    }
    
    @Override
    public void viewSlots() {
        System.out.println("Slots for: " + this.venueName + "-");
        for (int i = 0; i < this.slotRecords.size(); i++) {
            System.out.print("slot: " + this.slotRecords.get(i).getSlot().getName() + " - ");
            
            // Corrected logic here
            if (slotRecords.get(i).getBookedUser() == null) {
                System.out.println("Available");
            } else {
                System.out.println("Booked by " + slotRecords.get(i).getBookedUser().getName());
            }
        }
    }

    private SlotRecord searchSlotRecord(String slotLabel) {
        for (int i = 0; i < slotRecords.size(); i++) {
            if (slotRecords.get(i).getSlot().getName().equals(slotLabel)){
                return slotRecords.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean isAvailable(String slotLabel) {
        SlotRecord record = searchSlotRecord(slotLabel);

        if(record == null) {
            System.err.println("Invalid slot!");
            return false;
        }

        return record.getBookedUser() == null;
    }

    @Override
    public boolean book(String slotLabel, User user){
        SlotRecord record = searchSlotRecord(slotLabel);
        
        if(record == null) {
            System.err.println("Invalid slot!");
            return false;
        }

        if (record.getBookedUser() == null) {
            record.setBookedUser(user);
            System.out.println("Slot " + record.getSlot().getName() + " booked successfully for " + user.getName() + " in " + venueName);
            return true;
        } else {
            System.out.println("Slot " + record.getSlot().getName() + " is already booked.");
            return false;
        }
    }

    @Override
    public void cancelBooking(String slotLabel) {
        SlotRecord record = searchSlotRecord(slotLabel);
        if (record == null) {
            System.out.println("Slot " + slotLabel + " is not valid for " + venueName);
            return;
        }
    
        if (record.getBookedUser() != null) {
            User canceledUser = record.getBookedUser();
            record.setBookedUser(null);
            System.out.println("Booking for slot " + record.getSlot().getName() + " cancelled for user " + canceledUser.getName());
        
            if (!record.getWaitingQueue().isEmpty()) {
                User nextUser = record.getWaitingQueue().remove(0); // popped next user from the queue
                record.setBookedUser(nextUser);
                System.out.println("Slot " + record.getSlot().getName() + " automatically booked for waiting user " + nextUser.getName());
            }
        } else {
            System.out.println("No booking found for slot " + record.getSlot().getName());
        }
    }

    @Override
    public void joinQueue(String slotLabel, User user) {
        SlotRecord record = searchSlotRecord(slotLabel);
        if (record == null) {
            System.out.println("Slot " + slotLabel + " is not valid for " + venueName);
            return;
        }
        if (record.getWaitingQueue().contains(user)) {
            System.out.println(user.getName() + " is already in the waiting queue for slot " 
                                + record.getSlot().getName());
        } else {
            record.getWaitingQueue().add(user);
            System.out.println(user.getName() + " joined the waiting queue for slot " 
                                + record.getSlot().getName());
        }
    }
    
    @Override
    public void viewQueue() {
        System.out.println("Waiting queues for " + venueName + ":");
        
        for (int i = 0; i < slotRecords.size(); i++) {
            System.out.print("Slot " + slotRecords.get(i).getSlot().getName() + " queue: ");
            
            if (slotRecords.get(i).getWaitingQueue().isEmpty()) {
                System.out.println("Empty");
            } else {
                Vector<User> queue = slotRecords.get(i).getWaitingQueue();
                for (int j= 0; j < queue.size(); j++){
                    System.out.print(queue.get(j).getName() + " ");
                }
                System.out.println();
            }
        }
    }
}
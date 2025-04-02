import java.util.Vector;

public class MainAuditorium extends Venue {
    public MainAuditorium(int capacity, Vector<Slot> slots) {
        super("Main Auditorium", capacity, slots);
    }

    @Override
    public getDetails() {
        System.out.println("This is main auditorium! If required capacity is less than 100 then please consider using Mini Auditorium");
        return "Venue: " + this.venueName + ", capacity: " + this.capacity + "\n";
    }

//     @Override joinQueue(String slotLabel, User user) {
//         if(venueName == "Main Auditorium") {
//             System.out.println("Queue is not available for Main Audi!");
//             return;
//         }else {

//         }
//     }
}
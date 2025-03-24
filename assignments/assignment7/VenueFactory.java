import java.util.Vector;

public class VenueFactory {
    public static Venue createVenue(String venueType, int capacity, Vector<Slot> slots) {
        switch (venueType) {
            case "Main Auditorium":
                return new MainAuditorium(capacity, slots);
            case "Cognizant Lab":
                return new CognizantLab(capacity, slots);
            case "Seminar Hall":
                return new SeminarHall(capacity, slots);
            case "FOSS Lab":
                return new FossLab(capacity, slots);
            case "Academic Complex":
                return new AcademicComplex(capacity, slots);
            default:
                System.out.println("Invalid venue type");
                return null;
        }
    }
}
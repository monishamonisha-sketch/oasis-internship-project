import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CancellationForm {
    // Simulating a simple in-memory database of reservations by PNR number
    private static Map<String, String> reservations = new HashMap<>();

    // This method simulates adding a reservation with a PNR number
    public static void addReservation(String pnr, String reservationDetails) {
        reservations.put(pnr, reservationDetails);
    }

    public static void cancelReservation(String pnr) {
        if (reservations.containsKey(pnr)) {
            String reservationDetails = reservations.get(pnr);
            System.out.println("Reservation found: " + reservationDetails);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Are you sure you want to cancel this reservation? (yes/no): ");
            String confirmation = scanner.nextLine();

            if ("yes".equalsIgnoreCase(confirmation)) {
                reservations.remove(pnr);
                System.out.println("Reservation cancelled successfully.");
            } else {
                System.out.println("Cancellation aborted.");
            }

            scanner.close();
        } else {
            System.out.println("No reservation found with the given PNR number.");
        }
    }

    public static void main(String[] args) {
        // Adding some dummy reservations for testing
        addReservation("PNR123", "Reservation for John Doe, Train: Express Train, Date: 2025-01-20, From: Delhi, To: Mumbai");
        addReservation("PNR124", "Reservation for Jane Doe, Train: Fast Train, Date: 2025-01-22, From: Mumbai, To: Kolkata");
        // Add reservation with PNR 4562
        addReservation("4562", "Reservation for Alex Smith, Train: Super Express, Date: 2025-01-25, From: Chennai, To: Bangalore");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your PNR number: ");
        String pnr = scanner.nextLine();

        cancelReservation(pnr);

        scanner.close();
    }
}

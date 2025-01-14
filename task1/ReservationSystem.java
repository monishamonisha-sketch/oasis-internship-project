import java.util.Scanner;

public class ReservationSystem {
    // In-memory storage for reservations (In a real app, use a database)
    private static class Reservation {
        String name;
        String trainNumber;
        String trainName;
        String classType;
        String journeyDate;
        String fromPlace;
        String toPlace;

        public Reservation(String name, String trainNumber, String trainName, String classType, String journeyDate, String fromPlace, String toPlace) {
            this.name = name;
            this.trainNumber = trainNumber;
            this.trainName = trainName;
            this.classType = classType;
            this.journeyDate = journeyDate;
            this.fromPlace = fromPlace;
            this.toPlace = toPlace;
        }

        @Override
        public String toString() {
            return "Reservation [Name=" + name + ", Train=" + trainName + " (" + trainNumber + "), Class=" + classType + ", Date=" + journeyDate + ", From=" + fromPlace + " To=" + toPlace + "]";
        }
    }

    private static void addReservation(String name, String trainNumber, String trainName, String classType, String journeyDate, String fromPlace, String toPlace) {
        Reservation reservation = new Reservation(name, trainNumber, trainName, classType, journeyDate, fromPlace, toPlace);
        // Save reservation to the system (in memory for this example)
        System.out.println("Reservation successful: " + reservation);
    }

    public static void startReservation() {
        Scanner scanner = new Scanner(System.in);

        // Simulating available trains (In a real app, this would be dynamic data)
        String[] availableTrains = {"12345 - Express Train", "67890 - Fast Train"};

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Available trains:");
        for (String train : availableTrains) {
            System.out.println(train);
        }

        System.out.print("Enter train number: ");
        String trainNumber = scanner.nextLine();
        String trainName = trainNumber.equals("12345") ? "Express Train" : "Fast Train"; // Dummy logic

        System.out.print("Enter class type (e.g., Sleeper, AC): ");
        String classType = scanner.nextLine();

        System.out.print("Enter date of journey (yyyy-mm-dd): ");
        String journeyDate = scanner.nextLine();

        System.out.print("Enter source (from): ");
        String fromPlace = scanner.nextLine();

        System.out.print("Enter destination (to): ");
        String toPlace = scanner.nextLine();

        addReservation(name, trainNumber, trainName, classType, journeyDate, fromPlace, toPlace);

        // Close scanner after use
        scanner.close();
    }

    public static boolean containsKey(String pnr) {
       
        throw new UnsupportedOperationException("Unimplemented method 'containsKey'");
    }
}

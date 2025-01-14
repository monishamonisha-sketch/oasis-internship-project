import java.util.Scanner;

public class LoginForm {
    // Simulated user data (in a real-world app, you'd use a database)
    private static String validUsername = "user1";
    private static String validPassword = "password123";

    public static boolean authenticate(String username, String password) {
        return validUsername.equals(username) && validPassword.equals(password);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authenticate(username, password)) {
            System.out.println("Login successful!");
            // Proceed to the reservation system
            ReservationSystem.startReservation();
        } else {
            System.out.println("Invalid login credentials.");
        }

        scanner.close();
    }
}

import java.util.Scanner;

public class booking{
    private static boolean[][] seats = new boolean[5][5]; // 5x5 matrix to represent seats

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                displayMenu();
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        showSeats();
                        break;
                    case 2:
                        bookSeat();
                        break;
                    case 3:
                        cancelBooking();
                        break;
                    case 4:
                        System.out.println("Thank you for using the Movie Booking System. Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMovie Booking System Menu:");
        System.out.println("1. Show available seats");
        System.out.println("2. Book a seat");
        System.out.println("3. Cancel booking");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void showSeats() {
        System.out.println("\nAvailable Seats:");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                char status = seats[i][j] ? 'X' : 'O';
                System.out.print(status + " ");
            }
            System.out.println();
        }
    }

    private static void bookSeat() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter row number (1-5): ");
        int row = scanner.nextInt() - 1;

        System.out.print("Enter column number (1-5): ");
        int col = scanner.nextInt() - 1;

        if (isValidSeat(row, col) && !seats[row][col]) {
            seats[row][col] = true;
            System.out.println("Seat booked successfully!");
        } else {
            System.out.println("Invalid seat or seat already booked. Please try again.");
        }
    }

    private static void cancelBooking() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter row number (1-5): ");
        int row = scanner.nextInt() - 1;

        System.out.print("Enter column number (1-5): ");
        int col = scanner.nextInt() - 1;

        if (isValidSeat(row, col) && seats[row][col]) {
            seats[row][col] = false;
            System.out.println("Booking canceled successfully.");
        } else {
            System.out.println("Invalid seat or seat not booked. Please try again.");
        }
    }

    private static boolean isValidSeat(int row, int col) {
        return row >= 0 && row < seats.length && col >= 0 && col < seats[row].length;
    }
}

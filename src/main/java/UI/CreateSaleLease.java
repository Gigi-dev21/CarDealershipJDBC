package UI;

import java.util.Scanner;

public class CreateSaleLease {
    private final Scanner scanner = new Scanner(System.in);
    public void displayCreateSaleLease(){
        while (true) {
            System.out.println("\n===  Create Sale/Lease Contracts Menu ===\n");
            System.out.println("1. Create Sale");
            System.out.println("2. Lease Contracts");
            System.out.println("0. Back");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":

                    break;
                case "2":

                    break;
                case "0":
                    System.out.println("Exiting search menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

}

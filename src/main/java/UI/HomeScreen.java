package UI;

import java.util.Scanner;;

public class HomeScreen {
    private final Scanner scanner = new Scanner(System.in);

    public void displayHomeScreen() {
        while (true) {
            System.out.println("\n=== Car Dealership Menu ===\n");
            System.out.println("1. View/Search Vehicles");
            System.out.println("2. Add/Remove Vehicles");
            System.out.println("3. Create Sale/Lease Contracts");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    ViewSearch viewSearch = new ViewSearch();
                    viewSearch.displayViewSearch();
                    break;
                case "2":
                    AddRemove addRemove = new AddRemove();
                    addRemove.displayAddRemove();
                    break;
                case "3":
                    CreateSaleLease createSaleLease = new CreateSaleLease();
                    createSaleLease.displayCreateSaleLease();
                    break;
                case "0":
                    System.out.println("Exiting... Goodbye!");
                    return; // Exit the method
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

}

package UI;

import UI.methods.ViewSearchVehiclesMethods;

import java.util.Scanner;

public class ViewSearch {
    private final Scanner scanner = new Scanner(System.in);
    ViewSearchVehiclesMethods viewSearchVehiclesMethods = new ViewSearchVehiclesMethods();

    public void displayViewSearch() {
        while (true) {
            System.out.println("\n=== View/Search Vehicles Menu ===");
            System.out.println("\nSearch Vehicles By:");
            System.out.println("  1. By price range");
            System.out.println("  2. By make/model");
            System.out.println("  3. By year range");
            System.out.println("  4. By color");
            System.out.println("  5. By mileage range");
            System.out.println("  6. By type");
            System.out.println("  7. View All");
            System.out.println("  0. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    viewSearchVehiclesMethods.byPriceRange();
                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":
                    viewSearchVehiclesMethods.displayAllVehicles();
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


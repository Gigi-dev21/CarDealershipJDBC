package UI.methods;

import Classes.Vehicle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewSearchVehiclesMethods {

    public List<Vehicle> searchVehicles(String sqlQuery, Object... params) {
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = MyDataSource.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {

             //Set all parameters dynamically//
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Vehicle vehicle = new Vehicle();
                    vehicle.setVin(rs.getString("VIN"));
                    vehicle.setMake(rs.getString("make"));
                    vehicle.setModel(rs.getString("model"));
                    vehicle.setYear(rs.getInt("year"));
                    vehicle.setColor(rs.getString("color"));
                    vehicle.setSold(rs.getInt("sold"));
                    vehicle.setPrice(rs.getDouble("price"));
                    vehicles.add(vehicle);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicles;
    }

    public void displayAllVehicles() {
        List<Vehicle> vehicles = searchVehicles(SqlQueries.SELECT_ALL_VEHICLES);
        displayVehicles(vehicles, "All Vehicles");
    }

    public void byPriceRange() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Search Vehicles by Price Range ===");

        System.out.print("Enter minimum price: ");
        double minPrice = scanner.nextDouble();

        System.out.print("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();

        if (minPrice > maxPrice) {
            System.out.println("Minimum price cannot be greater than maximum price. Please try again.");
            return;
        }

        System.out.println("Searching vehicles between $" + minPrice + " and $" + maxPrice + "...");

        List<Vehicle> vehicles = searchVehicles(SqlQueries.SEARCH_BY_PRICE_RANGE, minPrice, maxPrice);
        displayVehicles(vehicles, "Vehicles in Price Range $" + minPrice + " - $" + maxPrice);
    }

    public void byMakeModel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Search Vehicles by Make and Model ===");

        System.out.print("Enter make: ");
        String make = scanner.nextLine();  // Use String, not double

        System.out.print("Enter model: ");
        String model = scanner.nextLine(); // Use String, not double

        List<Vehicle> vehicles = searchVehicles(SqlQueries.SEARCH_BY_MAKE_MODEL, make, model);

        displayVehicles(vehicles, "\nVehicles with Make: " + make + " and Model: " + model);
    }

    public void byYearRange() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Search Vehicles by Year Range ===");

        System.out.print("Enter minimum year: ");
        int minYear = scanner.nextInt();

        System.out.print("Enter maximum year: ");
        int maxYear = scanner.nextInt();

        if (minYear > maxYear) {
            System.out.println("Minimum year cannot be greater than maximum year. Please try again.");
            return;
        }

        System.out.println("Searching vehicles between years " + minYear + " and " + maxYear + "...");

        List<Vehicle> vehicles = searchVehicles(SqlQueries.SEARCH_BY_YEAR_RANGE, minYear, maxYear);

        displayVehicles(vehicles, "Vehicles manufactured between " + minYear + " and " + maxYear);
    }

    public void byColor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Search Vehicles by Color ===");

        System.out.print("Enter color: ");
        String color = scanner.nextLine().trim();

        if (color.isEmpty()) {
            System.out.println("Color cannot be empty. Please try again.");
            return;
        }

        List<Vehicle> vehicles = searchVehicles(SqlQueries.SEARCH_BY_COLOR, color);

        displayVehicles(vehicles, "Vehicles with Color: " + color);
    }




    // Helper method to display list of vehicles with a title
    private void displayVehicles(List<Vehicle> vehicles, String title) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }

        System.out.println("=== " + title + " ===");
        printTableHeader();
        printTableSeparator();

        for (Vehicle vehicle : vehicles) {
            System.out.printf("%-18s | %-4d | %-10s | %-9s | %-8s | %-4d | $%7.2f%n",
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getColor(),
                    vehicle.getSold(),
                    vehicle.getPrice());
        }
    }

    private void printTableHeader() {
        System.out.printf("%-18s | %-4s | %-10s | %-9s | %-8s | %-4s | %8s%n",
                "VIN", "Year", "Make", "Model", "Color", "Sold", "Price");
    }

    private void printTableSeparator() {
        System.out.println("-------------------------------------------------------------------------------");
    }
}

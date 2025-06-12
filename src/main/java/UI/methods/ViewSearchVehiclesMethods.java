package UI.methods;

import Classes.Vehicle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewSearchVehiclesMethods {

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = MyDataSource.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(SqlQueries.SELECT_ALL_VEHICLES);
             ResultSet rs = stmt.executeQuery()) {

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

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicles;
    }

    public void displayAllVehicles() {
        List<Vehicle> vehicles = getAllVehicles();

        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            System.out.println("=== All Vehicles ===");


            System.out.printf("%-18s | %-4s | %-10s | %-9s | %-8s | %-4s | %8s%n",
                    "VIN", "Year", "Make", "Model", "Color", "Sold", "Price");
            System.out.println("-------------------------------------------------------------------------------");


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
    }
}

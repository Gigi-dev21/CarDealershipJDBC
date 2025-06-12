package UI.methods;

import Classes.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddremoveMethods {
    private Vehicle getVehicleFromUser(Scanner scanner) {
        System.out.print("Enter VIN: ");
        String vin = scanner.nextLine();

        System.out.print("Enter Make: ");
        String make = scanner.nextLine();

        System.out.print("Enter Model: ");
        String model = scanner.nextLine();

        System.out.print("Enter Year: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Color: ");
        String color = scanner.nextLine();

        System.out.print("Is Sold? (0 = no, 1 = yes): ");
        int sold = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Price: ");
        double price = Double.parseDouble(scanner.nextLine());


        return new Vehicle(vin, year, make, model, color, sold, price);
    }

    public void addVehicle( ) {
        Scanner scanner = new Scanner(System.in);
        Vehicle vehicle = getVehicleFromUser(scanner);
        try (Connection conn = MyDataSource.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(SqlQueries.INSERT_VEHICLE)) {

            stmt.setString(1, vehicle.getVin());
            stmt.setString(2, vehicle.getMake());
            stmt.setString(3, vehicle.getModel());
            stmt.setInt(4, vehicle.getYear());
            stmt.setString(5, vehicle.getColor());
            stmt.setInt(6, vehicle.getSold());
            stmt.setDouble(7, vehicle.getPrice());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new vehicle was inserted successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

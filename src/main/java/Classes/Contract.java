package Classes;

public abstract class Contract {
    private String contractDate;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicleSold;

    public Contract(String contractDate, String customerName, String customerEmail, Vehicle vehicleSold) {
        this.contractDate = contractDate;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }
    // Getters and setters
    public String getDate() { return contractDate; }
    public String getCustomerName() { return customerName; }
    public String getCustomerEmail() { return customerEmail; }
    public Vehicle getVehicleSold() { return vehicleSold; }

    // Abstract methods for price calculations
    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();

    public double getVehiclePrice() {
        return vehicleSold.getPrice();
    }

}

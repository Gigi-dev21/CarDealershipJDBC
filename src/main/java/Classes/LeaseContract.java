package Classes;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String contractDate, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(contractDate, customerName, customerEmail, vehicleSold);
        double price = getVehiclePrice();
        this.expectedEndingValue = price * 0.5;
        this.leaseFee = price * 0.07;
    }

    @Override
    public double getTotalPrice() {
        return leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}

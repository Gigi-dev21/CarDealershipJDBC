package Classes;

public class SalesContract extends Contract {
    private double vehiclePrice;
    private boolean finance;

    private final double SALES_TAX_RATE = 0.05;
    private final double RECORDING_FEE = 100.0;
    private final double PROCESSING_FEE_LOW = 295.0;
    private final double PROCESSING_FEE_HIGH = 495.0;


    public SalesContract(String contractDate, String customerName, String customerEmail,
                         Vehicle vehicleSold) {
        super(contractDate, customerName, customerEmail, vehicleSold);
        this.vehiclePrice = vehiclePrice;
        this.finance = finance;
    }


    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}

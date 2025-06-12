package Classes;

public class Vehicle {
    private String  vin;
    private int year;
    private String make;
    private String model;
    private String color;
    private int sold;
    private double price;

    public Vehicle(String vin, int year, String make, String model, String color, int sold, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.color = color;
        this.sold = sold;
        this.price = price;
    }

    public Vehicle() {}

    @Override
    public String toString() {
        return vin + " | " + year + " | " + make + " | " + model + " | " +
                color + " | Sold: " + sold + " | $" + price;
    }

    // Getters
    public String getVin() { return vin; }
    public int getYear() { return year; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public String getColor() { return color; }
    public int getSold() { return sold; }
    public double getPrice() { return price; }

    // Setters
    public void setVin(String vin) { this.vin = vin; }
    public void setYear(int year) { this.year = year; }
    public void setMake(String make) { this.make = make; }
    public void setModel(String model) { this.model = model; }
    public void setColor(String color) { this.color = color; }
    public void setSold(int sold) { this.sold = sold; }
    public void setPrice(double price) { this.price = price; }



}

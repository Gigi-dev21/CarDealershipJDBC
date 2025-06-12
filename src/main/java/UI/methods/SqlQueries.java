package UI.methods;

public class SqlQueries {
    //Queries for View/Search Vehicles//
    public static final String SELECT_ALL_VEHICLES = "SELECT * FROM vehicles";

    public static final String SEARCH_BY_PRICE_RANGE =
            "SELECT * FROM vehicles WHERE price BETWEEN ? AND ?";

    public static final String SEARCH_BY_MAKE_MODEL =
            "SELECT * FROM vehicles WHERE make = ? AND model = ?";

    public static final String SEARCH_BY_YEAR_RANGE =
            "SELECT * FROM vehicles WHERE year BETWEEN ? AND ?";

    public static final String SEARCH_BY_COLOR =
            "SELECT * FROM vehicles WHERE color = ?";

    public static final String SEARCH_BY_MILEAGE_RANGE =
            "SELECT * FROM vehicles WHERE mileage BETWEEN ? AND ?";

    public static final String SEARCH_BY_TYPE =
            "SELECT * FROM vehicles WHERE type = ?";

    //Add vechile//
    public static final String INSERT_VEHICLE =
            "INSERT INTO vehicles (VIN, make, model, year, color, sold, price) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
}

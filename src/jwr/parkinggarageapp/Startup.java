package jwr.parkinggarageapp;

public class Startup {
    
    public static void main(String[] args) {
        DataAccessStrategy dataAccessStrategy = new InMemoryDataStorage();
        FeeCalculationStrategy feeCalc = new MinMaxFeeCalculator();
        ParkingGarageApp pgApp = new ParkingGarageApp("Best Value Parking Garage", feeCalc, dataAccessStrategy);
        
        pgApp.checkVehicleIn(5);
        pgApp.checkVehicleOut("1");
    }
}

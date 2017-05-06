package jwr.parkinggarageapp;

import java.io.File;

public class Startup {
    
    public static void main(String[] args) {
        String filePath = "src" + File.separatorChar + "file.txt";
        DataEntryStrategy dataEntryStrategy = new FileEntryStorage(filePath);
        DataAccessStrategy dataAccessStrategy = new FileDataStorage(filePath);
        FeeCalculationStrategy feeCalc = new MinMaxFeeCalculator(3,24,3,1,.75);
        OutputStrategy consoleOutput = new ConsoleOutput();
        OutputStrategy guiOutput = new GuiOutput();
        try{
            ParkingGarage pgApp = new ParkingGarage("Best Value Parking Garage", feeCalc, dataEntryStrategy, dataAccessStrategy, consoleOutput, guiOutput);
            
            pgApp.checkVehicleIn(5);
        
            pgApp.checkVehicleIn(6);
        
            pgApp.checkVehicleIn(12);
        
            pgApp.checkVehicleOut("1");
            pgApp.checkVehicleOut("2");
            pgApp.checkVehicleOut("3");
            
        } catch(IllegalArgumentException iae) {
            guiOutput.produceOutput(iae.getMessage());
        }
    }
}

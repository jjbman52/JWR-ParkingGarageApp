package jwrparkinggarageapp;

import edu.wctc.jwr.date.DateUtilities;
import java.io.*;
import java.util.*;

public class Startup {
    
    public static void main(String[] args) {
        DateUtilities dateUtil = new DateUtilities();
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        Map<String,String> map = new HashMap<>();
        String filePath = "src" + File.separatorChar + "fileStorage.txt";
        String totalsFilepath = "src" + File.separatorChar + "totals.txt";
        GarageAppGenericFileFormatter format = new GarageAppGenericFileFormatter(", ");
        DataEntryStrategy dataEntryStrategy = new FileEntryStorage(filePath, dateUtil);
        DataAccessStrategy dataAccessStrategy = new FileDataStorage(filePath, dateUtil);
        
        OutputStrategy customerReceiptOutput = new ConsoleOutput();
        OutputStrategy companyReceiptOutput = new ConsoleOutput();
        OutputStrategy onScreenDisplayOutput = new GuiOutput();
        
        double minHours = 8;
        double maxHours = 0;
        double additionalTime = 1;
        double additionalFee = .5;
        
        try{
            FeeCalculationStrategy feeCalc = ExternalSpecFactory.getFeeCalculatorInstance();
            feeCalc = new AdditionalTimeFeeCalculator(feeCalc, minHours, maxHours, additionalFee, additionalTime);
        
            ParkingGarage pgApp = new ParkingGarage("Best Value Parking Garage", "BVPG1", feeCalc, dataEntryStrategy, dataAccessStrategy, customerReceiptOutput, companyReceiptOutput, onScreenDisplayOutput, dateUtil, list, map, totalsFilepath, format);
            
            pgApp.checkVehicleIn(dateUtil.convertFormattedStringToLocalDateTime("2017-05-15T12:00:00"));
        
            pgApp.checkVehicleIn(dateUtil.convertFormattedStringToLocalDateTime("2017-05-15T07:00:00"));
        
            pgApp.checkVehicleIn(dateUtil.convertFormattedStringToLocalDateTime("2017-05-15T05:00:00"));
        
            pgApp.checkVehicleOut("1");
            pgApp.checkVehicleOut("2");
            pgApp.checkVehicleOut("3");
            
        } catch(Exception iae) {
            onScreenDisplayOutput.produceOutput(iae.getMessage());
        }
    }
}

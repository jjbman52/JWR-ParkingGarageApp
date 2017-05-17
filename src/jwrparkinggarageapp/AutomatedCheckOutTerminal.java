package jwrparkinggarageapp;

import edu.wctc.jwr.date.DateUtilities;
import java.util.*;

public class AutomatedCheckOutTerminal {
    private final String name = "Automated Check-out Terminal";
    private final String id = "AutomatedCheckOutTerminal1";

    public AutomatedCheckOutTerminal(final String ticketId, final FeeCalculationStrategy feeCalc, final DataAccessStrategy dataAccessStrategy, final OutputStrategy consoleOutput, final OutputStrategy guiOutput, final DateUtilities dateUtil, final List<Map<String,String>> list, final Map<String,String> map, final String filePath, final GarageAppGenericFileFormatter format){
        endParkingTransaction(ticketId, feeCalc, dataAccessStrategy, consoleOutput, guiOutput, dateUtil, list, map, filePath, format);
    }
    
    public final void endParkingTransaction(final String ticketId, final FeeCalculationStrategy feeCalc, final DataAccessStrategy dataAccessStrategy, final OutputStrategy consoleOutput, final OutputStrategy guiOutput, final DateUtilities dateUtil, final List<Map<String,String>> list, final Map<String,String> map, final String filePath, final GarageAppGenericFileFormatter format){
        try{
            Receipt receipt = new Receipt(ticketId, feeCalc, dataAccessStrategy, dateUtil);
            GarageTotalsToListOfMaps totalsToListOfMaps = new GarageTotalsToListOfMaps(filePath, format);
            totalsToListOfMaps.getTotalsInListOfMaps(receipt, list, map);
            consoleOutput.produceOutput(receipt.getReceipt());
            guiOutput.produceOutput(receipt.getReceipt() + "\n\n" + "The Gate is now Open");
        }
         catch(Exception iae) {
            guiOutput.produceOutput(iae.getMessage());
        }
    }

    @Override
    public final String toString() {
        return "name=" + name + ", id=" + id;
    }

    @Override
    public final int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AutomatedCheckOutTerminal other = (AutomatedCheckOutTerminal) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}

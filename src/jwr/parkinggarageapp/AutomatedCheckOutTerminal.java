package jwr.parkinggarageapp;

public class AutomatedCheckOutTerminal {

    public AutomatedCheckOutTerminal(final String ticketId, final FeeCalculationStrategy feeCalc, final DataAccessStrategy dataAccessStrategy, OutputStrategy consoleOutput, OutputStrategy guiOutput) {
        endParkingTransaction(ticketId, feeCalc, dataAccessStrategy, consoleOutput, guiOutput);
    }
    
    public final void endParkingTransaction(final String ticketId, final FeeCalculationStrategy feeCalc, final DataAccessStrategy dataAccessStrategy, OutputStrategy consoleOutput, OutputStrategy guiOutput){
        try{
            Receipt receipt = new Receipt(ticketId, feeCalc, dataAccessStrategy);
            consoleOutput.produceOutput(receipt.getReceipt());
            guiOutput.produceOutput(receipt.getReceipt() + "\n\n" + "The Gate is now Open");
        }
         catch(IllegalArgumentException iae) {
            guiOutput.produceOutput(iae.getMessage());
        }
    }
}

package jwr.parkinggarageapp;

public class AutomatedCheckOutTerminal {
    OutputStrategy output;

    public AutomatedCheckOutTerminal(String ticketId, FeeCalculationStrategy feeCalc, DataAccessStrategy dataAccessStrategy) {
        endParkingTransaction(ticketId, feeCalc, dataAccessStrategy);
    }
    
    public final void endParkingTransaction(String ticketId, FeeCalculationStrategy feeCalc, DataAccessStrategy dataAccessStrategy){
        Receipt receipt = new Receipt(ticketId, feeCalc, dataAccessStrategy);
        output.produceOutput(receipt.getReceipt());
    }
}

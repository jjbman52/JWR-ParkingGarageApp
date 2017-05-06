package jwr.parkinggarageapp;

public class ParkingGarage {
    private String companyName;
    private int ticketId = 0;
    private DataAccessStrategy dataAccessStrategy;
    private DataEntryStrategy dataEntryStrategy;
    private FeeCalculationStrategy feeCalc;
    private AutomatedCheckInTerminal autoCheckIn;
    private AutomatedCheckOutTerminal autoCheckOut;
//    private GarageTotalReceipt totalReceipt;
    private OutputStrategy consoleOutput;
    private OutputStrategy guiOutput;
    

    public ParkingGarage(final String companyName, final FeeCalculationStrategy feeCalc, final DataEntryStrategy dataEntryStrategy, final DataAccessStrategy dataAccessStrategy, final OutputStrategy consoleOutput, final OutputStrategy guiOutput) throws IllegalArgumentException{
        setCompanyName(companyName);
        setDataAccessStrategy(dataAccessStrategy);
        setFeeCalc(feeCalc);
//        totalReceipt = new GarageTotalReceipt(feeCalc, dataAccessStrategy);
        setConsoleOutput(consoleOutput);
        setGuiOutput(guiOutput);
    }
    
    public final void checkVehicleIn(final double hours){
        setTicketId(ticketId);
        autoCheckIn = new AutomatedCheckInTerminal(companyName, Integer.toString(ticketId), hours, dataEntryStrategy, consoleOutput, guiOutput);
    }
    
    public final void checkVehicleOut(final String ticketId){
        autoCheckOut = new AutomatedCheckOutTerminal(ticketId, feeCalc, dataAccessStrategy, consoleOutput, guiOutput);
        //add ticket to a total receipt
        
        //                  File Reader / Writer
        
//        totalReceipt.addTicket(ticketId);
//        output.produceOutput(totalReceipt.getTotalReceipt());
    }

    public final String getCompanyName() {
        return companyName;
    }

    public final void setCompanyName(final String companyName) throws IllegalArgumentException{
        if(companyName == null || companyName.isEmpty() || companyName.length() < 2){
            throw new IllegalArgumentException("Input is not valid.");
        }else{
            this.companyName = companyName;
        }
    }

    public final int getTicketId() {
        return ticketId;
    }

    public final void setTicketId(final int ticketId) throws IllegalArgumentException{
        if(ticketId < 0){
            throw new IllegalArgumentException("Input is not valid: Ticket Id must be greater than 0");
        }else{
            this.ticketId = ticketId + 1;
        }
    }

    public final FeeCalculationStrategy getFeeCalc() {
        return feeCalc;
    }

    public final void setFeeCalc(final FeeCalculationStrategy feeCalc) throws IllegalArgumentException{
        if(feeCalc == null){
            throw new IllegalArgumentException("Fee Calculator was not found.");
        }else{
            this.feeCalc = feeCalc;
        }
    }

    public final DataAccessStrategy getDataAccessStrategy() {
        return dataAccessStrategy;
    }

    public final void setDataAccessStrategy(final DataAccessStrategy dataAccessStrategy) throws IllegalArgumentException{
        if(dataAccessStrategy == null){
            throw new IllegalArgumentException("Data Access Strategy was not found.");
        }else{
            this.dataAccessStrategy = dataAccessStrategy;
        }
    }

    public DataEntryStrategy getDataEntryStrategy() {
        return dataEntryStrategy;
    }

    public void setDataEntryStrategy(DataEntryStrategy dataEntryStrategy) throws IllegalArgumentException{
        if(dataEntryStrategy == null){
            throw new IllegalArgumentException("Data Access Strategy was not found.");
        }else{
            this.dataEntryStrategy = dataEntryStrategy;
        }
    }

    public OutputStrategy getConsoleOutput() {
        return consoleOutput;
    }

    public void setConsoleOutput(OutputStrategy consoleOutput) throws IllegalArgumentException{
        if(consoleOutput == null){
            throw new IllegalArgumentException("Console Output was not found.");
        }else{
            this.consoleOutput = consoleOutput;
        }
    }

    public OutputStrategy getGuiOutput() {
        return guiOutput;
    }

    public void setGuiOutput(OutputStrategy guiOutput) throws IllegalArgumentException{
        if(consoleOutput == null){
            throw new IllegalArgumentException("GUI Output was not found.");
        }else{
            this.guiOutput = guiOutput;
        }
    }
}
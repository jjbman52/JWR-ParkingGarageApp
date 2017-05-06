package jwr.parkinggarageapp;

public class AutomatedCheckInTerminal{

    public AutomatedCheckInTerminal(final String companyName, final String ticketId, final double hours, final DataEntryStrategy dataEntryStrategy, final OutputStrategy consoleOutput, final OutputStrategy guiOutput) {
//        dataEntry = new FileEntryStorage();
        startParkingTransaction(companyName, ticketId, hours, dataEntryStrategy, consoleOutput, guiOutput);
    }

    public final void startParkingTransaction(final String companyName, final String ticketId, final double hours, final DataEntryStrategy dataEntryStrategy, final OutputStrategy consoleOutput, final OutputStrategy guiOutput) {
        try{
            Ticket ticket = new Ticket(companyName, ticketId ,hours);
            consoleOutput.produceOutput(ticket.getTicket());
            dataEntryStrategy.writeData(ticket);
            guiOutput.produceOutput("Gate is now open");
        } catch(IllegalArgumentException iae) {
            guiOutput.produceOutput(iae.getMessage());
        }
    }
}

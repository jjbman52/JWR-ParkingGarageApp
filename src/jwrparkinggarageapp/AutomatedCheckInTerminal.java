package jwrparkinggarageapp;

import edu.wctc.jwr.date.DateUtilities;
import java.time.LocalDateTime;
import java.util.Objects;

public class AutomatedCheckInTerminal{
    private final String name = "Automated Check-In Terminal";
    private final String id = "AutomatedCheckInTerminal1";

    public AutomatedCheckInTerminal(final String companyName, final String ticketId, final LocalDateTime dateTime, final DataEntryStrategy dataEntryStrategy, final OutputStrategy customerReceiptOutput, final OutputStrategy guiOutput, final DateUtilities dateUtil){
//        dataEntry = new FileEntryStorage();
        startParkingTransaction(companyName, ticketId, dateTime, dataEntryStrategy, customerReceiptOutput, guiOutput, dateUtil);
    }

    public final void startParkingTransaction(final String companyName, final String ticketId, final LocalDateTime dateTime, final DataEntryStrategy dataEntryStrategy, final OutputStrategy customerReceiptOutput, final OutputStrategy guiOutput, final DateUtilities dateUtil){
        try{
            Ticket ticket = new Ticket(companyName, ticketId, dateTime);
            customerReceiptOutput.produceOutput(ticket.getTicket(dateUtil));
            dataEntryStrategy.writeData(ticket);
            guiOutput.produceOutput("Gate is now open");
        } catch(Exception iae) {
            guiOutput.produceOutput(iae.getMessage());
        }
    }

    @Override
    public final String toString() {
        return "name=" + name + ", id=" + id;
    }

    @Override
    public final int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.name);
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final AutomatedCheckInTerminal other = (AutomatedCheckInTerminal) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}

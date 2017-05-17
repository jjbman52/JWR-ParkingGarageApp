package jwrparkinggarageapp;

import edu.wctc.jwr.date.DateUtilities;
import java.util.Arrays;
import java.util.Objects;

public class InMemoryDataStorage implements DataAccessStrategy{
    private DateUtilities dateUtil;

    public InMemoryDataStorage(DateUtilities dateUtil) throws Exception{
        if(dateUtil == null){
            throw new IllegalArgumentException("dateUtil invalid.");
        }else{
            this.dateUtil = dateUtil;
        }
    }
    
    private final Ticket[] tickets = {
        new Ticket("Best Value Parking Garage", "1", dateUtil.convertFormattedStringToLocalDateTime("05-16-2017T20:00:00")),
        new Ticket("Best Value Parking Garage", "2", dateUtil.convertFormattedStringToLocalDateTime("05-16-2017T17:00:00")),
        new Ticket("Best Value Parking Garage", "3", dateUtil.convertFormattedStringToLocalDateTime("05-16-2017T12:00:00"))
    };
    
    @Override
    public final Ticket findTicket(final String ticketId) throws IllegalArgumentException{
        if(ticketId == null || ticketId.length() == 0) {
            throw new IllegalArgumentException("Invalid Entry");
        } else {
        
        Ticket ticket = null;
        for(Ticket t : tickets) {
            if(ticketId.equals(t.getTicketId())) {
                ticket = t;
                break;
            }
        }
        return ticket;
        }
    }

    @Override
    public final String toString() {
        return "InMemoryDataStorage{" + "dateUtil=" + dateUtil + ", tickets=" + tickets + '}';
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.dateUtil);
        hash = 53 * hash + Arrays.deepHashCode(this.tickets);
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
        final InMemoryDataStorage other = (InMemoryDataStorage) obj;
        if (!Objects.equals(this.dateUtil, other.dateUtil)) {
            return false;
        }
        if (!Arrays.deepEquals(this.tickets, other.tickets)) {
            return false;
        }
        return true;
    }
}

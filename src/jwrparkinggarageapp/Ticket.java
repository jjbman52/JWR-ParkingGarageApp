package jwrparkinggarageapp;

import edu.wctc.jwr.date.DateUtilities;
import java.time.*;
import java.util.*;

public class Ticket {
    private String companyName;
    private String ticketId;
    private LocalDateTime dateTime;
    
    public Ticket(final String companyName, final String ticketId, final LocalDateTime dateTime) throws Exception{
        setCompanyName(companyName);
        setTicketId(ticketId);
        setDateTime(dateTime);
    }
    
    public final String getTicket(final DateUtilities dateUtil){
        String ticket;
        
        ticket = "---Ticket---" + "\n" +
                 companyName + "\n" +
                 "Ticket ID: " + ticketId + "\n" +
                 "Hours: " + dateUtil.toString(dateTime) + "\n" +
                 "----------------------\n";
        
        return ticket;
    }

    public final String getCompanyName() {
        return companyName;
    }

    public final void setCompanyName(final String companyName) throws IllegalArgumentException{
        if(companyName == null || companyName.isEmpty()){
            throw new IllegalArgumentException("Input is not valid: There must be a Company Name");
        }else{
            this.companyName = companyName;
        }
    }

    public final String getTicketId() {
        return ticketId;
    }

    public final void setTicketId(final String ticketId) throws IllegalArgumentException{
        if(ticketId == null || ticketId.isEmpty()){
            throw new IllegalArgumentException("Input is not valid: There must be a Ticket Id");
        }else{
            this.ticketId = ticketId;
        }
    }

    public final LocalDateTime getDateTime() {
        return dateTime;
    }

    public final void setDateTime(final LocalDateTime dateTime) throws IllegalArgumentException{
        if(dateTime == null){
            throw new IllegalArgumentException("LocalDateTime is not valid");
        }else{
            this.dateTime = dateTime;
        }
    }

    @Override
    public final String toString() {
        return "companyName=" + companyName + ", ticketId=" + ticketId;
    }

    @Override
    public final int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.ticketId);
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
        final Ticket other = (Ticket) obj;
        if (!Objects.equals(this.ticketId, other.ticketId)) {
            return false;
        }
        return true;
    }
}

package jwr.parkinggarageapp;

public class Ticket {
    String companyName;
    String ticketId;
    double hours;
    
    public Ticket(String companyName, String ticketId, double hours) {
        this.companyName = companyName;
        this.ticketId = ticketId;
        this.hours = hours;
    }
    
    public final String getTicket(){
        String ticket;
        
        ticket = companyName + "\n" +
                 "Ticket ID: " + ticketId + "\n" +
                 "Hours: " + hours;
        
        return ticket;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
}

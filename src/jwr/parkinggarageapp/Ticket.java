package jwr.parkinggarageapp;

public class Ticket {
    private String companyName;
    private String ticketId;
    private double hours;
    
    public Ticket(final String companyName, final String ticketId, final double hours) throws IllegalArgumentException{
        setCompanyName(companyName);
        setTicketId(ticketId);
        setHours(hours);
    }
    
    public final String getTicket(){
        String ticket;
        
        ticket = "---Ticket---" + "\n" +
                 companyName + "\n" +
                 "Ticket ID: " + ticketId + "\n" +
                 "Hours: " + hours + "\n" +
                 "----------------------\n";
        
        return ticket;
    }

    public final String getCompanyName() {
        return companyName;
    }

    public final void setCompanyName(String companyName) throws IllegalArgumentException{
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

    public final double getHours() {
        return hours;
    }

    public final void setHours(double hours) throws IllegalArgumentException{
        if(hours < 0){
            throw new IllegalArgumentException("Input is not valid: There must be Hours greater than 0");
        }else{
            this.hours = hours;
        }
    }
}

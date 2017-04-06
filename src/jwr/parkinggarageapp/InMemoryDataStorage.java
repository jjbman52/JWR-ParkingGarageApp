package jwr.parkinggarageapp;

public class InMemoryDataStorage implements DataAccessStrategy{
    private Ticket[] tickets = {
        new Ticket("Best Value Parking Garage", "1", 5),
        new Ticket("Best Value Parking Garage", "2", 6),
        new Ticket("Best Value Parking Garage", "3", 12)
    };
    
    @Override
    public final Ticket findTicket(final String ticketId) {
        // validation is needed for method parameter
        if(ticketId == null || ticketId.length() == 0) {
            System.out.println("Sorry, FakeDatabase.findStore method has "
                    + "illegal argument");
            return null;  // end method prematurely after log to console
        }
        
        Ticket ticket = null;
        for(Ticket t : tickets) {
            if(ticketId.equals(ticket.getTicketId())) {
                ticket = t;
                break;
            }
        }
        
        return ticket;
    }
}

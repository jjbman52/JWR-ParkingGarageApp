package jwr.parkinggarageapp;

public class InMemoryDataStorage implements DataAccessStrategy{
    private final Ticket[] tickets = {
        new Ticket("Best Value Parking Garage", "1", 5),
        new Ticket("Best Value Parking Garage", "2", 6),
        new Ticket("Best Value Parking Garage", "3", 12)
    };
    
    @Override
    public final Ticket findTicket(final String ticketId) {
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
}

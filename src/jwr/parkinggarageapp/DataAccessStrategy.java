package jwr.parkinggarageapp;

public interface DataAccessStrategy {
    public abstract Ticket findTicket(final String ticketId);
}

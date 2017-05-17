package jwrparkinggarageapp;

public interface DataAccessStrategy {
    public abstract Ticket findTicket(final String ticketId) throws Exception;
}

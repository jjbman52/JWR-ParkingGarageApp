package jwr.parkinggarageapp;

interface DataAccessStrategy {
    public abstract Ticket findTicket(String ticketId);
}

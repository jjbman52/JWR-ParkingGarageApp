package jwrparkinggarageapp;

public interface DataEntryStrategy {
    public abstract void writeData(final Ticket ticket) throws Exception;
}

package jwrparkinggarageapp;

import java.util.Arrays;

/**
 *
 * @author jordanrehbein
 */
public class ArrayDataEntryStorage implements DataEntryStrategy{
    private Ticket[] tickets = new Ticket[0];

    @Override
    public final void writeData(final Ticket ticket) throws IllegalArgumentException{
        addToArray(ticket);
    }
    
    private final void addToArray(final Ticket ticket) throws IllegalArgumentException{
        if(ticket.equals(null)){
            throw new IllegalArgumentException("Ticket does not exist.");
        } else {
            Ticket[] tempItems = new Ticket[tickets.length + 1];
            System.arraycopy(tickets, 0, tempItems, 0, tickets.length);
            tempItems[tickets.length] = ticket;
            tickets = tempItems;
            tempItems = null;
        }
    }

    @Override
    public final String toString() {
        return "ArrayDataEntryStorage{" + "tickets=" + tickets + '}';
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 79 * hash + Arrays.deepHashCode(this.tickets);
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
        final ArrayDataEntryStorage other = (ArrayDataEntryStorage) obj;
        if (!Arrays.deepEquals(this.tickets, other.tickets)) {
            return false;
        }
        return true;
    }
}

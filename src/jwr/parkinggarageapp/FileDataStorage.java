package jwr.parkinggarageapp;

import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FileDataStorage implements DataAccessStrategy{
    private File file;
    private Ticket[] tickets = new Ticket[0];
    private Ticket ticket;
    
    public FileDataStorage(String fileName){
    file = new File(fileName);
    }

    @Override
    public final Ticket findTicket(final String ticketId) {
        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNext()){
                String line = scanner.nextLine();
                String[] fields = line.split(", ");
                String companyName = fields[0];
                String tickId = fields[1];
                double hours = Double.parseDouble(fields[2]);
                ticket = new Ticket(companyName, tickId, hours);
                addToArray(ticket);
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        Ticket ticket = null;
        for(Ticket t : tickets) {
            if(ticketId.equals(t.getTicketId())) {
                ticket = t;
                break;
            }
        }
        return ticket;
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
}

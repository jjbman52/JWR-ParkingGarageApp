package jwr.parkinggarageapp;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FileEntryStorage implements DataEntryStrategy{
    private File file;
    private Ticket[] tickets = new Ticket[0];
    private Ticket oldTicket;
    
    public FileEntryStorage(String filePath){
         file = new File(filePath);
    }

    @Override
    public final void writeData(final Ticket ticket) {
        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNext()){
                String line = scanner.nextLine();
                String[] fields = line.split(", ");
                String companyName = fields[0];
                String tickId = fields[1];
                double hours = Double.parseDouble(fields[2]);
                oldTicket = new Ticket(companyName, tickId, hours);
                addToArray(oldTicket);
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        String line = ticket.getCompanyName() + ", " + ticket.getTicketId() + ", " + Double.toString(ticket.getHours());
        
        try (PrintWriter writer = new PrintWriter(file)){
            for(Ticket t : tickets){
                String oldLine = t.getCompanyName() + ", " + t.getTicketId() + ", " + Double.toString(t.getHours());
                writer.println(oldLine);
            }
            writer.println(line);
            writer.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private final void addToArray(final Ticket ticket) {
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

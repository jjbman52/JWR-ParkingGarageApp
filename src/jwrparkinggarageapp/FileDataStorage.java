package jwrparkinggarageapp;

import edu.wctc.jwr.date.DateUtilities;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FileDataStorage implements DataAccessStrategy{
    private String filePath;
    private DateUtilities dateUtil;
    private Ticket[] tickets;
    private Ticket oldTicket;
    
    public FileDataStorage(final String filePath, final DateUtilities dateUtil){
        setFilePath(filePath);
        this.dateUtil = dateUtil;
        tickets = new Ticket[0];
    }

    @Override
    public final Ticket findTicket(final String ticketId)throws Exception{
        if(ticketId == null){
            throw new IllegalArgumentException("Ticket does not exist.");
        }else{
            File file = new File(filePath);
        
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
        
            while(line != null){
                String[] fields = line.split(", ");
                String companyName = fields[0];
                String tickId = fields[1];
                LocalDateTime dateTime = dateUtil.convertFormattedStringToLocalDateTime(fields[2]);
                oldTicket = new Ticket(companyName, tickId, dateTime);
                addToArray(oldTicket);
                line = in.readLine();
            }
            in.close();
        
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
    
    private final void addToArray(final Ticket ticket) throws IllegalArgumentException{
        if(ticket == null){
            throw new IllegalArgumentException("Ticket does not exist.");
        } else {
            Ticket[] tempItems = new Ticket[tickets.length + 1];
            System.arraycopy(tickets, 0, tempItems, 0, tickets.length);
            tempItems[tickets.length] = ticket;
            tickets = tempItems;
            tempItems = null;
        }
    }
    

    public final String getFilePath() {
        return filePath;
    }

    public final void setFilePath(String filePath) throws IllegalArgumentException{
        if(filePath == null){
            throw new IllegalArgumentException("filePath invalid.");
        }else{
            this.filePath = filePath;
        }
    }

    @Override
    public final String toString() {
        return "FileDataStorage{" + "filePath=" + filePath + '}';
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.filePath);
        hash = 89 * hash + Objects.hashCode(this.dateUtil);
        hash = 89 * hash + Arrays.deepHashCode(this.tickets);
        hash = 89 * hash + Objects.hashCode(this.oldTicket);
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
        final FileDataStorage other = (FileDataStorage) obj;
        if (!Objects.equals(this.filePath, other.filePath)) {
            return false;
        }
        if (!Objects.equals(this.dateUtil, other.dateUtil)) {
            return false;
        }
        if (!Arrays.deepEquals(this.tickets, other.tickets)) {
            return false;
        }
        if (!Objects.equals(this.oldTicket, other.oldTicket)) {
            return false;
        }
        return true;
    }
}

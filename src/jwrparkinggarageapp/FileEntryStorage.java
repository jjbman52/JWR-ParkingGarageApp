package jwrparkinggarageapp;

import edu.wctc.jwr.date.DateUtilities;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import javax.swing.JOptionPane;

public class FileEntryStorage implements DataEntryStrategy{
    private String filePath;
    private DateUtilities dateUtil;
    private Ticket[] tickets;
    private Ticket oldTicket;
    private Ticket newTicket;
    
    public FileEntryStorage(final String filePath, final DateUtilities dateUtil){
        setFilePath(filePath);
        this.dateUtil = dateUtil;
        tickets = new Ticket[0];
    }

    @Override
    public final void writeData(final Ticket ticket) throws Exception{
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
        
        newTicket = new Ticket(ticket.getCompanyName(), ticket.getTicketId(), ticket.getDateTime());
        addToArray(newTicket);
        
        PrintWriter writer = new PrintWriter(new FileWriter(file, false));
        for(Ticket t : tickets){
            writer.println(t.getCompanyName() + ", " + t.getTicketId() + ", " + t.getDateTime());
        }
        writer.close();
        tickets = new Ticket[0];
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

    public final String getFilePath() {
        return filePath;
    }

    public final void setFilePath(final String filePath) throws IllegalArgumentException{
        if(filePath == null ||filePath.isEmpty()){
            throw new IllegalArgumentException("filePath is incorrect.");
        }
        this.filePath = filePath;
    }

    @Override
    public final String toString() {
        return "FileEntryStorage{" + "filePath=" + filePath + '}';
    }

    @Override
    public final int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.filePath);
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
        final FileEntryStorage other = (FileEntryStorage) obj;
        if (!Objects.equals(this.filePath, other.filePath)) {
            return false;
        }
        return true;
    }
}

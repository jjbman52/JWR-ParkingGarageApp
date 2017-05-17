package jwrparkinggarageapp;

import edu.wctc.jwr.date.DateUtilities;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Objects;

public class GarageTotalReceipt{
    private Ticket[] tickets;
    private Ticket ticket;
    private FeeCalculationStrategy feeCalc;
    private DataAccessStrategy dataAccessStrategy;
    private DateUtilities dateUtil;

    public GarageTotalReceipt(final FeeCalculationStrategy feeCalc, final DataAccessStrategy dataAccessStrategy, final DateUtilities dateUtil) {
        tickets = new Ticket[0];
        setFeeCalc(feeCalc);
        setDataAccessStrategy(dataAccessStrategy);
        this.dateUtil = dateUtil;
    }
    
    private final Ticket findTicket(final String ticketId, final DataAccessStrategy dataAccessStrategy) throws Exception{
        if(ticketId == null || dataAccessStrategy == null){
            throw new IllegalArgumentException("input is invaild");
        }else{
            return dataAccessStrategy.findTicket(ticketId);
        }
    }
    
    public final Ticket addTicket(final String ticketId) throws Exception{
        if(ticketId == null){
            throw new IllegalArgumentException("tickeId is invaild");
        }else{
            setTicket(findTicket(ticketId, dataAccessStrategy));
            addToArray(ticket);
            return ticket;
        }
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
    
    public final String getTotalReceipt() throws Exception{
        String totalReceipt = "";
        double totalHours = 0;
        double fee = 0;
            
        
        for(Ticket t : tickets) {
            double hours = 0;
            hours += dateUtil.getDifferenceDateTime(t.getDateTime(), LocalDateTime.now(), ChronoUnit.HOURS);
            totalHours += hours;
            fee += feeCalc.calculateFee(hours);
        }
        
        totalReceipt = "Totals for " + getTicket().getCompanyName() + ": \n" +
                       "Total Hours: " + totalHours + "\n" +
                       "Total Fees Collected: " + fee + "\n" +
                       "----------------------\n";
        
        return totalReceipt;
    }

    public final Ticket getTicket() {
        return ticket;
    }

    public final void setTicket(final Ticket ticket) throws IllegalArgumentException{
        if(ticket == null){
            throw new IllegalArgumentException("ticket invalid.");
        }else{
            this.ticket = ticket;
        }
    }

    public final FeeCalculationStrategy getFeeCalc() {
        return feeCalc;
    }

    public final void setFeeCalc(final FeeCalculationStrategy feeCalc) throws IllegalArgumentException{
        if(feeCalc == null){
            throw new IllegalArgumentException("feeCalc invalid.");
        }else{
            this.feeCalc = feeCalc;
        }
    }

    public final DataAccessStrategy getDataAccessStrategy() {
        return dataAccessStrategy;
    }

    public final void setDataAccessStrategy(final DataAccessStrategy dataAccessStrategy) throws IllegalArgumentException{
        if(dataAccessStrategy == null){
            throw new IllegalArgumentException("dataAccessStrategy invalid.");
        }else{
            this.dataAccessStrategy = dataAccessStrategy;
        }
    }

    @Override
    public final String toString() {
        return "GarageTotalReceipt{" + "tickets=" + tickets + ", ticket=" + ticket + ", feeCalc=" + feeCalc + ", dataAccessStrategy=" + dataAccessStrategy + ", dateUtil=" + dateUtil + '}';
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 43 * hash + Arrays.deepHashCode(this.tickets);
        hash = 43 * hash + Objects.hashCode(this.ticket);
        hash = 43 * hash + Objects.hashCode(this.feeCalc);
        hash = 43 * hash + Objects.hashCode(this.dataAccessStrategy);
        hash = 43 * hash + Objects.hashCode(this.dateUtil);
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
        final GarageTotalReceipt other = (GarageTotalReceipt) obj;
        if (!Arrays.deepEquals(this.tickets, other.tickets)) {
            return false;
        }
        if (!Objects.equals(this.ticket, other.ticket)) {
            return false;
        }
        if (!Objects.equals(this.feeCalc, other.feeCalc)) {
            return false;
        }
        if (!Objects.equals(this.dataAccessStrategy, other.dataAccessStrategy)) {
            return false;
        }
        if (!Objects.equals(this.dateUtil, other.dateUtil)) {
            return false;
        }
        return true;
    }
}

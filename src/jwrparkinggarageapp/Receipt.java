package jwrparkinggarageapp;

import edu.wctc.jwr.date.DateUtilities;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Receipt {
    private Ticket ticket;
    private double hours;
    private FeeCalculationStrategy feeCalc;
    
    public Receipt(final String ticketId, final FeeCalculationStrategy feeCalc, final DataAccessStrategy dataAccessStrategy, final DateUtilities dateUtil) throws Exception{
        setTicket(findTicket(ticketId, dataAccessStrategy));
        setFeeCalc(feeCalc);
        setHours(dateUtil);
    }
    
    private final Ticket findTicket(final String ticketId, final DataAccessStrategy dataAccessStrategy) throws Exception{
        return dataAccessStrategy.findTicket(ticketId);
    }

    public final Ticket getTicket() {
        return ticket;
    }

    public final void setTicket(final Ticket ticket) throws IllegalArgumentException{
        if(ticket == null){
            throw new IllegalArgumentException("Ticket was not found.");
        }else{
            this.ticket = ticket;
        }
    }
    
    public final String getReceipt()throws Exception{
        String receipt;
        
        receipt = "---Customer Receipt---\n" +
                  ticket.getCompanyName() + "\n" +
                 "Ticket ID: " + ticket.getTicketId() + "\n" +
                 "Hours: " + hours + "\n" +
                 "Fee Charged: " + getFee() + "\n" +
                 "----------------------\n";
        
        return receipt;
    }
    
    public final double getFee() throws Exception{
        double fee;
        fee = feeCalc.calculateFee(hours);
        return fee;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(final DateUtilities dateUtil) throws IllegalArgumentException{
        if(dateUtil == null){
            throw new IllegalArgumentException("Date Utilities was not found.");
        }else{
            this.hours = dateUtil.getDifferenceDateTime(ticket.getDateTime(), LocalDateTime.now(), ChronoUnit.HOURS);
        }
    }

    public final FeeCalculationStrategy getFeeCalc() throws IllegalArgumentException{
        return feeCalc;
    }

    public final void setFeeCalc(final FeeCalculationStrategy feeCalc) {
        if(feeCalc == null){
            throw new IllegalArgumentException("Fee Calculator was not found.");
        }else{
            this.feeCalc = feeCalc;
        }
    }

    @Override
    public final String toString() {
        return "ticket=" + ticket;
    }

    @Override
    public final int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.ticket);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.hours) ^ (Double.doubleToLongBits(this.hours) >>> 32));
        hash = 79 * hash + Objects.hashCode(this.feeCalc);
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
        final Receipt other = (Receipt) obj;
        if (Double.doubleToLongBits(this.hours) != Double.doubleToLongBits(other.hours)) {
            return false;
        }
        if (!Objects.equals(this.ticket, other.ticket)) {
            return false;
        }
        if (!Objects.equals(this.feeCalc, other.feeCalc)) {
            return false;
        }
        return true;
    }
}

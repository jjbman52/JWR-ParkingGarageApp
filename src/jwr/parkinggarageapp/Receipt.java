package jwr.parkinggarageapp;

public class Receipt {
    private Ticket ticket;
    private FeeCalculationStrategy feeCalc;
    
    public Receipt(final String ticketId, final FeeCalculationStrategy feeCalc, final DataAccessStrategy dataAccessStrategy) {
        setTicket(findTicket(ticketId, dataAccessStrategy));
        setFeeCalc(feeCalc);
    }
    
    private final Ticket findTicket(final String ticketId, final DataAccessStrategy dataAccessStrategy){
        return dataAccessStrategy.findTicket(ticketId);
    }

    public final Ticket getTicket() {
        return ticket;
    }

    public final void setTicket(final Ticket ticket) {
        if(ticket == null){
            throw new IllegalArgumentException("Ticket was not found.");
        }else{
            this.ticket = ticket;
        }
    }
    
    public final String getReceipt(){
        String receipt;
        
        receipt = "---Customer Receipt---\n" +
                  ticket.getCompanyName() + "\n" +
                 "Ticket ID: " + ticket.getTicketId() + "\n" +
                 "Hours: " + ticket.getHours() + "\n" +
                 "Fee Charged: " + getFee() + "\n" +
                 "----------------------\n";
        
        return receipt;
    }
    
    public final double getFee(){
        double fee;
        fee = feeCalc.calculateFee(ticket.getHours());
        return fee;
    }

    public final FeeCalculationStrategy getFeeCalc() {
        return feeCalc;
    }

    public final void setFeeCalc(final FeeCalculationStrategy feeCalc) {
        if(feeCalc == null){
            throw new IllegalArgumentException("Fee Calculator was not found.");
        }else{
            this.feeCalc = feeCalc;
        }
    }
}

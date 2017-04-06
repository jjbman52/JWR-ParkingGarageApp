package jwr.parkinggarageapp;

public class Receipt {
    private Ticket ticket;
    private FeeCalculationStrategy feeCalc;
    
    public Receipt(String ticketId, FeeCalculationStrategy feeCalc, DataAccessStrategy dataAccessStrategy) {
        setTicket(findTicket(ticketId, dataAccessStrategy));
        setFeeCalc(feeCalc);
    }
    
    private Ticket findTicket(String ticketId, DataAccessStrategy dataAccessStrategy){
        return dataAccessStrategy.findTicket(ticketId);
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    
    public final String getReceipt(){
        String receipt;
        
        receipt = "Ticket ID: " + ticket.getTicketId() + "\n" +
                 ticket.companyName + "\n" +
                 "Hours: " + ticket.hours +
                 "Fee Charged: " + getFee();
        
        return receipt;
    }
    
    public final double getFee(){
        double fee;
        fee = feeCalc.calculateFee(ticket.hours);
        return fee;
    }

    public FeeCalculationStrategy getFeeCalc() {
        return feeCalc;
    }

    public void setFeeCalc(FeeCalculationStrategy feeCalc) {
        this.feeCalc = feeCalc;
    }
}

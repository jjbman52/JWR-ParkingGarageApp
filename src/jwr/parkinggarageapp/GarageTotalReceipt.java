package jwr.parkinggarageapp;

public class GarageTotalReceipt{
    private Ticket[] tickets;
    private Ticket ticket;
    private FeeCalculationStrategy feeCalc;
    private DataAccessStrategy dataAccessStrategy;

    public GarageTotalReceipt(final FeeCalculationStrategy feeCalc, final DataAccessStrategy dataAccessStrategy) {
        tickets = new Ticket[0];
        setFeeCalc(feeCalc);
        setDataAccessStrategy(dataAccessStrategy);
    }
    
    private final Ticket findTicket(final String ticketId, final DataAccessStrategy dataAccessStrategy){
        return dataAccessStrategy.findTicket(ticketId);
    }
    
    public final Ticket addTicket(final String ticketId){
        setTicket(findTicket(ticketId, dataAccessStrategy));
        addToArray(ticket);
        return ticket;
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
    
    public final String getTotalReceipt(){
        String totalReceipt = "";
        double hours = 0;
        double fee = 0;
        
        for(Ticket t : tickets) {
            hours += t.getHours();
            fee += feeCalc.calculateFee(t.getHours());
        }
        
        totalReceipt = "Totals for " + getTicket().getCompanyName() + ": \n" +
                       "Total Hours: " + hours + "\n" +
                       "Total Fees Collected: " + fee + "\n" +
                       "----------------------\n";
        
        return totalReceipt;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public final void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public final FeeCalculationStrategy getFeeCalc() {
        return feeCalc;
    }

    public final void setFeeCalc(FeeCalculationStrategy feeCalc) {
        this.feeCalc = feeCalc;
    }

    public final DataAccessStrategy getDataAccessStrategy() {
        return dataAccessStrategy;
    }

    public final void setDataAccessStrategy(DataAccessStrategy dataAccessStrategy) {
        this.dataAccessStrategy = dataAccessStrategy;
    }
}

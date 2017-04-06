package jwr.parkinggarageapp;

class AutomatedCheckInTerminal {
    private OutputStrategy output;

    public AutomatedCheckInTerminal(String companyName, double hours) {
        output = new ConsoleOutput();
        startParkingTransaction(companyName, hours);
    }

    public final void startParkingTransaction(String companyName, double hours) {
        Ticket ticket = new Ticket(companyName, "1" ,hours);
        output.produceOutput(ticket.getTicket());
    }
}

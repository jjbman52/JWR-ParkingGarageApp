/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwr.parkinggarageapp;

/**
 *
 * @author jordanrehbein
 */
public class ArrayDataEntryStorage implements DataEntryStrategy{
    private Ticket[] tickets = new Ticket[0];

    @Override
    public final void writeData(final Ticket ticket) {
        addToArray(ticket);
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

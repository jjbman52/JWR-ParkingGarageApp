/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwrparkinggarageapp;

/**
 *
 * @author jordanrehbein
 */
public class InvalidEntryException extends IllegalArgumentException{
    private final static String MESSAGE = "Entry is Invalid";
    
    public InvalidEntryException() {
        super(MESSAGE);
    }

    public InvalidEntryException(String message) {
        super(MESSAGE);
    }

    public InvalidEntryException(String message, Exception cause) {
        super(MESSAGE);
    }

    public InvalidEntryException(Throwable cause) {
        super(cause);
    }
}

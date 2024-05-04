package com.TicketBooking.ApplicationExceptions;

public class TicketAlreadySignedOutException extends RuntimeException {
    public TicketAlreadySignedOutException(String ticketAlreadySigned) {
        super(ticketAlreadySigned);
    }
}

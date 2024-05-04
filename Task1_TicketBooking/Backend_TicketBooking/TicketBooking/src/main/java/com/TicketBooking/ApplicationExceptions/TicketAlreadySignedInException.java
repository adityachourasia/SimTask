package com.TicketBooking.ApplicationExceptions;

public class TicketAlreadySignedInException extends RuntimeException {
    public TicketAlreadySignedInException(String ticketAlreadySigned) {
        super(ticketAlreadySigned);
    }
}

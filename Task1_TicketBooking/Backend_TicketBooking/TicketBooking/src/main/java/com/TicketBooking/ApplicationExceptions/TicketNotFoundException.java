package com.TicketBooking.ApplicationExceptions;

public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException(String ticketNotFound) {
        super(ticketNotFound);
    }
}

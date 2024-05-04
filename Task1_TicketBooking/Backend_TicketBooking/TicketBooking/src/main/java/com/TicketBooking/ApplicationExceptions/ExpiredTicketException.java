package com.TicketBooking.ApplicationExceptions;

public class ExpiredTicketException extends RuntimeException {
    public ExpiredTicketException(String ticketAlreadyExpired) {
        super(ticketAlreadyExpired);

    }
}

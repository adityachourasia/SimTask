package com.TicketBooking.Interfaces;


import com.TicketBooking.Models.Ticket;

import java.util.List;
import java.util.UUID;

public interface TicketServiceI {

    Ticket bookTicket(Ticket ticket);

    Ticket getTicket(UUID ticketId);

    List<Ticket> getAllTickets();

    Ticket signInTicket(UUID ticketId);

    Ticket signOutTicket(UUID ticketId);

    Boolean isExpired(Ticket ticket);



}

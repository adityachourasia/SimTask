package com.TicketBooking.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TicketBooking.ApplicationExceptions.ExpiredTicketException;
import com.TicketBooking.ApplicationExceptions.MalPracticeException;
import com.TicketBooking.ApplicationExceptions.TicketAlreadySignedInException;
import com.TicketBooking.ApplicationExceptions.TicketAlreadySignedOutException;
import com.TicketBooking.ApplicationExceptions.TicketNotFoundException;
import com.TicketBooking.Interfaces.TicketServiceI;
import com.TicketBooking.Models.Ticket;
import com.TicketBooking.Repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketServiceI {

    private int validityTime = 18 * 3600 * 1000;

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Ticket bookTicket(Ticket ticket) {
        ticket.setIssuedTimeStamp(new Date());
        ticket.setStatus("NEW");

        Ticket bookedTicket = ticketRepository.save(ticket);
        return bookedTicket;
    }

    @Override
    public Ticket getTicket(UUID ticketId) {
        Optional<Ticket> ticketById = this.ticketRepository.findById(ticketId);

        if (ticketById.isPresent()) {
            return ticketById.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Ticket> getAllTickets() {
        return this.ticketRepository.findAll();
    }

    @Override
    public Ticket signInTicket(UUID ticketId) {
        Optional<Ticket> ticketById = this.ticketRepository.findById(ticketId);
        if (ticketById.isPresent()) {
            Ticket ticket = ticketById.get();
            if (!isExpired(ticket)) {
                if (ticket.getStatus().equals("NEW")) {
                    ticket.setStatus("TRANSIT");
                    this.ticketRepository.save(ticket);
                    return ticket;
                } else {
                    throw new TicketAlreadySignedInException("Ticket Already SignedIn");
                }
            } else {
                throw new ExpiredTicketException("Ticket Expired");
            }

        }

        throw new TicketNotFoundException("Ticket Not Found");
    }

    @Override
    public Ticket signOutTicket(UUID ticketId) {
        Optional<Ticket> ticketById = this.ticketRepository.findById(ticketId);
        if (ticketById.isPresent()) {
            Ticket ticket = ticketById.get();
            switch (ticket.getStatus()) {
                case "TRANSIT" -> {
                    ticket.setStatus("EXPIRED");
                    this.ticketRepository.save(ticket);
                    return ticket;
                }
                case "NEW" ->
                    throw new MalPracticeException("Cannot Sign Out UnSignedin Ticket");
                case "EXPIRED" ->
                    throw new ExpiredTicketException("Ticket Expired");
                default ->
                    throw new TicketAlreadySignedOutException("Ticket Already Signed Out");
            }

        } else {

            throw new TicketNotFoundException("Ticket Not Found");
        }
    }

    @Override
    public Boolean isExpired(Ticket ticket) {

        Date issuedTimeStamp = ticket.getIssuedTimeStamp();
        Date expirationTimeStamp = new Date(issuedTimeStamp.getTime() + validityTime);
        Date currentTimeStamp = new Date();
        if (expirationTimeStamp.compareTo(currentTimeStamp) > 0) {
            if (ticket.getStatus().equals("EXPIRED")) {
                return true;
            }
            System.out.println("Ticket Not Expired");
            return false;
        } else {
            System.out.println("Ticket  Expired");
            this.ticketRepository.save(ticket);
            return true;
        }
    }
}

package com.TicketBooking.Models;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ticketId;
    private String fromStation;
    private String toStation;
    private Date issuedTimeStamp;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private long fare;


    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", fromStation='" + fromStation + '\'' +
                ", toStation='" + toStation + '\'' +
                ", issuedTimeStamp=" + issuedTimeStamp +
                ", status='" + status + '\'' +
                ", fare=" + fare +
                '}';
    }

    public long getFare() {
        return fare;
    }

    public void setFare(long fare) {
        this.fare = fare;
    }

    public UUID getTicketId() {
        return ticketId;
    }

    public void setTicketId(UUID ticketId) {
        this.ticketId = ticketId;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public Date getIssuedTimeStamp() {
        return issuedTimeStamp;
    }

    public void setIssuedTimeStamp(Date issuedTimeStamp) {
        this.issuedTimeStamp = issuedTimeStamp;
    }



}

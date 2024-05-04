package com.TicketBooking.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "train")
public class Station {
    public Station() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stationcode")
    private int stationCode;
    @Column(name = "stationname")
    private String stationName;
    @Column(name = "pricefromstart")
    private float priceFromStart;
    @Column(name = "stationtype")
    private String stationType;


    
    public Station(String stationName, float priceFromStart, String stationType) {
        this.stationName = stationName;
        this.priceFromStart = priceFromStart;
        this.stationType = stationType;
    }

    public int getStationCode() {
        return stationCode;
    }

    public void setStationCode(int stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public float getPriceFromStart() {
        return priceFromStart;
    }

    public void setPriceFromStart(float priceFromStart) {
        this.priceFromStart = priceFromStart;
    }

    public String getStationType() {
        return stationType;
    }

    public void setStationType(String stationType) {
        this.stationType = stationType;
    }

    @Override
    public String toString() {
        return "Station [stationCode=" + stationCode + ", stationName=" + stationName + ", priceFromStart="
                + priceFromStart + ", stationType=" + stationType + "]";
    }

}

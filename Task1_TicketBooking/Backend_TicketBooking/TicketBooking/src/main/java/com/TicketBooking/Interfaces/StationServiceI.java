package com.TicketBooking.Interfaces;

import com.TicketBooking.Models.Station;

import java.util.List;

public interface StationServiceI {

    List<Station> getStationList();

    void saveStations(List<Station> stations);



}

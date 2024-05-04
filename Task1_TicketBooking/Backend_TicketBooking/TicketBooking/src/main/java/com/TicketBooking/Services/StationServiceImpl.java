package com.TicketBooking.Services;

import com.TicketBooking.Interfaces.StationServiceI;
import com.TicketBooking.Models.Station;
import com.TicketBooking.Repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StationServiceImpl implements StationServiceI {

    @Autowired
    StationRepository stationRepository;

    @Override

    public List<Station> getStationList() {

        System.out.println(new Date()+" stationService");
        return stationRepository.findAll();
    }

    @Override
    public void saveStations(List<Station> stations) {
        this.stationRepository.saveAll(stations);
    }
}

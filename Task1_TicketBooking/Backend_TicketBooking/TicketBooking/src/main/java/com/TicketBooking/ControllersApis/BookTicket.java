package com.TicketBooking.ControllersApis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TicketBooking.Models.Station;
import com.TicketBooking.Models.Ticket;
import com.TicketBooking.Services.StationServiceImpl;
import com.TicketBooking.Services.TicketServiceImpl;

@RestController
@CrossOrigin("*")
public class BookTicket {

    @Autowired
    StationServiceImpl stationService;

    @Autowired
    TicketServiceImpl ticketService;

    @GetMapping("api/findstations")
    public ResponseEntity<List<Station>> getStations() {
        System.out.println(new Date() + "getStations Api");
        return new ResponseEntity<>(stationService.getStationList(), HttpStatus.OK);
    }

    @PostMapping("api/bookticket")
    public ResponseEntity<Ticket> bookTicket(@RequestBody Ticket ticket) {
        Ticket bookedTicket = ticketService.bookTicket(ticket);

        return new ResponseEntity<>(bookedTicket, HttpStatus.OK);
    }

    @GetMapping("api/getticket/{ticketId}")
    public ResponseEntity<Ticket> getTicket(@PathVariable UUID ticketId) {
        Ticket currentStatus = ticketService.getTicket(ticketId);
        return new ResponseEntity<>(currentStatus, HttpStatus.OK);
    }

    @GetMapping("api/alltickets")
    public ResponseEntity<List<Ticket>> getAllTicket() {
        List<Ticket> allTickets = ticketService.getAllTickets();
        return new ResponseEntity<>(allTickets, HttpStatus.OK);
    }

    @PostMapping("api/signin/{ticketId}")
    public ResponseEntity<Ticket> signIn(@PathVariable UUID ticketId) {
        Ticket ticket = ticketService.signInTicket(ticketId);
        System.out.println("Signing in: " + ticketId);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @PostMapping("api/signout/{ticketId}")
    public ResponseEntity<Ticket> signOut(@PathVariable UUID ticketId) {
        Ticket ticket = ticketService.signOutTicket(ticketId);
        System.out.println("Signout in: " + ticketId);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @GetMapping("api/addDummyData")
    public ResponseEntity<String> addDummyData() {

        List<Station> stationList = new ArrayList<>();
        stationList.addAll(Arrays.asList(
                new Station("DR AMBEDKAR NGR", 14.4f, "start"),
                new Station("INDORE JN BG", 62.1f, "middle"),
                new Station("DEWAS", 113.5f, "middle"),
                new Station("UJJAIN JN", 163.5f, "middle"),
                new Station("MAKSI", 213.2f, "middle"),
                new Station("BERCHHA", 263.2f, "middle"),
                new Station("AKODIA", 314.1f, "middle"),
                new Station("SHUJALPUR", 363.5f, "middle"),
                new Station("KALAPIPAL", 415.4f, "middle"),
                new Station("SEHORE", 463.2f, "middle"),
                new Station("S HIRDARAMNAGAR", 514.3f, "middle"),
                new Station("BHOPAL JN", 565.1f, "middle"),
                new Station("VIDISHA", 611.1f, "middle"),
                new Station("GANJ BASODA", 664.4f, "middle"),
                new Station("BINA JN", 712.3f, "middle"),
                new Station("LALITPUR JN", 764.2f, "middle"),
                new Station("BABINA", 814.2f, "middle"),
                new Station("V LAKSHMIBAIJHS", 861.2f, "middle"),
                new Station("DATIA", 914.1f, "middle"),
                new Station("DABRA", 962.3f, "middle"),
                new Station("GWALIOR", 1012.1f, "middle"),
                new Station("MORENA", 1064.2f, "middle"),
                new Station("DHAULPUR", 1112.2f, "middle"),
                new Station("AGRA CANTT", 1165.2f, "middle"),
                new Station("MATHURA JN", 1211.5f, "middle"),
                new Station("KOSI KALAN", 1264.3f, "middle"),
                new Station("PALWAL", 1315.4f, "middle"),
                new Station("BALLABGARH", 1362.2f, "middle"),
                new Station("FARIDABAD", 1413.4f, "middle"),
                new Station("H NIZAMUDDIN", 1462.3f, "middle"),
                new Station("NEW DELHI", 1512.2f, "middle"),
                new Station("LUDHIANA JN", 1565.2f, "middle"),
                new Station("JALANDHAR CANT", 1613.4f, "middle"),
                new Station("DASUYA", 1661.4f, "middle"),
                new Station("MUKERIAN", 1713.3f, "middle"),
                new Station("PATHANKOT CANTT", 1762.2f, "middle"),
                new Station("KATHUA", 1813.3f, "middle"),
                new Station("JAMMU TAWI", 1864.1f, "middle"),
                new Station("RAM NAGAR J K", 1915.2f, "middle"),
                new Station("MTYR C TUSHAR M", 1963.1f, "middle"),
                new Station("CHAK RAKHWAL", 2013.2f, "middle"),
                new Station("SHMATA VD KATRA", 2064.3f, "end")
        ));
        this.stationService.saveStations(stationList);
        return new ResponseEntity<>("Dummy Data Added To DB", HttpStatus.CREATED);
    }

}

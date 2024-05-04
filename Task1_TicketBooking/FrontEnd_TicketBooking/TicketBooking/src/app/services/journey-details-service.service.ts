import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Ticket } from '../models/ticket';

@Injectable({
  providedIn: 'root'
})
export class JourneyDetailsServiceService {

  constructor(private _http: HttpClient) {

  }

  getStationList() {
    return this._http.get("http://localhost:5000/api/findstations");
  }

  bookTicket(ticket: Ticket) {
    return this._http.post("http://localhost:5000/api/bookticket", ticket);
  }

  getAllTickets() {
    return this._http.get("http://localhost:5000/api/alltickets");
  }

  signInTicket(ticketId: String) {
    return this._http.post("http://localhost:5000/api/signin/" + ticketId, {});
  }

  signOutTicket(ticketId: String) {
    return this._http.post("http://localhost:5000/api/signout/" + ticketId, {});
  }

  addDummyData(){
    return this._http.get("http://localhost:5000/api/addDummyData");
  }


}

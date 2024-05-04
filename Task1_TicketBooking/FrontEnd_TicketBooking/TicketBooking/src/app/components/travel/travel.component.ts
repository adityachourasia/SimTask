import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Ticket } from 'src/app/models/ticket';
import { JourneyDetailsServiceService } from 'src/app/services/journey-details-service.service';

@Component({
  selector: 'app-travel',
  templateUrl: './travel.component.html',
  styleUrls: ['./travel.component.css']
})
export class TravelComponent implements OnInit {


  tickets!: Ticket[];
  signInTicket!: FormGroup;
  signOutTicket!: FormGroup;



  constructor(private _journeyDetailService: JourneyDetailsServiceService, private _formBuilder: FormBuilder) { }


  ngOnInit(): void {
    this._journeyDetailService.getAllTickets().subscribe(
      (data) =>
        this.tickets = data as Ticket[]
      , (err) => {
        alert("error" + err.message)
      }
    )
    console.log(this.tickets)
    this.signInTicket = this._formBuilder.group(
      { signInTicketId: [] }
    )

    this.signOutTicket = this._formBuilder.group(
      { signOutTicketId: [] }
    )

  }
  onSignInSubmit() {
    const ticketId = this.signInTicket.controls['signInTicketId'].value
    console.log(ticketId)
    this._journeyDetailService.signInTicket(ticketId).subscribe(

      (data) => {
        console.log(data)
        alert("Ticket Signed In Successfully with Id & Status: " + ticketId)
      },
      (err) => {
        alert("error" + err.message)
      }

    )
  }

  onSignOutSubmit() {
    const ticketId = this.signOutTicket.controls['signOutTicketId'].value
    console.log(ticketId)
    this._journeyDetailService.signOutTicket(ticketId).subscribe(
      (data) => {
        console.log(data)
        alert("Ticket Signed Out Successfully with Id & Status: " + ticketId)
      },
      (err) => {
        alert("error" + err.message)
      }

    )
  }

}

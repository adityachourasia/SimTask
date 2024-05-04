import { Component, OnInit } from '@angular/core';
import { tick } from '@angular/core/testing';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Station } from 'src/app/models/station';
import { Ticket } from 'src/app/models/ticket';
import { JourneyDetailsServiceService } from 'src/app/services/journey-details-service.service';

@Component({
  selector: 'app-journey-details',
  templateUrl: './journey-details.component.html',
  styleUrls: ['./journey-details.component.css']
})
export class JourneyDetailsComponent implements OnInit {




  journeyForm!: FormGroup;
  stations: Station[] | undefined;
  bookedTicket!: Ticket;
  // fromStation!: Station;
  // toStation!: Station;
  totalFare!: Number;

  constructor(private _formBuilder: FormBuilder, private _journeyDetailService: JourneyDetailsServiceService) { }

  ngOnInit(): void {

    this._journeyDetailService.getStationList().subscribe(
      (data) =>
        this.stations = data as Station[]
      , (err) => {
        alert("error" + err.message)
      });


    this.journeyForm = this._formBuilder.group(
      {
        fromStation: [],
        toStation: []
      }
    );
  }

  onSubmit() {
    console.log(this.journeyForm.value)
    let fromControl = this.journeyForm.controls['fromStation'].value
    let toControl = this.journeyForm.controls['toStation'].value
    let from = this.journeyForm.controls['fromStation'].value.stationName
    let to = this.journeyForm.controls['toStation'].value.stationName


    this.totalFare = Math.abs(fromControl.priceFromStart - toControl.priceFromStart)
    this.bookedTicket = new Ticket(from, to, this.totalFare)
    // console.log("Ticket: " + from + " To " + to + ", Fare: " + this.totalFare)
    this._journeyDetailService.bookTicket(this.bookedTicket).subscribe((data) => {
      this.bookedTicket = data as Ticket
      alert("Ticket Booked Successfully with Id: " + this.bookedTicket.ticketId)
    },
      (err) => {
        alert("error" + err.message)
      })


  }
  addDummyData() {
  }

}





import { Component } from '@angular/core';
import { JourneyDetailsServiceService } from 'src/app/services/journey-details-service.service';

@Component({
  selector: 'app-dummy-data',
  templateUrl: './dummy-data.component.html',
  styleUrls: ['./dummy-data.component.css']
})
export class DummyDataComponent {

  constructor(private _journeyDetailService: JourneyDetailsServiceService) { }


  addDummyData() {
    this._journeyDetailService.addDummyData().subscribe()
  }
}

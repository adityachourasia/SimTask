import { Component, OnInit } from '@angular/core';
import { DummyDataService } from 'src/app/services/dummy-data.service';

@Component({
  selector: 'app-main-table',
  templateUrl: './main-table.component.html',
  styleUrls: ['./main-table.component.css']
})
export class MainTableComponent implements OnInit {

  data: any

  constructor(private _dummyData: DummyDataService) { }

  ngOnInit(): void {
    this.data = this._dummyData.getDummyData();
    console.log(this.data);
  }

}

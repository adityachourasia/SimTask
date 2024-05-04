import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { JourneyDetailsComponent } from './components/journey-details/journey-details.component';
import { TravelComponent } from './components/travel/travel.component';
import { DummyDataComponent } from './components/dummy-data/dummy-data.component';

const routes: Routes = [
  {
    path: 'bookticket', component: JourneyDetailsComponent
  },
  {
    path: 'ticketops', component: TravelComponent
  },
  {
    path: 'dummydata', component: DummyDataComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

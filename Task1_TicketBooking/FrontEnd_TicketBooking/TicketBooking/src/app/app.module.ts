import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { JourneyDetailsComponent } from './components/journey-details/journey-details.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { TravelComponent } from './components/travel/travel.component';
import { DummyDataComponent } from './components/dummy-data/dummy-data.component';


@NgModule({
  declarations: [
    AppComponent,
    JourneyDetailsComponent,
    TravelComponent,
    DummyDataComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

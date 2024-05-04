import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainTableComponent } from './components/main-table/main-table.component';
import { NestedRowComponent } from './components/nested-row/nested-row.component';

@NgModule({
  declarations: [
    AppComponent,
    MainTableComponent,
    NestedRowComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

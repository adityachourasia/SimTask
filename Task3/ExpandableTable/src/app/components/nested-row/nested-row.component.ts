import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-nested-row',
  template: '<h1>Hello </h1>
  <app-nested-row *ngIf="children" [children]="children"></app-nested-row>',
  styleUrls: ['./nested-row.component.css']
})
export class NestedRowComponent {

  @Input() children: any;

}

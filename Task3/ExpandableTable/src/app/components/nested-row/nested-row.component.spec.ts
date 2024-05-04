import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NestedRowComponent } from './nested-row.component';

describe('NestedRowComponent', () => {
  let component: NestedRowComponent;
  let fixture: ComponentFixture<NestedRowComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NestedRowComponent]
    });
    fixture = TestBed.createComponent(NestedRowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { JourneyDetailsServiceService } from './journey-details-service.service';

describe('JourneyDetailsServiceService', () => {
  let service: JourneyDetailsServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JourneyDetailsServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

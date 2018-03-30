import { TestBed, inject } from '@angular/core/testing';

import { AdsErrorService } from './ads-error.service';

describe('AdsErrorService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AdsErrorService]
    });
  });

  it('should be created', inject([AdsErrorService], (service: AdsErrorService) => {
    expect(service).toBeTruthy();
  }));
});

import { TestBed, inject } from '@angular/core/testing';

import { AdsHelperService } from './ads-helper.service';

describe('AdsHelperService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AdsHelperService]
    });
  });

  it('should be created', inject([AdsHelperService], (service: AdsHelperService) => {
    expect(service).toBeTruthy();
  }));
});

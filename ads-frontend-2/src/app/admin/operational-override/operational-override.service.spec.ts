import { TestBed, inject } from '@angular/core/testing';

import { OperationalOverrideService } from './operational-override.service';

describe('OperationalOverrideService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OperationalOverrideService]
    });
  });

  it('should be created', inject([OperationalOverrideService], (service: OperationalOverrideService) => {
    expect(service).toBeTruthy();
  }));
});

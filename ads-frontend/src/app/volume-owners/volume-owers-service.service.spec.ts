import { TestBed, inject } from '@angular/core/testing';

import { VolumeOwersServiceService } from './volume-owers-service.service';

describe('VolumeOwersServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [VolumeOwersServiceService]
    });
  });

  it('should be created', inject([VolumeOwersServiceService], (service: VolumeOwersServiceService) => {
    expect(service).toBeTruthy();
  }));
});

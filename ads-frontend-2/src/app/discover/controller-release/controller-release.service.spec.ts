import { TestBed, inject } from '@angular/core/testing';

import { ControllerReleaseService } from './controller-release.service';

describe('ControllerReleaseService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ControllerReleaseService]
    });
  });

  it('should be created', inject([ControllerReleaseService], (service: ControllerReleaseService) => {
    expect(service).toBeTruthy();
  }));
});

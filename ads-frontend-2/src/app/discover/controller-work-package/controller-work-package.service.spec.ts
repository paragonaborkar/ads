import { TestBed, inject } from '@angular/core/testing';

import { ControllerWorkPackageService } from './controller-work-package.service';

describe('ControllerWorkPackageService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ControllerWorkPackageService]
    });
  });

  it('should be created', inject([ControllerWorkPackageService], (service: ControllerWorkPackageService) => {
    expect(service).toBeTruthy();
  }));
});

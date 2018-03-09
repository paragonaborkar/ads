import { TestBed, inject } from '@angular/core/testing';

import { ControllerTargetService } from './controller-target.service';

describe('ControllerTargetService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ControllerTargetService]
    });
  });

  it('should be created', inject([ControllerTargetService], (service: ControllerTargetService) => {
    expect(service).toBeTruthy();
  }));
});

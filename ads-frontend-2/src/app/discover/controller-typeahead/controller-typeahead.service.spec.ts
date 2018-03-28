import { TestBed, inject } from '@angular/core/testing';

import { ControllerTypeaheadService } from './controller-typeahead.service';

describe('ControllerTypeaheadService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ControllerTypeaheadService]
    });
  });

  it('should be created', inject([ControllerTypeaheadService], (service: ControllerTypeaheadService) => {
    expect(service).toBeTruthy();
  }));
});

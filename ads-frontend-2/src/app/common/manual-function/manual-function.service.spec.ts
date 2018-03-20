import { TestBed, inject } from '@angular/core/testing';

import { ManualFunctionService } from './manual-function.service';

describe('ManualFunctionService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ManualFunctionService]
    });
  });

  it('should be created', inject([ManualFunctionService], (service: ManualFunctionService) => {
    expect(service).toBeTruthy();
  }));
});

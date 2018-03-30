import { TestBed, inject } from '@angular/core/testing';

import { OwnerResponseService } from './owner-response.service';

describe('OwnerResponseService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OwnerResponseService]
    });
  });

  it('should be created', inject([OwnerResponseService], (service: OwnerResponseService) => {
    expect(service).toBeTruthy();
  }));
});

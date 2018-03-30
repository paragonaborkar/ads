import { TestBed, inject } from '@angular/core/testing';

import { OwnerHomeService } from './owner-home.service';

describe('OwnerHomeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OwnerHomeService]
    });
  });

  it('should be created', inject([OwnerHomeService], (service: OwnerHomeService) => {
    expect(service).toBeTruthy();
  }));
});

import { TestBed, inject } from '@angular/core/testing';

import { ApplicationConfigService } from './application-config.service';

describe('ApplicationConfigService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ApplicationConfigService]
    });
  });

  it('should be created', inject([ApplicationConfigService], (service: ApplicationConfigService) => {
    expect(service).toBeTruthy();
  }));
});

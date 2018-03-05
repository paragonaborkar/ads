import { TestBed, inject } from '@angular/core/testing';

import { AppPropsService } from './app-props.service';

describe('AppPropsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AppPropsService]
    });
  });

  it('should be created', inject([AppPropsService], (service: AppPropsService) => {
    expect(service).toBeTruthy();
  }));
});

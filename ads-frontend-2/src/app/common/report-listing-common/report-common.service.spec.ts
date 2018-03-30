import { TestBed, inject } from '@angular/core/testing';

import { ReportCommonService } from './report-common.service';

describe('ReportCommonService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ReportCommonService]
    });
  });

  it('should be created', inject([ReportCommonService], (service: ReportCommonService) => {
    expect(service).toBeTruthy();
  }));
});

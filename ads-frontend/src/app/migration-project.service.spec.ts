import { TestBed, inject } from '@angular/core/testing';

import { MigrationProjectService } from './migration-project.service';

describe('MigrationProjectService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MigrationProjectService]
    });
  });

  it('should be created', inject([MigrationProjectService], (service: MigrationProjectService) => {
    expect(service).toBeTruthy();
  }));
});

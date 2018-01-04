import { TestBed, inject } from '@angular/core/testing';

import { OwnersOfAVolumeService } from './owners-of-a-volume.service';

describe('OwnersOfAVolumeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OwnersOfAVolumeService]
    });
  });

  it('should be created', inject([OwnersOfAVolumeService], (service: OwnersOfAVolumeService) => {
    expect(service).toBeTruthy();
  }));
});

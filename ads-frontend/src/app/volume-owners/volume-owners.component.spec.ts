import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VolumeOwnersComponent } from './volume-owners.component';

describe('VolumeOwnersComponent', () => {
  let component: VolumeOwnersComponent;
  let fixture: ComponentFixture<VolumeOwnersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VolumeOwnersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VolumeOwnersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

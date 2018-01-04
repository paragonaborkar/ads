import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ScheduleVolumeModalComponent } from './schedule-volume-modal.component';

describe('MmsMigrationProjectDeleteModalComponent', () => {
  let component: ScheduleVolumeModalComponent;
  let fixture: ComponentFixture<ScheduleVolumeModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ScheduleVolumeModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ScheduleVolumeModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MmsMigrationProjectComponent } from './mms-migration-project.component';

describe('MmsMigrationProjectComponent', () => {
  let component: MmsMigrationProjectComponent;
  let fixture: ComponentFixture<MmsMigrationProjectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MmsMigrationProjectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MmsMigrationProjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

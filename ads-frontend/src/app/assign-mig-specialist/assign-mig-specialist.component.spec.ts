import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignMigSpecialistComponent } from './assign-mig-specialist.component';

describe('AssignMigSpecialistComponent', () => {
  let component: AssignMigSpecialistComponent;
  let fixture: ComponentFixture<AssignMigSpecialistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AssignMigSpecialistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AssignMigSpecialistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

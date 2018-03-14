import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ControllerWorkPackageDeleteComponent } from './controller-work-package-delete.component';

describe('ControllerTargetDeleteComponent', () => {
  let component: ControllerWorkPackageDeleteComponent;
  let fixture: ComponentFixture<ControllerWorkPackageDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ControllerWorkPackageDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ControllerWorkPackageDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

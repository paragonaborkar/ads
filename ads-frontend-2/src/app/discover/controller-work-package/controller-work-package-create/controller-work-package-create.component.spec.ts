import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ControllerWorkPackageCreateComponent } from './controller-work-package-create.component';

describe('ControllerWorkPacakageCreateComponent', () => {
  let component: ControllerWorkPackageCreateComponent;
  let fixture: ComponentFixture<ControllerWorkPackageCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ControllerWorkPackageCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ControllerWorkPackageCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

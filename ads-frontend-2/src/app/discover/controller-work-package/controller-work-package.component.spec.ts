import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ControllerWorkPackageComponent } from './controller-work-package.component';

describe('ControllerWorkPackageComponent', () => {
  let component: ControllerWorkPackageComponent;
  let fixture: ComponentFixture<ControllerWorkPackageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ControllerWorkPackageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ControllerWorkPackageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

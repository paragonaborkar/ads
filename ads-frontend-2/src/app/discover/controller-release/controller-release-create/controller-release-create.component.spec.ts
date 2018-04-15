import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ControllerReleaseCreateComponent } from './controller-release-create.component';

describe('ControllerWorkPackageCreateComponent', () => {
  let component: ControllerReleaseCreateComponent;
  let fixture: ComponentFixture<ControllerReleaseCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ControllerReleaseCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ControllerReleaseCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

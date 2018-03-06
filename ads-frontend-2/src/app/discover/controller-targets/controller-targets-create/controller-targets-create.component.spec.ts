import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ControllerTargetsCreateComponent } from './controller-targets-create.component';

describe('ControllerTargetsCreateComponent', () => {
  let component: ControllerTargetsCreateComponent;
  let fixture: ComponentFixture<ControllerTargetsCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ControllerTargetsCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ControllerTargetsCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

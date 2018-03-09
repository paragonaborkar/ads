import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ControllerTargetDeleteComponent } from './controller-targets-delete.component';

describe('ControllerTargetDeleteComponent', () => {
  let component: ControllerTargetDeleteComponent;
  let fixture: ComponentFixture<ControllerTargetDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ControllerTargetDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ControllerTargetDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ControllerTargetsComponent } from './controller-targets.component';

describe('ControllerTargetsComponent', () => {
  let component: ControllerTargetsComponent;
  let fixture: ComponentFixture<ControllerTargetsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ControllerTargetsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ControllerTargetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

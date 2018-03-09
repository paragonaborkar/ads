import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ControllerTypeaheadComponent } from './controller-typeahead.component';

describe('ControllerTypeaheadComponent', () => {
  let component: ControllerTypeaheadComponent;
  let fixture: ComponentFixture<ControllerTypeaheadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ControllerTypeaheadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ControllerTypeaheadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

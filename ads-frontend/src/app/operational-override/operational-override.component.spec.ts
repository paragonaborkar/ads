import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OperationalOverrideComponent } from './operational-override.component';

describe('OperationalOverrideComponent', () => {
  let component: OperationalOverrideComponent;
  let fixture: ComponentFixture<OperationalOverrideComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OperationalOverrideComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OperationalOverrideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

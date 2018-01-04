import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WfaMgmtComponent } from './wfa-mgmt.component';

describe('WfaMgmtComponent', () => {
  let component: WfaMgmtComponent;
  let fixture: ComponentFixture<WfaMgmtComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WfaMgmtComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WfaMgmtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

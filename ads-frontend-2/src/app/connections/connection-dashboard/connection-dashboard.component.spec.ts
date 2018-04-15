import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConnectionDashboardComponent } from './connection-dashboard.component';

describe('ConnectionDashboardComponent', () => {
  let component: ConnectionDashboardComponent;
  let fixture: ComponentFixture<ConnectionDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConnectionDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConnectionDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

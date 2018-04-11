import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiscoverDashboardComponent } from './discover-dashboard.component';

describe('DiscoverDashboardComponent', () => {
  let component: DiscoverDashboardComponent;
  let fixture: ComponentFixture<DiscoverDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiscoverDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiscoverDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

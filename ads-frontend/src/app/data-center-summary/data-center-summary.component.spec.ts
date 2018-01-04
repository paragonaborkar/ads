import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DataCenterSummaryComponent } from './data-center-summary.component';

describe('DataCenterSummaryComponent', () => {
  let component: DataCenterSummaryComponent;
  let fixture: ComponentFixture<DataCenterSummaryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DataCenterSummaryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DataCenterSummaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

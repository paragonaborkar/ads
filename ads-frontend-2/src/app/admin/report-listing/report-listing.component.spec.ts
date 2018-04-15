import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportListingComponent } from './report-listing.component';

describe('ReportListingCommonComponent', () => {
  let component: ReportListingComponent;
  let fixture: ComponentFixture<ReportListingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReportListingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportListingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

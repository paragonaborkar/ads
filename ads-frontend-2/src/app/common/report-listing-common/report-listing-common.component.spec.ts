import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportListingCommonComponent } from './report-listing-common.component';

describe('ReportListingCommonComponent', () => {
  let component: ReportListingCommonComponent;
  let fixture: ComponentFixture<ReportListingCommonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReportListingCommonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportListingCommonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

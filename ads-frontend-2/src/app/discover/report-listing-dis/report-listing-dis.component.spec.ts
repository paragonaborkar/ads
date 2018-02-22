import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportListingDisComponent } from './report-listing-dis.component';

describe('ReportListingDisComponent', () => {
  let component: ReportListingDisComponent;
  let fixture: ComponentFixture<ReportListingDisComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReportListingDisComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportListingDisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

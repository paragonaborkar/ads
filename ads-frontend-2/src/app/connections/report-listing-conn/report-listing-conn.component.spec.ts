import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportListingConnComponent } from './report-listing-conn.component';

describe('ReportListingConnComponent', () => {
  let component: ReportListingConnComponent;
  let fixture: ComponentFixture<ReportListingConnComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReportListingConnComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportListingConnComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

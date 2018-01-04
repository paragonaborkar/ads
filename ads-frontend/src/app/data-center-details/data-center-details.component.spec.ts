import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DataCenterDetailsComponent } from './data-center-details.component';

describe('DataCenterDetailsComponent', () => {
  let component: DataCenterDetailsComponent;
  let fixture: ComponentFixture<DataCenterDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DataCenterDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DataCenterDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminManualFunctionsComponent } from './admin-manual-functions.component';

describe('AdminManualFunctionsComponent', () => {
  let component: AdminManualFunctionsComponent;
  let fixture: ComponentFixture<AdminManualFunctionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminManualFunctionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminManualFunctionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

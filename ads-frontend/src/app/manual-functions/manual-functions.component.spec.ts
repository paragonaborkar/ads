import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManualFunctionsComponent } from './manual-functions.component';

describe('ManualFunctionsComponent', () => {
  let component: ManualFunctionsComponent;
  let fixture: ComponentFixture<ManualFunctionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManualFunctionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManualFunctionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

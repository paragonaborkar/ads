import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiscoverManualFunctionsComponent } from './discover-manual-functions.component';

describe('DiscoverManualFunctionsComponent', () => {
  let component: DiscoverManualFunctionsComponent;
  let fixture: ComponentFixture<DiscoverManualFunctionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiscoverManualFunctionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiscoverManualFunctionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

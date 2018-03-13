import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManualFunctionComponent } from './manual-function.component';

describe('ManualFunctionComponent', () => {
  let component: ManualFunctionComponent;
  let fixture: ComponentFixture<ManualFunctionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManualFunctionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManualFunctionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

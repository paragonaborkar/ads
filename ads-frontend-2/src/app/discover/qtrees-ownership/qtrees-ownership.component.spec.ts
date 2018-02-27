import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QtreesOwnershipComponent } from './qtrees-ownership.component';

describe('QtreesOwnershipComponent', () => {
  let component: QtreesOwnershipComponent;
  let fixture: ComponentFixture<QtreesOwnershipComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QtreesOwnershipComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QtreesOwnershipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

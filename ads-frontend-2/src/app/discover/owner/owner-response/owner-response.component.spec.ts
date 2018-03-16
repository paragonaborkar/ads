import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnerResponseComponent } from './owner-response.component';

describe('OwnerResponseComponent', () => {
  let component: OwnerResponseComponent;
  let fixture: ComponentFixture<OwnerResponseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OwnerResponseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OwnerResponseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

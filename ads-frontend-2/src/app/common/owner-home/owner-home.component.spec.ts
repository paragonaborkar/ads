import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnerHomeComponent } from './owner-home.component';

describe('OwnerHomeComponent', () => {
  let component: OwnerHomeComponent;
  let fixture: ComponentFixture<OwnerHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OwnerHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OwnerHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

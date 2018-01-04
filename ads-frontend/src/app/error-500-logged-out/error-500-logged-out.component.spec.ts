import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Error500LoggedOutComponent } from './error-500-logged-out.component';

describe('Error500LoggedOutComponent', () => {
  let component: Error500LoggedOutComponent;
  let fixture: ComponentFixture<Error500LoggedOutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Error500LoggedOutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Error500LoggedOutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

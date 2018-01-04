import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Error404LoggedOutComponent } from './error-404-logged-out.component';

describe('Error404LoggedOutComponent', () => {
  let component: Error404LoggedOutComponent;
  let fixture: ComponentFixture<Error404LoggedOutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Error404LoggedOutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Error404LoggedOutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

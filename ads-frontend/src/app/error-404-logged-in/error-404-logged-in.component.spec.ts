import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Error404LoggedInComponent } from './error-404-logged-in.component';

describe('Error404LoggedInComponent', () => {
  let component: Error404LoggedInComponent;
  let fixture: ComponentFixture<Error404LoggedInComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Error404LoggedInComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Error404LoggedInComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Error500LoggedInComponent } from './error-500-logged-in.component';

describe('Error500LoggedInComponent', () => {
  let component: Error500LoggedInComponent;
  let fixture: ComponentFixture<Error500LoggedInComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Error500LoggedInComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Error500LoggedInComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SsoLoginErrorComponent } from './sso-login-error.component';

describe('SsoLoginErrorComponent', () => {
  let component: SsoLoginErrorComponent;
  let fixture: ComponentFixture<SsoLoginErrorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SsoLoginErrorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SsoLoginErrorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

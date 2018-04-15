import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NativeUserChangePwComponent } from './native-user-change-pw.component';

describe('NativeUserChangePwComponent', () => {
  let component: NativeUserChangePwComponent;
  let fixture: ComponentFixture<NativeUserChangePwComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NativeUserChangePwComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NativeUserChangePwComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

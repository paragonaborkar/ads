import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminNativeUserComponent } from './admin-native-user.component';

describe('TableTestComponent', () => {
  let component: AdminNativeUserComponent;
  let fixture: ComponentFixture<AdminNativeUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminNativeUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminNativeUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

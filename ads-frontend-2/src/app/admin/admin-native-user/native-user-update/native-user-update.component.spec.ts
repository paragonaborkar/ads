import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NativeUserUpdateComponent } from './native-user-update.component';

describe('NativeUserUpdateComponent', () => {
  let component: NativeUserUpdateComponent;
  let fixture: ComponentFixture<NativeUserUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NativeUserUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NativeUserUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

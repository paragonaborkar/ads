import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NativeUserDeleteComponent } from './native-user-delete.component';

describe('NativeUserDeleteComponent', () => {
  let component: NativeUserDeleteComponent;
  let fixture: ComponentFixture<NativeUserDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NativeUserDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NativeUserDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

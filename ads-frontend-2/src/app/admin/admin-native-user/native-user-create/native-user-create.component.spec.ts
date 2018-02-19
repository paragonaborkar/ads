import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NativeUserCreateComponent } from './native-user-create.component';

describe('NativeUserCreateComponent', () => {
  let component: NativeUserCreateComponent;
  let fixture: ComponentFixture<NativeUserCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NativeUserCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NativeUserCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OpOverrideConfirmComponent } from './op-override-confirm.component';

describe('OpOverrideConfirmComponent', () => {
  let component: OpOverrideConfirmComponent;
  let fixture: ComponentFixture<OpOverrideConfirmComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OpOverrideConfirmComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OpOverrideConfirmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

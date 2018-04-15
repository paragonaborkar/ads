import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PropPreferencesModalComponent } from './prop-preferences-modal.component';

describe('PropPreferencesComponent', () => {
  let component: PropPreferencesModalComponent;
  let fixture: ComponentFixture<PropPreferencesModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PropPreferencesModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PropPreferencesModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

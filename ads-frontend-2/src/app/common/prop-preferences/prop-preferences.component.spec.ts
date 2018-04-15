import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PropPreferencesComponent } from './prop-preferences.component';

describe('PropPreferencesComponent', () => {
  let component: PropPreferencesComponent;
  let fixture: ComponentFixture<PropPreferencesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PropPreferencesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PropPreferencesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

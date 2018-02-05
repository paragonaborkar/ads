import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppPropertiesComponent } from './app-properties.component';

describe('AppPropertiesComponent', () => {
  let component: AppPropertiesComponent;
  let fixture: ComponentFixture<AppPropertiesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppPropertiesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppPropertiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

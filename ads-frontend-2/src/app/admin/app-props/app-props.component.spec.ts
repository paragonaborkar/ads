import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppPropsComponent } from './app-props.component';

describe('AppPropsComponent', () => {
  let component: AppPropsComponent;
  let fixture: ComponentFixture<AppPropsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppPropsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppPropsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ControllerReleaseComponent } from './controller-release.component';

describe('ControllerReleaseComponent', () => {
  let component: ControllerReleaseComponent;
  let fixture: ComponentFixture<ControllerReleaseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ControllerReleaseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ControllerReleaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

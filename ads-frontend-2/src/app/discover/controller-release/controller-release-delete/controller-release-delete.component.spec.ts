import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ControllerReleaseDeleteComponent } from './controller-release-delete.component';

describe('ControllerReleaseDeleteComponent', () => {
  let component: ControllerReleaseDeleteComponent;
  let fixture: ComponentFixture<ControllerReleaseDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ControllerReleaseDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ControllerReleaseDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

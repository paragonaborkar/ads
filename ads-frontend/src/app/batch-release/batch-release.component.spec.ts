import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BatchReleaseComponent } from './batch-release.component';

describe('BatchReleaseComponent', () => {
  let component: BatchReleaseComponent;
  let fixture: ComponentFixture<BatchReleaseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BatchReleaseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BatchReleaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

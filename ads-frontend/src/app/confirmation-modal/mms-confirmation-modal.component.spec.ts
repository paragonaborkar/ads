import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MmsConfirmationModalComponent } from './mms-confirmation-modal.component';

describe('MmsMigrationProjectDeleteModalComponent', () => {
  let component: MmsConfirmationModalComponent;
  let fixture: ComponentFixture<MmsConfirmationModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MmsConfirmationModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MmsConfirmationModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

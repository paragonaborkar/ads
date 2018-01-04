import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MigExecutionComponent } from './mig-execution.component';

describe('MigExecutionComponent', () => {
  let component: MigExecutionComponent;
  let fixture: ComponentFixture<MigExecutionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MigExecutionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MigExecutionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

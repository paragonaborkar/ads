import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReplicationPatternComponent } from './replication-pattern.component';

describe('ReplicationPatternComponent', () => {
  let component: ReplicationPatternComponent;
  let fixture: ComponentFixture<ReplicationPatternComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReplicationPatternComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReplicationPatternComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnerNotFoundComponent } from './owner-not-found.component';

describe('OwnerNotFoundComponent', () => {
  let component: OwnerNotFoundComponent;
  let fixture: ComponentFixture<OwnerNotFoundComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OwnerNotFoundComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OwnerNotFoundComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

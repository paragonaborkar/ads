import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StorageXComponent } from './storage-x.component';

describe('StorageXComponent', () => {
  let component: StorageXComponent;
  let fixture: ComponentFixture<StorageXComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StorageXComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StorageXComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

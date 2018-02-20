import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConnectionsManualFunctionsComponent } from './connections-manual-functions.component';

describe('ConnectionsManualFunctionsComponent', () => {
  let component: ConnectionsManualFunctionsComponent;
  let fixture: ComponentFixture<ConnectionsManualFunctionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConnectionsManualFunctionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConnectionsManualFunctionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

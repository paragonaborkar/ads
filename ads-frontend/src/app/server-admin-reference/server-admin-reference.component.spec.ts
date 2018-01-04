import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServerAdminReferenceComponent } from './server-admin-reference.component';

describe('ServerAdminReferenceComponent', () => {
  let component: ServerAdminReferenceComponent;
  let fixture: ComponentFixture<ServerAdminReferenceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServerAdminReferenceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServerAdminReferenceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

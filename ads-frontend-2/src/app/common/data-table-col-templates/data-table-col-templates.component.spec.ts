import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DataTableColTemplatesComponent } from './data-table-col-templates.component';

describe('DataTableColTemplatesComponent', () => {
  let component: DataTableColTemplatesComponent;
  let fixture: ComponentFixture<DataTableColTemplatesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DataTableColTemplatesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DataTableColTemplatesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

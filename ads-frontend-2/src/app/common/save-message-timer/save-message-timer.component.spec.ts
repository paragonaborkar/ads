import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SaveMessageTimerComponent } from './save-message-timer.component';

describe('SaveMessageTimerComponent', () => {
  let component: SaveMessageTimerComponent;
  let fixture: ComponentFixture<SaveMessageTimerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SaveMessageTimerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SaveMessageTimerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

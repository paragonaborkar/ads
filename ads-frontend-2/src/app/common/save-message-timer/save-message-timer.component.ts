import { Component, OnInit, Input } from '@angular/core';

import { Observable } from 'rxjs/Observable';
import { Subscription } from 'rxjs/Subscription';

@Component({
  selector: 'app-save-message-timer',
  templateUrl: './save-message-timer.component.html',
  styleUrls: ['./save-message-timer.component.scss']
})
export class SaveMessageTimerComponent implements OnInit {
  private subscription: Subscription;
  private timer: Observable<any>;

  @Input() showSuccessMsg: string;
  showSuccess: boolean= false; 

  constructor() { }

  ngOnInit() { }

  ngOnDestroy() {
    if ( this.subscription && this.subscription instanceof Subscription) {
      this.subscription.unsubscribe();
    }
  }

  public setSuccessTimer(){
    // set to true to show div
    this.showSuccess = true;

    this.timer        = Observable.timer(5000); // 5000 millisecond means 5 seconds
    this.subscription = this.timer.subscribe(() => {
        // set to false to hide div from view after 5 seconds
        this.showSuccess = false;
    });
  }


}

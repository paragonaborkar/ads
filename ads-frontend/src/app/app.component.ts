import { Component } from '@angular/core';
/*import {Keepalive} from 'ng2-idle-keepalive/core';*/

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  // title = 'app works!';
   // when this component is loaded, keepalive will be injected, configured, and start pinging right away
  /*constructor( private keepalive: Keepalive) {
  	console.log("In APp COmponent");
    keepalive.onPing.subscribe(() => {
      console.log('Keepalive.ping() called!');
    });
    keepalive.interval(5);*/

}

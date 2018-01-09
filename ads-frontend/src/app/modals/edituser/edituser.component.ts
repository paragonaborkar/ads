import { Component, OnInit } from '@angular/core';
import { EventEmitter, Input, OnChanges, Output, SimpleChanges} from '@angular/core';


@Component({
  selector: 'app-edituser',
  templateUrl: './edituser.component.html',
  styleUrls: ['./edituser.component.css']
})
export class EdituserComponent implements OnInit {
  @Output() yes = new EventEmitter();
  @Output() cancel = new EventEmitter();
  @Input() User: any;
  confirmPassword: any
  constructor() {
  }

  ngOnInit() {
  }
  okay() {
   if(this.User.enabled == 'Yes') {
     this.User.enabled = 1;
   } else {
     this.User.enabled = 0;
   }
    console.log('user Edit Form == > ' + JSON.stringify(this.User));
    this.yes.emit(this.User);
  }

  close(event) {
    this.cancel.emit(event);
  }

}

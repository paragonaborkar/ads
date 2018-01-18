import { Component, OnInit } from '@angular/core';
import { EventEmitter, Input, OnChanges, Output, SimpleChanges} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';



@Component({
  selector: 'app-edituser',
  templateUrl: './edituser.component.html',
  styleUrls: ['./edituser.component.css']
})
export class EdituserComponent implements OnInit {
  @Output() yes = new EventEmitter();
  @Output() cancel = new EventEmitter();
  @Input() User: any;
  confirmPassword: String;
  roleArray =  ['Migration Specialist', 'Storage Owner', 'ADS Admin'] ;
  constructor() {

  }

  ngOnInit() {
  }
  okay() {
  console.log(this.User);
   if(this.User.enabled == 'Yes') {
     this.User.enabled = 1;
   } else {
     this.User.enabled = 0;
   }
    console.log('user Edit Form == > ' + JSON.stringify(this.User));
    if(this.confirmPassword === this.User.password){
      console.log('COmpared yEs password')
      this.yes.emit(this.User);
    } else {
      window.alert('Passwords did not match');
    }
  }

  close(event) {
    this.cancel.emit(event);
  }

}

import { Component, ViewChild, OnInit } from '@angular/core';
import { EventEmitter, Input, OnChanges, Output, SimpleChanges} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ModalDirective } from 'ngx-bootstrap/modal';


@Component({
  selector: 'app-updateuser',
  templateUrl: './edituser.component.html',
  styleUrls: ['./edituser.component.css']
})
export class UpdateUserComponent implements OnInit {
  @ViewChild('updateModal') public updateModal:ModalDirective;
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
      this.yes.emit(this.User);
      this.updateModal.hide();
  }

  close(event) {
    this.cancel.emit(event);
    this.updateModal.hide();
  }

}

import { Component, ViewChild, OnInit } from '@angular/core';
import { EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ModalDirective } from 'ngx-bootstrap/modal';


import { UserAdminService } from '../user-admin.service';

@Component({
  selector: 'app-updateuser',
  templateUrl: './edituser.component.html',
  styleUrls: ['./edituser.component.css']
})
export class UpdateUserComponent implements OnInit {

  @ViewChild('updateModal') public updateModal: ModalDirective;
  @Output() saved = new EventEmitter();
  @Output() cancel = new EventEmitter();
  @Input() User: any;

  //FIXME: Get these values from a REST call.
  roleArray = ['Migration Specialist', 'Storage Owner', 'ADS Admin'];

  constructor(private usersService: UserAdminService) { }

  ngOnInit() {
  }


  save() {
    console.log(this.User);
    if (this.User.enabled == 'Yes') {
      this.User.enabled = 1;
    } else {
      this.User.enabled = 0;
    }
    console.log('user Edit Form == > ' + JSON.stringify(this.User));



    this.usersService.update(this.User).subscribe(function (resp) {
      this.getUserNatives();
    }, function (error) {
      alert('Error to update user; ');
      console.log(this.User);
    });


    this.saved.emit(this.User);
    // this.updateModal.hide();
  }

  close(event) {
    this.cancel.emit(event);
  }

}

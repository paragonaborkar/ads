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

  roleArray = [];

  constructor(private usersService: UserAdminService) { }

  ngOnInit() {
     // This method is to get all the values from user_role table
     this.usersService.getUserRoles().subscribe(
      userRoles => {
        console.log("userRoles");
        console.log(userRoles);
        this.roleArray = userRoles._embedded.userRoles;
      });

  }

  save() {
    console.log("Edit modal save()");
    console.log(this.User);

    // TODO: Handle an error and display a message in the modal.
    this.usersService.update(this.User).subscribe(
      response => {
        console.log(response);
        console.log("Saved in modal");
        this.saved.emit(this.User);
      });

  }

  close() {
    console.log("Calling close");
    this.cancel.emit();
  }

}

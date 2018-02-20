import { Component, ViewChild, OnInit } from '@angular/core';
import { EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ModalDirective } from 'ngx-bootstrap/modal';


import { UserAdminService } from '../user-admin.service';

@Component({
  selector: 'native-user-update',
  templateUrl: './native-user-update.component.html',
  styleUrls: ['./native-user-update.component.css']
})
export class NativeUserUpdateComponent implements OnInit {

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

      // This method is to get all the values from user_role table
     this.usersService.getUser(this.User._links.self.href).subscribe(
      user => {
        console.log("user");
        console.log(user);
      });

       // This method is to get all the values from user_role table
     this.usersService.getUserRole(this.User._links.userRole.href).subscribe(
      userRole => {
        console.log("userRole");
        console.log(userRole);
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

import { Component, OnInit } from '@angular/core';
import { EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';

import { UserAdminService } from '../user-admin.service';
import { AdsErrorService } from '../../../common/ads-error.service';


@Component({
  selector: 'native-user-create',
  templateUrl: './native-user-create.component.html',
  styleUrls: ['./native-user-create.component.scss']
})
export class NativeUserCreateComponent implements OnInit {
  public errorMessage = "";

  @Output() saved = new EventEmitter();
  @Output() cancel = new EventEmitter();

  passwordConfirm: String;
  doPasswordsMatch = true;

  roleArray = [];

  public user: any = {};

  constructor(private usersService: UserAdminService, private errorService: AdsErrorService) { }

  ngOnInit() {
    this.user.enabled = "true";

    // this.user.userName="asd user";
    // this.user.email="asd@asd.com";
    // this.user.firstName="asd";
    // this.user.lastName="asd";
    // this.user.password="123";
    // this.user.userRole="http://localhost:8080/userRoles/2";
    
    

    // This method is to get all the values from user_role table
    this.usersService.getUserRoles().subscribe(
      userRoles => {
        console.log("userRoles");
        console.log(userRoles);
        this.roleArray = userRoles._embedded.userRoles;
      });
  }

/*
  checkForMatchingPasswords() {
    if (this.confirmPassword === this.user.password) {
      if (this.user.firstName != null) {
        if (this.user.lastName != null) {
          if (this.user.email != null) {
            console.log('COmpared yEs password')
            return true;
          }
        }
      }
      else {
        window.alert('please enter all the fields');
      }

    }
    else {
      window.alert('Passwords did not match');
    }
    return false;
  }
*/

  comparePasswords() {
    console.log(this.user.password, this.passwordConfirm);
    this.doPasswordsMatch = this.user.password === this.passwordConfirm;
    console.log(this.doPasswordsMatch);
  }


  save() {
    console.log("create modal save()");
    console.log(this.user);

    // TODO: Handle an error and display a message in the modal.
    this.usersService.addUser(this.user).subscribe(
      response => {
        console.log(response);
        console.log("Added in modal");
        this.user = {};
        this.saved.emit(this.user);
      },  err => {

        if (err.status == "409") {
          this.errorMessage = "User Name already exsits. Pick another User Name.";
        } else {
          // Get the ADS configured error message to display.
          this.errorMessage = this.errorService.processError(err, "createNativeUser", "POST"); 
        }
      });

  }

  close() {
    this.user = {};
    console.log("Calling close");
    this.cancel.emit();
  }
}

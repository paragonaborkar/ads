
import { Component, OnInit } from '@angular/core';
import { EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-adduser',
  templateUrl: './adduser.component.html',
  styleUrls: ['./adduser.component.scss']
})
export class AddUserComponent implements OnInit {

  @Output() yes = new EventEmitter();
  @Output() cancel = new EventEmitter();
  @Input() Error: any;
  confirmPassword: String;
  doesPasswordMatch = true;

  roleArray = ['Migration Specialist', 'Storage Owner', 'ADS Admin'];
  public user: any = {};

  constructor() { }

  ngOnInit() {
  }

  /**
   * This method is to add the user
   * @param
   */
  okay() {
    if (this.user.enabled == true) {
      this.user.enabled = 1;
    }
    else {
      this.user.enabled = 0;
    }

    if (this.confirmPassword === this.user.password) {
      if (this.user.firstName != null) {
        if (this.user.lastName != null) {
          if (this.user.email != null) {
            console.log('COmpared yEs password')
            this.yes.emit(this.user);

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
  }
  /**
   * This method is to close the adduser modal
   * @param event
   */

  close(event) {
    this.cancel.emit(event);
  }

  /**
   * This method is to compare passwords
   *
   */

  comparePasswords() {
    console.log(this.user.password, this.confirmPassword);
    this.doesPasswordMatch = this.user.password === this.confirmPassword;
    console.log(this.doesPasswordMatch);
  }

  onSubmit({ value, valid }: { value: any, valid: boolean }) {

  }
}

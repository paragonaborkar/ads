// <reference path="../../../../node_modules/@angular/core/src/metadata/directives.d.ts"/>
import { Component, OnInit } from '@angular/core';
import { EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-adduser',
  templateUrl: './adduser.component.html',
  styleUrls: ['./adduser.component.css']
})
export class AdduserComponent implements OnInit {

  @Output() yes = new EventEmitter();
  @Output() cancel = new EventEmitter();
  @Input() Error: any;
  confirmPassword: String;
  doesPasswordMatch = true;

  public User: any = {};
  public user: any = {};

  constructor() { }

  ngOnInit() {
  }

  /*ngOnChanges(changes: SimpleChanges) {
    if (!changes.Error.currentValue.login) {
      this.initEmptyUser();
    }
  }

  initEmptyUser() {

  }*/

  okay() {
    // this.User.password = btoa(this.User.password);
    console.log('User Password: ' + this.User.password);
    console.log('role' + this.User.role);
    this.yes.emit(this.User);
  }
  close(event) {
    this.cancel.emit(event);
  }

  comparePasswords() {
    console.log(this.User.password, this.confirmPassword);
    this.doesPasswordMatch = this.User.password === this.confirmPassword;
    console.log(this.doesPasswordMatch);
  }

  onSubmit({ value, valid }: { value: any, valid: boolean }) {
    if (!valid) {
    } else {
      console.log(value);
      this.yes.emit(value);
    }
  }
}

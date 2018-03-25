import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

import { UserAdminService } from '../user-admin.service';
import { AdsErrorService } from '../../../common/ads-error.service';

@Component({
  selector: 'app-native-user-change-pw',
  templateUrl: './native-user-change-pw.component.html',
  styleUrls: ['./native-user-change-pw.component.scss']
})
export class NativeUserChangePwComponent implements OnInit {
  public errorMessage = "";

  @Output() changePw = new EventEmitter();
  @Output() cancel = new EventEmitter();
  @Input() User: any;
  
  passwordConfirm: String;
  doPasswordsMatch = true;

  constructor(private usersService: UserAdminService, private errorService: AdsErrorService) { }

  ngOnInit(): void { }

  changePwConfirmed() {

    let updatedPw = {};
    updatedPw["_links"] = this.User._links;
    updatedPw["password"]= this.User.password;
    
    this.usersService.changePassword(updatedPw).subscribe(
      response => {
        console.log(response);
        this.changePw.emit(this.User);
      },
      err => {
        // Get the ADS configured error message to display.
        this.errorMessage = this.errorService.processError(err, "changePasswordNativeeUser", "PATCH");
      }
    );
  }

  close() {
    this.cancel.emit();
  }

  comparePasswords() {
    console.log(this.User.password, this.passwordConfirm);
    this.doPasswordsMatch = this.User.password === this.passwordConfirm;
    console.log(this.doPasswordsMatch);
  }

}

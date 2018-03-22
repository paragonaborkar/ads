import { Component, OnInit } from '@angular/core';


import { SessionHelper } from '../../auth/session.helper';
import { UserService } from '../../common/login/user.service';
import { Globals } from '../../globals';


@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  public firstName: String;
  public lastName: String;
  public email: String;
  nativeUserId:number;
  corpUserId:number;

  constructor(private userService: UserService, private sessionHelper: SessionHelper, private globals: Globals) {

  }

  ngOnInit() {
   
  }

  ngDoCheck() {
    if (this.sessionHelper.isAuthenticated()) {
      // console.log(this.globals.appModulesAvailable);
      let tokenInfo = this.sessionHelper.getToken();

      this.firstName = tokenInfo.firstName;
      this.lastName = tokenInfo.lastName;
      this.email = tokenInfo.email;

      this.nativeUserId = tokenInfo.nativeUserId;
      this.corpUserId = tokenInfo.corpUserId;
    }
  }

  isLogedIn() {
    return this.sessionHelper.isAuthenticated();
  }

  logout() {
    this.userService.logout();
  }

}

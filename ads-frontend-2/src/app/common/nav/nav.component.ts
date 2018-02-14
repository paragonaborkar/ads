import { Component, OnInit } from '@angular/core';


import { SessionHelper } from '../../auth/session.helper';
import { UserService } from '../../common/login/user.service';
import { Globals} from '../../globals';


@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  public firstName:String;
  public lastName:String;
  public email:String;

  constructor(private userService: UserService, private _sessionHelper: SessionHelper, private globals: Globals) {
    console.log(globals.appModulesAvailable);
    let tokenInfo = _sessionHelper.getToken();

    this.firstName =  tokenInfo.firstName;
    this.lastName=  tokenInfo.lastName;
    this.email=  tokenInfo.email;
  }

  ngOnInit() {

  }

  isLogedIn() {
    return this._sessionHelper.isAuthenticated();
  }

  logout() {
    this.userService.logout();
  }

}

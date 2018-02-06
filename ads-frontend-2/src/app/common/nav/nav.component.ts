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

  constructor(private userService: UserService, private _sessionHelper: SessionHelper, private globals: Globals) {
    console.log(globals.appModulesAvailable);
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

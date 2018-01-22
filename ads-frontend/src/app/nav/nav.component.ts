import { Component, OnInit } from '@angular/core';

import { SessionHelper } from '../core/session.helper';
import { UserService } from '../login/user.service';
import {Globals} from '../globals';


@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {
  clientName: string = "JPMorgan Chase & Co.";

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

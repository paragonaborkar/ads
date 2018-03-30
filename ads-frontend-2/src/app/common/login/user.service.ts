import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelper } from 'angular2-jwt';

import { SessionHelper } from '../../auth/session.helper';
import {Globals} from '../../globals';

@Injectable()
export class UserService {
  jwtHelper: JwtHelper = new JwtHelper();
  accessInformation: string;
  isAdmin: boolean;

  constructor(private _router: Router, private _sessionHelper: SessionHelper, private globals: Globals) {
  }

  login(accessInformation: any) {
    console.log(accessInformation);
    this.accessInformation = accessInformation;
    this._sessionHelper.setToken(accessInformation);
    this.globals.appModulesAvailable = accessInformation.ads_modules;
  }

  logout() {
    this.accessInformation = null;
    this.isAdmin = false;
    this._sessionHelper.removeAll();

    // redirects to login page on logout
    this._router.navigate(['/']);
  }

  isAdminUser(): boolean {
    return this.isAdmin;
  }

  isUser(): boolean {
    return this.accessInformation && !this.isAdmin;
  }
}

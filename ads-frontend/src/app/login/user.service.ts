import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelper } from 'angular2-jwt';
import { SessionHelper } from '../core/session.helper';

@Injectable()
export class UserService {
  jwtHelper: JwtHelper = new JwtHelper();
  accessToken: string;
  isAdmin: boolean;

  constructor(private _router: Router, private _sessionHelper: SessionHelper) {
  }

  login(accessToken: any) {
  this.accessToken = accessToken;
  this._sessionHelper.setToken(accessToken);
  }

  logout() {
    this.accessToken = null;
    this.isAdmin = false;

    this._sessionHelper.removeAll();
    //console.log("sessionStorage: ", sessionStorage);
    //console.log("sessionStorage: ", sessionStorage.length);
    // redirects to login page on logout
    this._router.navigate(['/']);
  }

  isAdminUser(): boolean {
    return this.isAdmin;
  }

  isUser(): boolean {
    return this.accessToken && !this.isAdmin;
  }
}

import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { tokenNotExpired } from 'angular2-jwt';

import { SessionHelper } from '../core/session.helper';
import { UserService } from '../login/user.service';
import {Globals} from '../globals';


@Injectable()
export class AuthGuard implements CanActivate {
  constructor(private router: Router, private userService: UserService,  private _sessionHelper: SessionHelper, private globals: Globals) {
  }

  /**
  * Method to secure all URL's
  */
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if (this._sessionHelper.isAuthenticated()) { 
      console.log(this._sessionHelper);
      console.log(this._sessionHelper.getToken());

      // Set the licensed modules in a global and use them anywhere as needed.
      var loginInfo = this._sessionHelper.getToken();
      this.globals.appModulesAvailable = loginInfo.ads_modules;

    	console.log("Authorized");


      return true;
    } else {
    	console.log("Unauthorized");
      this.router.navigate(['login'], {queryParams: {redirectTo: state.url}});
      return false;
    }
  }
}

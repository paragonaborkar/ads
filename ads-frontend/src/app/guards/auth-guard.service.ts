import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { tokenNotExpired } from 'angular2-jwt';
import { SessionHelper } from '../core/session.helper';
import { UserService } from '../login/user.service';
import { ACCES_TOKEN_NAME } from '../login/auth.constant';

@Injectable()
export class AuthGuard implements CanActivate {
  constructor(private router: Router, private userService: UserService, 
    private _sessionHelper: SessionHelper) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if (this._sessionHelper.isAuthenticated()) { 
    	console.log("Authorized");
      return true;
    } else {
    	console.log("Unauthorized");
      this.router.navigate(['login'], {queryParams: {redirectTo: state.url}});
      return false;
    }
  }
}

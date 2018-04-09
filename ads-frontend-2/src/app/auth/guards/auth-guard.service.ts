import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { AuthService } from './auth.service';

import { JwtHelperService } from '@auth0/angular-jwt';
import { Globals } from '../../globals';

@Injectable()
export class AuthGuard implements CanActivate {
  constructor(public auth: AuthService, public router: Router, private globals: Globals, private jwtHelperService: JwtHelperService) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if (!this.auth.isAuthenticated()) {
      this.router.navigate(['login'], {queryParams: {redirectTo: state.url}});
      return false;
    }

    const myRawToken = localStorage.getItem('access_token');
    const decodedToken = this.jwtHelperService.decodeToken(myRawToken);
    const expirationDate =  this.jwtHelperService.getTokenExpirationDate(myRawToken);
    const isExpired =  this.jwtHelperService.isTokenExpired(myRawToken);
      
    this.globals.appModulesAvailable = decodedToken.ads_modules;
    
    return true;
  }
}

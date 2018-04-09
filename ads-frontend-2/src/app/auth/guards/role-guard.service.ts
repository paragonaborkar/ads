import { Injectable } from '@angular/core';
import { Router,  CanActivate,  ActivatedRouteSnapshot, RouterStateSnapshot} from '@angular/router';

import { AuthService } from './auth.service';
import { JwtHelperService } from '@auth0/angular-jwt';

import { HttpClient, HttpErrorResponse } from '@angular/common/http';

// Don't use Promise, use Observable...
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { Globals } from '../../globals';

@Injectable()
export class RoleGuard implements CanActivate {
  constructor(private auth: AuthService, private router: Router, private jwtHelper: JwtHelperService, private global: Globals, private http: HttpClient,) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean>  {
    // this will be passed from the route config on the data property
    const expectedRole = route.data.expectedRole;
    const myRawToken = localStorage.getItem('access_token');
    const decodedToken = this.jwtHelper.decodeToken(myRawToken);
    
    if (!this.auth.isAuthenticated() || decodedToken.role !== expectedRole) {
      return this.http.get(this.global.apiUrl +"/ssoUrl?redirectTo=" + state.url)
        .map((res: Response) => {
          window.location.href = res["ssoRedirectUrl"];
          return false;
        });
     
    }
    return  Observable.of(true);
  }

}
import { Injectable } from '@angular/core';
import { Router,  CanActivate,  ActivatedRouteSnapshot, RouterStateSnapshot} from '@angular/router';

import { AuthService } from './auth.service';
import { JwtHelperService } from '@auth0/angular-jwt';

import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { SessionHelper } from '../../auth/session.helper';

// Don't use Promise, use Observable...
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { Globals } from '../../globals';

@Injectable()
export class RoleGuard implements CanActivate {
  constructor(private auth: AuthService, private router: Router, private jwtHelper: JwtHelperService, private global: Globals, private http: HttpClient, private sessionHelper: SessionHelper) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean>  {
    // this will be passed from the route config on the data property
    const expectedRole = route.data.expectedRole;   
    
    if (!this.auth.isAuthenticated() || this.sessionHelper.get("userRole") !== expectedRole) {
      // When using SSO Circle, here we are passing the corpUserId because we only login as 1 user in SSO Circle.
      // If enterprise service is available, this should be updated.
      // return this.http.get(this.global.apiUrl + "/ssoUrl?redirectTo=" + state.url + "&userId=" +  this.sessionHelper.get("corpUserId"))
      
      console.log("state.url:" + state.url);
      // return this.http.get(this.global.apiUrl + "/ssoUrl?redirectTo=" + state.url)
      return this.http.get(this.global.apiUrl + "/ssoUrl?redirectTo=" + state.url + "&userId=" +  this.sessionHelper.get("corpUserId"))
        .map((res: Response) => {
          window.location.href = res["ssoRedirectUrl"];
          return false;
        });
     
    }
    return  Observable.of(true);
  }

}
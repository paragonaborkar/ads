import { Injectable } from '@angular/core';

import {HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, HttpHeaders,  } from '@angular/common/http';
// import { Http, Response, RequestOptions, Headers, ResponseContentType} from '@angular/http';
//import { AuthService } from './auth/auth.service';

import { TokenService } from '../token.service';
import { Observable } from 'rxjs/Observable';
import { SessionHelper } from '../core/session.helper';

@Injectable()
export class TokenInterceptor  implements HttpInterceptor {
  
  constructor(private tokenService:TokenService, private  _sessionHelper: SessionHelper) {}

  
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    
    console.log("INTERCEPTED !!!!!!!!!!!!!!!!!!!!!!!!!");
    
    console.log(this._sessionHelper.getToken().access_token);

	const headers = new HttpHeaders()
           .set('Content-Type', 'application/json')
           // .set('Authorization', `Bearer ${this.tokenService.token()}`);
           .set('Authorization', `Bearer this._sessionHelper.getToken().access_token`);


    // request = request.clone({
    //   setHeaders:
    //   {
    //     Authorization: `Bearer ${this.tokenService.token()}`
    //   }
    // });


    request = request.clone({headers:headers});
    // request = request.clone({headers:this.tokenService.token()});
   
    return next.handle(request);
  }
}
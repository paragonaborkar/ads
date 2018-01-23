import { Injectable } from '@angular/core';

import {HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, HttpHeaders } from '@angular/common/http';

//import { AuthService } from './auth/auth.service';
// import { SessionHelper } from './session.helper';
import { TokenService } from '../token.service';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {
  
  constructor(private tokenService:TokenService) {}

  
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    
    console.log("INTERCEPTED !!!!!!!!!!!!!!!!!!!!!!!!!");
    

	const headers = new HttpHeaders()
           .set('Content-Type', 'application/json; charset=utf-8')
           .set('Authorization', `Bearer ${this.tokenService.token()}`);

    // request = request.clone({
    //   setHeaders:
    //   {
    //     Authorization: `Bearer ${this.tokenService.token()}`
    //   }
    // });

    request = request.clone({headers:headers});

   
    return next.handle(request);
  }
}
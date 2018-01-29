import { Injectable } from '@angular/core';

import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { SessionHelper } from './session.helper';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  constructor(private _sessionHelper: SessionHelper) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    console.log("INTERCEPTED !!!!!!!!!!!!!!!!!!!!!!!!!");
    console.log(this._sessionHelper.getToken().access_token);
    
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Authorization', `Bearer ${this._sessionHelper.getToken().access_token}`);

    request = request.clone({ headers: headers });

    return next.handle(request);
  }
}
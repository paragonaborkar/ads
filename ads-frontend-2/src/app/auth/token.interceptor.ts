import { Injectable } from '@angular/core';

import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { SessionHelper } from './session.helper';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  constructor(private _sessionHelper: SessionHelper) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    // console.log("INTERCEPTED !!!!!!!!!!!!!!!!!!!!!!!!!");
    // console.log(this._sessionHelper.getToken().access_token);
    // console.log("request.headers orig", request.headers);

    let headers = new HttpHeaders();

    if (!request.headers.has("AdsFile")) {
      headers = headers.append('content-type', 'application/json');
      headers = headers.append('authorization', `Bearer ${this._sessionHelper.getToken().access_token}`);   // use ` for Bearer, not '

      request = request.clone({ headers: headers });

      return next.handle(request);
      
    } else {
      headers = headers.append('authorization', `Bearer ${this._sessionHelper.getToken().access_token}`);   // use ` for Bearer, not '

      request = request.clone({ headers: headers });

      return next.handle(request);
    }

  }
}
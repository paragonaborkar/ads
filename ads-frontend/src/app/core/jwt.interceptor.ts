/* ********************************* 

THIS FILE IS NOT IN USE!

WE NEED TO ASSESS IF THIS IS A BETTER WAY TO HANDLE REDIRECTS.

********************************* */

import { Injectable } from '@angular/core';
import {HttpRequest, HttpResponse, HttpErrorResponse, HttpHandler, HttpEvent, HttpInterceptor, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/do';

import { TokenService } from '../token.service';


export class JwtInterceptor implements HttpInterceptor {
	
  // constructor(public auth: AuthService) {}
  constructor(private tokenService:TokenService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    
    return next.handle(request).do((event: HttpEvent<any>) => {
      if (event instanceof HttpResponse) {
        // do stuff with response if you want
      }
    }, (err: any) => {
      if (err instanceof HttpErrorResponse) {
        if (err.status === 401) {
          // redirect to the login route
          // or show a modal
        }
      }
    });
  }
}
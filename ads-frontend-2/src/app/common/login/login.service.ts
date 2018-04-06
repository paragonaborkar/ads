import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';

import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { SessionHelper } from '../../auth/session.helper';
import 'rxjs/add/operator/map';
import {Globals} from '../../globals';

@Injectable()
export class LoginService {
  static AUTH_TOKEN = '/oauth/token';
  private loginServiceUrl = '';
  private TOKEN_AUTH_USERNAME = '';
  private TOKEN_AUTH_PASSWORD = '';
  private AUTH_TOKEN = '';
   
  constructor(private http: Http, private _sessionHelper: SessionHelper, private globals: Globals) {
    this.loginServiceUrl = globals.apiUrl;
    this.TOKEN_AUTH_USERNAME = globals.TOKEN_AUTH_USERNAME;
    this.TOKEN_AUTH_PASSWORD = globals.TOKEN_AUTH_PASSWORD;
  }

  login(username: string, password: string) {
    const body = `username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}&grant_type=password`;
    const headers = new Headers();
    
    headers.append('Content-Type', 'application/x-www-form-urlencoded');
    headers.append('Accept', 'application/json');
    headers.append('Authorization', 'Basic ' + btoa(this.TOKEN_AUTH_USERNAME + ':' + this.TOKEN_AUTH_PASSWORD));
    
    return this.http.post(this.loginServiceUrl + LoginService.AUTH_TOKEN, body, {headers})
    .map(res => res.json())
    .map((res: any) => {
      if (res.access_token) {

        return res;
      }
      return null;
    });
  }
} 
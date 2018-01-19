import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SessionHelper } from '../core/session.helper';
import {TOKEN_AUTH_PASSWORD, TOKEN_AUTH_USERNAME} from './auth.constant';
import 'rxjs/add/operator/map';
import {environment} from "../../environments/environment";
import {Globals} from '../globals';

@Injectable()
export class LoginService {
  static AUTH_TOKEN = '/oauth/token';
  private loginServiceUrl = '';

  constructor(private http: Http, private _sessionHelper: SessionHelper, private globals: Globals) {
    this.loginServiceUrl = globals.apiUrl;
  }

    login(username: string, password: string) {
    const body = `username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}&grant_type=password`;
    const headers = new Headers();
    headers.append('Content-Type', 'application/x-www-form-urlencoded');
    headers.append('Accept', 'application/json');
    headers.append('Authorization', 'Basic ' + btoa(TOKEN_AUTH_USERNAME + ':' + TOKEN_AUTH_PASSWORD));
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
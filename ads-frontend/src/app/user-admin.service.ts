import { SpringRestResponse } from './spring-rest-response';
import { Injectable } from '@angular/core';
import { Headers, Http, Response } from '@angular/http';
import { TokenService } from './token.service';


// Don't use Promise, use Observable...
import { Observable } from 'rxjs/Observable';
import { RequestOptions } from '@angular/http';
import { SessionHelper } from './core/session.helper';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';



@Injectable()
export class UserAdminService {

  constructor(private http: Http, private tokenService:TokenService, private _sessionHelper:SessionHelper) { }

  private serviceUrl = 'http://localhost:8080/userNatives';
  private headers = new Headers({ 'Content-Type': 'application/json' });

  getUserNatives() {
     let authToken = this._sessionHelper.getToken().access_token;
         const headers = new Headers();
         //headers.append('Content-Type', 'application/json');
         headers.append('Authorization', `bearer ${authToken}`);
         let options = new RequestOptions({ headers: headers });
    // //let options = this.tokenService.token();
    return this.http.get(this.serviceUrl, options)
      .map((res: Response) => (res.json()))
      .catch(this.handleError);

  }

  private handleError(error: Response | any) {
    // In a real world app, you might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }

    console.error(errMsg);
    return Observable.throw(errMsg);
  }
  /**
   * This method is to add user  in the usernatives table
   * @param obj
   */

  addUser(obj): Observable<any> {
    console.log('User Object in Add User - ', obj);
    let authToken = this._sessionHelper.getToken().access_token;
         const headers = new Headers();
         //headers.append('Content-Type', 'application/json');
         headers.append('Authorization', `bearer ${authToken}`);
         let options = new RequestOptions({ headers: headers });

    return this.http.post(this.serviceUrl, obj,options).map(function (response) {
      return response.json();
    }).catch(function (err) {
      return err;
    });
  }
  /**
   * This method is to edit user from usernatives table
   * @param user
   */
  update(user: Object): Observable<Object> {
    const url = user['_links']['self']['href'];
    let options = this.tokenService.token();
    return this.http
      .put(url, JSON.stringify(user), options)
      .map((res: Response) => res.json() as Object)
      // .map(() => user)
      .catch(this.handleError);
  }
  /**
   * This method is to delete user from user natives table
   * @param user
   */

  delete(user: Object): Observable<any> {
    console.log(user);
    let options = this.tokenService.token();
    
    const url = user['_links']['self']['href'];
    console.log('Calling delete for URL:' + url);
    return this.http.delete(url, options)
      .map(() => null)
      .catch(this.handleError);
  }


}
